/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONTROLLERS.USUARIO;

import com.nexus.demo.DTOS.GLOBAL.BasicResponseDto;
import com.nexus.demo.DTOS.RESPONSE.USUARIO.UsuarioDtoReq;
import com.nexus.demo.SERVICES.USUARIO.IUsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author luis
 */
@Tag(name = "Usuarios",
        description = "Modulo encargdao de operciones basicas respecto a los usuarios del sistema")
@RequestMapping(value = "/api/v1/usuarios")
@RestController
public class UsuarioController {

    private IUsuarioService usuarioService;

    @Autowired
    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Operation(description = "Operación encragada de registrar un nuevo usuario al sistema",
            method = "POST")
    @PostMapping()
    public ResponseEntity<BasicResponseDto> registrarce(
            @Valid
            @RequestBody(required = true) UsuarioDtoReq usuarioDtoReq) {

        usuarioService.registrarce(usuarioDtoReq);
        
        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("Te haz registrado con exito."));
    }

}
