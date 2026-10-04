/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONTROLLERS.CICLO_PRODUCCION;

import com.nexus.demo.DTOS.GLOBAL.BasicResponseDto;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.CICLO_GERMINACION.CicloGerminacionAdminDtoReq;
import com.nexus.demo.DTOS.REQUEST.CICLO_PRODUCCION.CicloProduccionAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.CICLO_PRODUCCION.CicloProduccionAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.CICLO_PRODUCCION.CicloProduccionDetailsDtoResp;
import com.nexus.demo.SERVICES.CICLO_PRODUCCION.ICicloProduccionAdminService;
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
@Tag(name = "Administración de Ciclo de Producciones",
        description = "Módulo encargado de getsionar las distintas operaciones administrativas sobre"
        + "los ciclos de producción del sistema.")
@RequestMapping(value = "/api/v1/ciclos-produccion/admin")
@RestController
public class CicloProduccionAdminController {

    private ICicloProduccionAdminService cicloProduccionAdminService;

    @Autowired
    public CicloProduccionAdminController(ICicloProduccionAdminService cicloProduccionAdminService) {
        this.cicloProduccionAdminService = cicloProduccionAdminService;
    }

    @Operation(description = "Operación encargada de crear un ciclo de producción en el sistema",
            method = "POST")
    @PostMapping()
    public ResponseEntity<BasicResponseDto> create(
            @Valid
            @RequestBody(required = true) CicloProduccionAdminDtoReq cicloProduccionAdminDtoReq
    ) {

        cicloProduccionAdminService.create(cicloProduccionAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("El ciclo de producción ha sido creado con exito en el sistsema"));
    }

    @Operation(description = "Operación encargada de editar los datos de un ciclo de producción existente",
            method = "PUT")
    @PutMapping(value = "/{id}")
    public ResponseEntity<BasicResponseDto> updateByID(
            @PathVariable(
                    name = "id",
                    required = true) Long id,
            @RequestBody(required = true) CicloProduccionAdminDtoReq cicloProduccionAdminDtoReq) {

        cicloProduccionAdminService.update(id, cicloProduccionAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("El ciclo de producción ha sido actualizado con exito."));
    }

    @Operation(description = "Operación encargada de mostrar los ciclos de germinación del sistema",
            method = "GET")
    @GetMapping()
    public ResponseEntity<PageResponse<CicloProduccionAdminDtoResp>> getAll(
            @RequestParam(name = "nombre", required = false) String nombre,
            @RequestParam(name = "active", required = false) Boolean active,
            Pageable pageable
    ) {

        return ResponseEntity
                .ok()
                .body(cicloProduccionAdminService.getAll(nombre, active, pageable));
    }

    @Operation(description = "Operación encargada de obtener los detalles de un ciclo de producción",
            method = "GET")
    @GetMapping(value = "/{id}/details")
    public ResponseEntity<CicloProduccionDetailsDtoResp> getDetailsByID(
            @PathVariable(
                    name = "id",
                    required = true) Long id) {

        return ResponseEntity
                .ok()
                .body(cicloProduccionAdminService.getDetailsById(id));
    }

}
