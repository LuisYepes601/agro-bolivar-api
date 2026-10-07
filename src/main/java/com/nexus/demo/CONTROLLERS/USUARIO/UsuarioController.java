/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONTROLLERS.USUARIO;

import com.nexus.demo.DTOS.GLOBAL.BasicResponseDto;
import com.nexus.demo.DTOS.RESPONSE.USUARIO.UsuarioDtoReq;
import com.nexus.demo.DTOS.RESPONSE.USUARIO.UsuarioDtoReso;
import com.nexus.demo.SERVICES.USUARIO.IUsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    
    @Operation(description = "Operación encrgada de tarer los datos de un usuario",
            method = "GET")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDtoReso> getUsuarioById(@PathVariable(name = "id", required = true) Long id) {
        
        return ResponseEntity
                .ok()
                .body(usuarioService.getUserById(id));
    }
    
    @Operation(description = "Operación encraagda de editar foto del usuario",
            method = "PUT")
    @PutMapping(value = "/{id}/foto-perfil")
    public ResponseEntity<BasicResponseDto> editarFotoPerfil(
            @PathVariable(name = "id", required = true) Long id,
            @RequestPart(name = "foto", required = true) MultipartFile foto
    ) {
        
        usuarioService.editarFotoPerfil(id, foto);
        
        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("Foto d eperfil actualizada con exito"));
    }
    
}
