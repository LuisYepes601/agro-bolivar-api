/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONTROLLERS.ESTACION_CULTIVO;

import com.nexus.demo.DTOS.GLOBAL.BasicResponseDto;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.ESTACION_CULTIVO.EstacionCultivoAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.ESTACION_CULTIVO.EstacionCultivoAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.ESTACION_CULTIVO.EstacionCultivoDetailsDtoResp;
import com.nexus.demo.SERVICES.ESTACION_CULTIVO.IEstacionCultivoAdminService;
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
@Tag(name = "Administración de Estación de Cultivos",
        description = "Módulo encargado de gestionar las distintas operaciones administartivas sobre las estaciones de los cultivos")
@RequestMapping(value = "/api/v1/estacion-cultivos/admin")
@RestController
public class EstacionCultivoAdminController {

    private IEstacionCultivoAdminService estacionCultivoAdminService;

    @Autowired
    public EstacionCultivoAdminController(IEstacionCultivoAdminService estacionCultivoAdminService) {
        this.estacionCultivoAdminService = estacionCultivoAdminService;
    }

    @Operation(description = "Operación encaragda de crear una estación de cultivo al sistema",
            method = "POST")
    @PostMapping
    public ResponseEntity<BasicResponseDto> create(
            @Valid
            @RequestBody(required = true) EstacionCultivoAdminDtoReq estacionCultivoAdminDtoReq
    ) {

        estacionCultivoAdminService.create(estacionCultivoAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("La estación se ha creado con exito en el sistema"));
    }

    @Operation(description = "Operación encargada de editar una estación de cultivo por su id requerido",
            method = "PUT")
    @PutMapping(value = "/{id}")
    public ResponseEntity<BasicResponseDto> updateByID(
            @PathVariable(
                    name = "id",
                    required = true) Long id,
            @Valid
            @RequestBody EstacionCultivoAdminDtoReq estacionCultivoAdminDtoReq) {

        estacionCultivoAdminService.updateByID(id, estacionCultivoAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("Estación actualizada con exito."));

    }

    @Operation(description = "Operación encargada de mostrar las estaciones de los cultivos del sistema",
            method = "GET")
    @GetMapping()
    public ResponseEntity<PageResponse<EstacionCultivoAdminDtoResp>> getAll(
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
                .body(estacionCultivoAdminService.getAllAdmin(nombre, active, pageable));
    }

    @Operation(description = "Operacióne encargada de mostrar los detalles de una estacióna traves de su ID",
            method = "GET")
    @GetMapping(value = "/{id}/details")
    public ResponseEntity<EstacionCultivoDetailsDtoResp> getDetailsById(
            @PathVariable(
                    name = "id",
                    required = true) Long id) {

        return ResponseEntity
                .ok()
                .body(estacionCultivoAdminService.getDetailsByID(id));

    }

}
