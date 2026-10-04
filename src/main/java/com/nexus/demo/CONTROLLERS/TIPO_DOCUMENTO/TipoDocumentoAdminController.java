/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONTROLLERS.TIPO_DOCUMENTO;

import com.nexus.biblioNepo.UTILS.PageResponseUtils;
import com.nexus.demo.DTOS.GLOBAL.BasicResponseDto;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.TIPO_SUELO.TipoDocumentoAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.TIPO_DOCUMENTO.TipoDocumentoAdminDtoResp;
import com.nexus.demo.SERVICES.TIPO_DOCUMENTO.ITipoDocumentoAdminService;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author luis
 */
@Tag(name = "Administación de Tipo de Documentos.",
        description = "Módulo encargado de gestionar las distintas operaciones administrativas "
        + "de lso tipos de documento del sistema.")
@RequestMapping(value = "/api/v1/tipo-documentos/admin")
@RestController
public class TipoDocumentoAdminController {

    @Autowired
    private ITipoDocumentoAdminService tipoDocumentoAdminService;

    @Operation(description = "Operación encargada  de crear un tipo de documento en el sistema",
            method = "GET")
    @PostMapping()
    public ResponseEntity<BasicResponseDto> create(
            @Valid
            @RequestBody(required = true) TipoDocumentoAdminDtoReq tipoDocumentoAdminDtoReq
    ) {

        tipoDocumentoAdminService.create(tipoDocumentoAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("El tipo de documemto se ha creado con exito en el sistema"));

    }

    @Operation(description = "Operación encargada de editar datos de un tipo de documento.",
            method = "PUT")
    @PutMapping(value = "/{id}")
    public ResponseEntity<BasicResponseDto> updateByID(
            @PathVariable(name = "id", required = true) Long id,
            @Valid
            @RequestBody(required = true) TipoDocumentoAdminDtoReq tipoDocumentoAdminDtoReq) {

        tipoDocumentoAdminService.update(id, tipoDocumentoAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("Se ha editado el tipo de documento con exito."));

    }

    @Operation(description = "Operación encargada de obtener lso tipos de docuemnto del sistema",
            method = "GET")
    @GetMapping()
    public ResponseEntity<PageResponse<TipoDocumentoAdminDtoResp>> getAll(
            @RequestParam(name = "nombre", required = false) String nombre,
            @RequestParam(name = "active", required = false) Boolean active,
            Pageable pageable
    ) {

        return ResponseEntity
                .ok()
                .body(tipoDocumentoAdminService.getAll(nombre, active, pageable));

    }

    @Operation(description = "Operación encargada de obtener la información de un tipo de documento.",
            method = "GET")
    @GetMapping(value = "/{id}")
    public ResponseEntity<TipoDocumentoAdminDtoResp> getByID(@PathVariable(name = "id", required = true) Long id) {

        return ResponseEntity
                .ok()
                .body(tipoDocumentoAdminService.getById(id));
    }
}
