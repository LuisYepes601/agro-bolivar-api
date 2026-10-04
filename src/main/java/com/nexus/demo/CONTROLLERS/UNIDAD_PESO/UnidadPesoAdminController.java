/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONTROLLERS.UNIDAD_PESO;

import com.nexus.demo.DTOS.GLOBAL.BasicResponseDto;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.UNIDAD_PESO.UnidadPesoAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.UNIDAD_PESO.UnidadPesoAdminDetailsDtoResp;
import com.nexus.demo.DTOS.RESPONSE.UNIDAD_PESO.UnidadPesoAdminDtoResp;
import com.nexus.demo.SERVICES.UNIDAD_PESO.IUnidadPesoAdminService;
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
@Tag(name = "Administración de unidades de peso",
        description = "Módulo encaragado de gestioanar las distintas operaciones sobre las"
        + "unidades de peso del sistema.")
@RequestMapping(value = "/api/v1/unidades-peso/admin")
@RestController
public class UnidadPesoAdminController {

    private IUnidadPesoAdminService unidadPesoAdminService;

    @Autowired
    public UnidadPesoAdminController(IUnidadPesoAdminService unidadPesoAdminService) {
        this.unidadPesoAdminService = unidadPesoAdminService;
    }

    @Operation(description = "Operación encargada de crear una unidad de peso en el sistema",
            method = "POST")
    @PostMapping()
    public ResponseEntity<BasicResponseDto> create(
            @Valid
            @RequestBody(required = true) UnidadPesoAdminDtoReq unidadPesoAdminDtoReq) {

        unidadPesoAdminService.create(unidadPesoAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("La unidad de peso se ha creado con exito en el sistema"));
    }

    @Operation(description = "Operación encargada de editar una unidad de peso del sistema",
            method = "PUT")
    @PutMapping(value = "{id}")
    public ResponseEntity<BasicResponseDto> updateByID(
            @PathVariable(name = "id", required = true) Long id,
            @Valid
            @RequestBody(required = true) UnidadPesoAdminDtoReq unidadPesoAdminDtoReq
    ) {

        unidadPesoAdminService.update(id, unidadPesoAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("La unidad de peso se ah ediato con exito en el sistema"));
    }

    @Operation(description = "Operación encaragada de mostrar las unidades de pesodel sistema con datos administrativos"
            + "", method = "GET")
    @GetMapping()
    public ResponseEntity<PageResponse<UnidadPesoAdminDtoResp>> getAll(
            @RequestParam(name = "nombre", required = false) String nombre,
            @RequestParam(name = "active", required = false) Boolean active,
            Pageable pageable
    ) {

        return ResponseEntity
                .ok()
                .body(unidadPesoAdminService.getAll(nombre, active, pageable));
    }

    @Operation(description = "Operación encargada de mostrar los detalles de una unidad de peso",
            method = "GET")
    @GetMapping(value = "/{id}/details")
    public ResponseEntity<UnidadPesoAdminDetailsDtoResp> getDetailsByID(
            @PathVariable(name = "id", required = true) Long id) {
        return ResponseEntity
                .ok()
                .body(unidadPesoAdminService.getDetailsById(id));

    }

}
