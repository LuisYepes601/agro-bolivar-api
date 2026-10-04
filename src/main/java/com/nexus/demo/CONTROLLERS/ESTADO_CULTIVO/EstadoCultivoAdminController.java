/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONTROLLERS.ESTADO_CULTIVO;

import com.nexus.demo.DTOS.GLOBAL.BasicResponseDto;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.ESTADO_CULTIVO.EstadoCultivoAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.ESTACION_CULTIVO.EstadoCultivoAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.ESTADO_CULTIVO.EstadoCultivoDetailsDtoResp;
import com.nexus.demo.SERVICES.ESTADO_CULTIVO.IEstadoCultivoAdminService;
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
@Tag(name = "Administración de estados de cultivo",
        description = "Módulo encargado de manejar las distintas operaciones administrativas sobre los"
        + "estados de un cultivo.")
@RequestMapping(value = "/api/v1/estado-cultivos/admin")
@RestController
public class EstadoCultivoAdminController {

    private IEstadoCultivoAdminService estadoCultivoAdminService;

    @Autowired
    public EstadoCultivoAdminController(IEstadoCultivoAdminService estadoCultivoAdminService) {
        this.estadoCultivoAdminService = estadoCultivoAdminService;
    }

    @Operation(description = "Operación encargada de crear un estado de cultivo al sistema",
            method = "POST")
    @PostMapping()
    public ResponseEntity<BasicResponseDto> createEstadoCultivo(
            @Valid
            @RequestBody(required = true) EstadoCultivoAdminDtoReq estadoCultivoAdminDtoReq
    ) {

        estadoCultivoAdminService.create(estadoCultivoAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("El estado de cultivo se ha creado con exito en el sistema"));

    }

    @Operation(description = "Operación encargada de editar los dtaos de un estado del cultivo a traves de su ID",
            method = "PUT")
    @PutMapping(value = "/{id}")
    public ResponseEntity<BasicResponseDto> updateByID(
            @PathVariable(name = "id", required = true) Long id,
            @Valid
            @RequestBody(required = true) EstadoCultivoAdminDtoReq estadoCultivoAdminDtoReq) {

        estadoCultivoAdminService.update(id, estadoCultivoAdminDtoReq);
        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("El estadode cultivo ha sido actualizado con exito al sistema"));
    }

    @Operation(description = "Operación encargada de obtener los estados de cultvo del sistema",
            method = "GET")
    @GetMapping()
    public ResponseEntity<PageResponse<EstadoCultivoAdminDtoResp>> getAll(
            @RequestParam(
                    name = "nombre",
                    required = false) String nombre,
            @RequestParam(
                    name = "active",
                    required = false) Boolean active,
            Pageable pageable
    ) {

        return ResponseEntity
                .ok()
                .body(estadoCultivoAdminService.getAll(nombre, active, pageable));
    }

    @Operation(description = "Operación encarga de mostrar los detalles de un estado de cultivo del sistema",
            method = "GET")
    @GetMapping(value = "/{id}/details")
    public ResponseEntity<EstadoCultivoDetailsDtoResp> getDetailsById(
            @PathVariable(name = "id", required = true) Long id) {

        return ResponseEntity
                .ok()
                .body(estadoCultivoAdminService.getDetailsById(id));
    }

}
