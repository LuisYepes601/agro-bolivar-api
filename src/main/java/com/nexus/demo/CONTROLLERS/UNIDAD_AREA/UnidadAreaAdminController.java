/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONTROLLERS.UNIDAD_AREA;

import com.nexus.demo.DTOS.GLOBAL.BasicResponseDto;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.UNIDAD_AREA.UnidadAreaAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.UNIDAD_AREA.UnidadAreaAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.UNIDAD_AREA.UnidadAreaDetailsDtoResp;
import com.nexus.demo.SERVICES.UNIDAD_AREA.IUnidadAreaAdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Administración de unidades de area del sistema",
        description = "Módulo encargado de gestionar operaciones relacionadas a las unidades de area del"
        + "sistema.")
@RequestMapping(value = "/api/v1/unidades-area/admin")
@RestController
public class UnidadAreaAdminController {

    private IUnidadAreaAdminService unidadAreaAdminService;

    @Autowired
    public UnidadAreaAdminController(IUnidadAreaAdminService unidadAreaAdminService) {
        this.unidadAreaAdminService = unidadAreaAdminService;
    }

    @Operation(description = "Operación encargada de crear unidades de area del sistema",
            method = "POST")
    @PostMapping()
    public ResponseEntity<BasicResponseDto> create(@RequestBody(required = true) UnidadAreaAdminDtoReq unidadAreaAdminDtoReq) {

        unidadAreaAdminService.create(unidadAreaAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("Se ha creado con exito la unidad de area"));
    }

    @Operation(description = "Operación encargada de editar datos de una unidad de area.",
            method = "PUT")
    @PutMapping(value = "/{id}")
    public ResponseEntity<BasicResponseDto> updateByID(
            @PathVariable(name = "id", required = true) Long id,
            @RequestBody(required = true) UnidadAreaAdminDtoReq unidadAreaAdminDtoReq) {

        unidadAreaAdminService.update(id, unidadAreaAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("La unidad de area se ha actualizado con exito en el sistema"));
    }

    @Operation(description = "Operación encargada de obtener las unidades de area del sistema segun los filtros "
            + "seleccionados",
            method = "GET")
    @GetMapping()
    public ResponseEntity<PageResponse<UnidadAreaAdminDtoResp>> getAll(
            @RequestParam(name = "nombre", required = false) String nombre,
            @RequestParam(name = "active", required = false) Boolean active,
            Pageable pageable
    ) {

        return ResponseEntity
                .ok()
                .body(unidadAreaAdminService.getAll(nombre, active, pageable));
    }

    @Operation(description = "Operación encargada de obtener los detalles de una unidad de area",
            method = "GET")
    @GetMapping(value = "/{id}/details")
    public ResponseEntity<UnidadAreaDetailsDtoResp> getDetailsById(@PathVariable(name = "id", required = true) Long id) {

        return ResponseEntity
                .ok()
                .body(unidadAreaAdminService.getDetailsById(id));
    }
}
