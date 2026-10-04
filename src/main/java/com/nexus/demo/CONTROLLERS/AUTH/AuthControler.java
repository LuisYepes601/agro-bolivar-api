/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONTROLLERS.AUTH;

import com.nexus.demo.DTOS.REQUEST.AUTH.AuthDtoReq;
import com.nexus.demo.DTOS.RESPONSE.AUTH.AuthDtoResp;
import com.nexus.demo.SERVICES.AUTH.IAuthService;
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
@Tag(name = "Auth",
        description = "Módulo encargado de la autenticación de usuarios")
@RequestMapping(value = "/api/v1/auth")
@RestController
public class AuthControler {

    private IAuthService authService;

    @Autowired
    public AuthControler(IAuthService authService) {
        this.authService = authService;
    }

    @Operation(description = "operación encargada de autenticar un usuaria en el sistema",
            method = "POST")
    @PostMapping()
    public ResponseEntity<AuthDtoResp> Auth(
            @Valid
            @RequestBody(required = true) AuthDtoReq authDtoReq
    ) {

        return ResponseEntity
                .ok()
                .body(authService.iniciarSesion(authDtoReq));
    }

}
