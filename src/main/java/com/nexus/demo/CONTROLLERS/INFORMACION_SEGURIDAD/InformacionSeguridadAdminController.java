/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONTROLLERS.INFORMACION_SEGURIDAD;

import com.nexus.demo.DTOS.GLOBAL.BasicResponseDto;
import com.nexus.demo.DTOS.REQUEST.INFORMACION_SEGURIDAD.InformacionSeguridadDtoReq;
import com.nexus.demo.DTOS.RESPONSE.INFORMACION_SEGURIDAD.InformacionSeguridadDtoResp;
import com.nexus.demo.SERVICES.INFORMACION_SEGURIDAD.IInformacionSeguridadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author luis
 */
@Tag(name = "Administración de información de seguridad.",
        description = "Módulo encargado de getsionar las distintas operaciones administrativas"
        + "")
@RequestMapping(value = "/api/v1/informaciones-seguridad/admin")
@RestController
public class InformacionSeguridadAdminController {

    private IInformacionSeguridadService informacionSeguridadService;

    @Autowired
    public InformacionSeguridadAdminController(IInformacionSeguridadService informacionSeguridadService) {
        this.informacionSeguridadService = informacionSeguridadService;
    }

    @Operation(description = "Operación encargada de editar datos de una información de seguridad creada",
            method = "PUT")
    @PutMapping(value = "/{id}")
    public ResponseEntity<BasicResponseDto> update(
            @PathVariable(name = "id", required = true) Long id,
            @Valid
            @RequestBody(required = true) InformacionSeguridadDtoReq informacionSeguridadDtoReq
    ) {

        informacionSeguridadService.update(id, informacionSeguridadDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("Se ha editado la información de seguridad."));
    }

    @Operation(description = "Operacion encargada  de obtener la información de seguridad a traves del id del producto ",
            method = "GET")
    @GetMapping(value = "/{id}/producto")
    public ResponseEntity<InformacionSeguridadDtoResp> getByIdProducto(@PathVariable(value = "id", required = true) Long id) {

        return ResponseEntity
                .ok()
                .body(informacionSeguridadService.getInfoSeguridadProducto(id));

    }

}
