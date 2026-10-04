/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONTROLLERS.ROL;

import com.nexus.demo.DTOS.GLOBAL.BasicResponseDto;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.ROL.RolAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.ROL.RolAdminDtoResp;
import com.nexus.demo.SERVICES.ROL.IRolAdminService;
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
@Tag(name = "Administración de Roles",
        description = "Módulo encargada de amdinistrar las distintas operaciones sobre los roles")
@RequestMapping(value = "/api/v1/roles/admin")
@RestController
public class RolController {

    private IRolAdminService rolAdminService;

    @Autowired
    public RolController(IRolAdminService rolAdminService) {
        this.rolAdminService = rolAdminService;
    }

    @Operation(description = "Operación encargada de crear un rol en el sistema",
            method = "  POST")
    @PostMapping()
    public ResponseEntity<BasicResponseDto> creates(
            @Valid
            @RequestBody(required = true) RolAdminDtoReq rolAdminDtoReq
    ) {

        rolAdminService.create(rolAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("Se ha creado el Rol on exito"));
    }

    @Operation(description = "Operación encargada de editar los datos de un rol",
            method = "PUT")
    @PutMapping(value = "/{id}")
    public ResponseEntity<BasicResponseDto> update(
            @PathVariable(name = "id", required = true) Long id,
            @Valid
            @RequestBody(required = true) RolAdminDtoReq rolAdminDtoReq
    ) {

        rolAdminService.update(id, rolAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("Se ha ediato con exito el rol"));

    }

    @Operation(description = "Operación encargada de mostrar los roles del sistema",
            method = "GET")
    @GetMapping()
    public ResponseEntity<PageResponse<RolAdminDtoResp>> getAll(
            @RequestParam(name = "nombre", required = false) String nombre,
            @RequestParam(name = "active", required = false) Boolean active,
            Pageable pageable
    ) {

        return ResponseEntity
                .ok()
                .body(rolAdminService.getAll(nombre, active, pageable));

    }

    @Operation(description = "Operación encaragda de traer la informacion de un rol del sistema",
            method = "GET")
    @GetMapping(value = "/{id}")
    public ResponseEntity<RolAdminDtoResp> getRolById(@PathVariable(name = "id", required = true) Long id) {

        return ResponseEntity
                .ok()
                .body(rolAdminService.getRolById(id));
    }

}
