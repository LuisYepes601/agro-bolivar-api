/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONTROLLERS.TIPO_SUELO;

import com.nexus.demo.DTOS.GLOBAL.BasicResponseDto;
import com.nexus.demo.DTOS.REQUEST.TIPO_SUELO.TipoSueloAdminDtoReq;
import com.nexus.demo.SERVICES.TIPO_SUELO.ITipoSueloAdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author luis
 */
@Tag(name = "Administración de Tipos de Suelo",
        description = "Módulo encargado de gestionar las operaciones administrativas de los tipos"
        + "de suelos del sistema.")
@RequestMapping(value = "/api/v1/tipos-suelos/admin")
@RestController
public class TipoSueloAdminController {

    private ITipoSueloAdminService tipoSueloAdminService;

    @Autowired
    public TipoSueloAdminController(ITipoSueloAdminService tipoSueloAdminService) {
        this.tipoSueloAdminService = tipoSueloAdminService;
    }

    @Operation(description = "Operación encargada de crear un tipo de suelo en el sistema",
            method = "POST")
    @PostMapping()
    public ResponseEntity<BasicResponseDto> create(
            @Valid
            @RequestBody(required = true) TipoSueloAdminDtoReq tipoSueloAdminDtoReq
    ) {
        tipoSueloAdminService.create(tipoSueloAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("Tipo de suelo creado con exito"));

    }

}
