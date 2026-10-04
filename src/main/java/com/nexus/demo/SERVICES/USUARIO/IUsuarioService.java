/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.USUARIO;

import com.nexus.demo.DTOS.RESPONSE.USUARIO.UsuarioDtoReq;
import com.nexus.demo.ENTITIES.Usuario;

/**
 *
 * @author luis
 */
public interface IUsuarioService {
    
    public Usuario registrarce(UsuarioDtoReq usuarioDtoReq);
    
}
