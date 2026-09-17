/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONTROLLERS.FAMILIA_BOTANICA;

import com.nexus.demo.DTOS.GLOBAL.BasicResponseDto;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.FAMILIA_BOTANICA.FamiliaBotanicaDtoReq;
import com.nexus.demo.DTOS.RESPONSE.FAMILIA_BOTANICA.FamiliaBotanicaAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.FAMILIA_BOTANICA.FamiliaBotanicaDetailsDtoResp;
import com.nexus.demo.SERVICES.FAMILIA_BOTANICA.IFamiliaBotanicaAdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author luis
 */
@Tag(name = "Administración de las familias botanicas",
        description = "Módulo encargado  ")
@RequestMapping(value = "/api/v1/familias-botanicas/admin")
@RestController
public class FamiliaBotanicaAdminController {

    private IFamiliaBotanicaAdminService familiaBotanicaAdminService;

    @Autowired
    public FamiliaBotanicaAdminController(IFamiliaBotanicaAdminService familiaBotanicaAdminService) {
        this.familiaBotanicaAdminService = familiaBotanicaAdminService;
    }

    @Operation(description = "Operación encaragda de crear una famlia botanica en el sistema",
            method = "POST")
    @PostMapping()
    public ResponseEntity<BasicResponseDto> create(
            @Valid
            @RequestBody(required = true) FamiliaBotanicaDtoReq familiaBotanicaDtoReq) {

        familiaBotanicaAdminService.create(familiaBotanicaDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("Se ha creado correctamente la familia botanica"));

    }

    @Operation(description = "Operación encargada de editar datos de una familia botanica",
            method = "PUT")
    @PutMapping(value = "/{id}")
    public ResponseEntity<BasicResponseDto> updateById(
            @PathVariable(
                    name = "id",
                    required = true) Long id,
            @Valid
            @RequestBody(required = true) FamiliaBotanicaDtoReq familiaBotanicaDtoReq
    ) {

        familiaBotanicaAdminService.updateById(id, familiaBotanicaDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("La familia botanica ha sido actualizada correctamente"));

    }

    @Operation(description = "Operación encargada de mostrar las familias botanicas el sistema",
            method = "GET")
    @GetMapping()
    public ResponseEntity<PageResponse<FamiliaBotanicaAdminDtoResp>> getAll(
            @RequestParam(
                    name = "nombre",
                    required = false
            ) String nombre,
            @RequestParam(
                    name = "active",
                    required = false) Boolean active,
            Pageable pageable
    ) {

        return ResponseEntity
                .ok()
                .body(familiaBotanicaAdminService.getAll(nombre, active, pageable));
    }

    @Operation(description = "Operación encargada de mostar los detalles de una familia botanica",
            method = "GET")
    @GetMapping(value = "/{id}/details")
    public ResponseEntity<FamiliaBotanicaDetailsDtoResp> getDetailsByID(@PathVariable(
            name = "id",
            required = true) Long id) {

        return ResponseEntity
                .ok()
                .body(familiaBotanicaAdminService.getDetailsById(id));
    }

}
