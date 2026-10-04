/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONTROLLERS.CICLO_GERMINACION;

import com.nexus.demo.DTOS.GLOBAL.BasicResponseDto;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.CICLO_GERMINACION.CicloGerminacionAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.CICLO_GERMINACION.CicloGerminacionAdminDetailsDtoResp;
import com.nexus.demo.DTOS.RESPONSE.CICLO_GERMINACION.CicloGerminacionAdminDtoResp;
import com.nexus.demo.SERVICES.CICLO_GERMINACION.ICicloGerminacionAdminService;
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
@Tag(name = "Administración de Ciclo de Germinaciones",
        description = "Módulo encargado de gestionar las distintas operaciones administartivas de los ciclos de "
        + "germinación del sistema.")
@RequestMapping(value = "/api/v1/ciclo-germinaciones/admin")
@RestController
public class CicloGerminacionAdminController {

    private ICicloGerminacionAdminService cicloGerminacionAdminService;

    @Autowired
    public CicloGerminacionAdminController(ICicloGerminacionAdminService cicloGerminacionAdminService) {
        this.cicloGerminacionAdminService = cicloGerminacionAdminService;
    }

    @Operation(description = "Operación encargada de crear un cliclo de germinación al sistema",
            method = "POST")
    @PostMapping()
    public ResponseEntity<BasicResponseDto> create(
            @Valid
            @RequestBody(required = true) CicloGerminacionAdminDtoReq cicloGerminacionAdminDtoReq) {

        cicloGerminacionAdminService.create(cicloGerminacionAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("El ciclo de germinación ha sido creado con exito al sistema"));

    }

    @Operation(description = "Operación encargada de editar un ciclo de germinación por su id",
            method = "PUT")
    @PutMapping(value = "/{id}")
    public ResponseEntity<BasicResponseDto> updateById(
            @PathVariable(name = "id", required = true) Long id,
            @RequestBody(required = true) CicloGerminacionAdminDtoReq cicloGerminacionAdminDtoReq
    ) {

        cicloGerminacionAdminService.updateByID(id, cicloGerminacionAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("Se ha actualizado con exito el ciclo de germinación."));

    }

    @Operation(description = "Operación encargada de retornar los ciclos de germinación del sistema",
            method = "GET")
    @GetMapping()
    public ResponseEntity<PageResponse<CicloGerminacionAdminDtoResp>> getAll(
            @RequestParam(name = "nombre", required = false) String nombre,
            @RequestParam(name = "active", required = false) Boolean active,
            Pageable pageable
    ) {

        return ResponseEntity
                .ok()
                .body(cicloGerminacionAdminService.getAll(nombre, active, pageable));

    }

    @Operation(description = "Operación encargada de mostrar los detalles de un "
            + "ciclo de germinación por medio de su ID",
            method = "GET")
    @GetMapping(value = "/{id}/details")
    public ResponseEntity<CicloGerminacionAdminDetailsDtoResp> getDetailsById(
            @PathVariable(name = "id", required = true) Long id
    ) {

        return ResponseEntity
                .ok()
                .body(cicloGerminacionAdminService.getDetailsByID(id));

    }

}
