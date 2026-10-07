/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.USUARIO;

import com.nexus.demo.DTOS.RESPONSE.USUARIO.InformacionPersonalDtoReq;
import com.nexus.demo.DTOS.RESPONSE.USUARIO.UsuarioDtoReq;
import com.nexus.demo.DTOS.RESPONSE.USUARIO.UsuarioDtoReso;
import com.nexus.demo.ENTITIES.Usuario;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author luis
 */
public interface IUsuarioService {
    
    public Usuario registrarce(UsuarioDtoReq usuarioDtoReq);
    
    public UsuarioDtoReso getUserById(Long id);
    
    public Usuario editarFotoPerfil(Long id, MultipartFile foto);
    
    public Usuario editarInformacionPersonal(Long id, InformacionPersonalDtoReq informacionPersonalDtoReq);
    
}
