/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONTROLLERS.TEXTURA_SUELO;

import com.nexus.demo.DTOS.GLOBAL.BasicResponseDto;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.TEXTURA_SUELO.TexturaSueloAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.TEXTURA_SUELO.TexturaSueloAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.TEXTURA_SUELO.TexturaSueloDetailsDtoResp;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nexus.demo.SERVICES.TEXTURA_SUELO.ITexturaSueloAdminService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author luis
 */
@Tag(
        name = "Administración de Textura de Suelos",
        description = "Módulo encargado de gestionar distintas operaciones administrativas"
        + "acerca de las texturas del suelo del sistema.")
@RequestMapping(value = "/api/v1/textura-suelos/admin")
@RestController
public class TexturaSueloAdminController {

    private ITexturaSueloAdminService texturaSueloAdminService;

    @Autowired
    public TexturaSueloAdminController(ITexturaSueloAdminService texturaSueloAdminService) {
        this.texturaSueloAdminService = texturaSueloAdminService;
    }

    @Operation(description = "Operación encargada de crear una textura en el sistema",
            method = "POST")
    @PostMapping()
    public ResponseEntity<BasicResponseDto> create(@RequestBody(required = true) TexturaSueloAdminDtoReq texturaSueloAdminDtoReq) {

        texturaSueloAdminService.create(texturaSueloAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("Textura creada con exito en el sistema"));

    }

    @Operation(description = "Operación encargada de obtener todas las texturad de suelo del sistema",
            method = "GET")
    @GetMapping()
    public ResponseEntity<PageResponse<TexturaSueloAdminDtoResp>> getAll(
            @RequestParam(
                    name = "nombre",
                    required = false) String nombre,
            @RequestParam(
                    name = "forma",
                    required = false) String forma,
            @RequestParam(
                    name = "active",
                    required = false) Boolean active,
            Pageable pageable
    ) {

        return ResponseEntity
                .ok()
                .body(texturaSueloAdminService.getAll(nombre, forma, active, pageable));
    }

    @Operation(description = "Operación encargada de editar datos de una textura de suelo del sistema",
            method = "PUT")
    @PutMapping(value = "/{id}")
    public ResponseEntity<BasicResponseDto> updateById(
            @PathVariable(
                    name = "id",
                    required = true) Long id,
            @Valid
            @RequestBody(required = true) TexturaSueloAdminDtoReq texturaSueloAdminDtoReq) {

        texturaSueloAdminService.updateById(id, texturaSueloAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("Se ha editado con exito la textura"));

    }

    @Operation(description = "Operación encargada de mostrar los detalles de ua textura de suelo del sistema.",
            method = "GET")
    @GetMapping(value = "/{id}/details")
    public ResponseEntity<TexturaSueloDetailsDtoResp> getDetailsByID(
            @PathVariable(name = "id", required = true) Long id) {

        return ResponseEntity
                .ok()
                .body(texturaSueloAdminService.getDetailsById(id));
    }

}
