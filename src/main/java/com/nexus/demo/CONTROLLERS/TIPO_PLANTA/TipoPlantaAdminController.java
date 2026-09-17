/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONTROLLERS.TIPO_PLANTA;

import com.nexus.demo.DTOS.GLOBAL.BasicResponseDto;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.TIPO_PLANTA.TipoPlantaAdminDtoReq;
import com.nexus.demo.DTOS.REQUEST.TIPO_PLANTA.TipoPlantaDetailsDtoResp;
import com.nexus.demo.DTOS.RESPONSE.TIPO_PLANTA.TipoPlantaAdminDtoResp;
import com.nexus.demo.SERVICES.TIPO_PLANTAS.ITipoPlantaAdminService;
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
@Tag(name = "Administración de tipo de plantas",
        description = "Módulo encargado de administar distintas operaciones sobre los tipos de plantas del sistema.")
@RequestMapping(value = "/api/v1/admin/tipo-plantas")
@RestController
public class TipoPlantaAdminController {

    private ITipoPlantaAdminService tipoPlantaAdminService;

    @Autowired
    public TipoPlantaAdminController(ITipoPlantaAdminService tipoPlantaAdminService) {
        this.tipoPlantaAdminService = tipoPlantaAdminService;
    }

    @Operation(description = "Operación encargada de crear un tipo de planta en el sistema")
    @PostMapping()
    public ResponseEntity<BasicResponseDto> create(
            @Valid
            @RequestBody TipoPlantaAdminDtoReq tipoPlantaAdminDtoReq) {

        tipoPlantaAdminService.create(tipoPlantaAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("El tipo de planta se ha creado con exito en el sistema"));

    }

    @Operation(description = "Operación encargada de editar datos sobre los tipos de planta del sistema",
            method = "PUT")
    @PutMapping(value = "/{id}")
    public ResponseEntity<BasicResponseDto> updateById(
            @PathVariable(
                    name = "id",
                    required = true) Long id,
            @Valid
            @RequestBody(required = true) TipoPlantaAdminDtoReq tipoPlantaAdminDtoReq) {

        tipoPlantaAdminService.updateById(id, tipoPlantaAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("El tipo  de planata ha sido actualizado con exito del sistema "));

    }

    @Operation(description = "Operación encargada de mostrar todos los tipos de plantas del sistema,segun filtros deseados.",
            method = "GET")
    @GetMapping
    public ResponseEntity<PageResponse<TipoPlantaAdminDtoResp>> getAllAdmin(
            @RequestParam(
                    name = "nombre",
                    required = false) String nombre,
            @RequestParam(
                    name = "isDelete",
                    required = false) Boolean isDelete,
            Pageable pageable
    ) {
        return ResponseEntity
                .ok()
                .body(tipoPlantaAdminService.getAllAdmin(nombre, isDelete, pageable));

    }

    @Operation(description = "Operación encargada de mostrar los detalles de un tipo de planta en el sistema",
            method = "GET")
    @GetMapping(value = "/{id}/details")
    public ResponseEntity<TipoPlantaDetailsDtoResp> getDetailsById(
            @PathVariable(
                    name = "id",
                    required = true) Long id) {

        return ResponseEntity
                .ok()
                .body(tipoPlantaAdminService.getDetailsById(id));
    }

}
