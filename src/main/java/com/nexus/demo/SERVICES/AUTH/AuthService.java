/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.AUTH;

import com.nexus.demo.DTOS.REQUEST.AUTH.AuthDtoReq;
import com.nexus.demo.DTOS.RESPONSE.AUTH.AuthDtoResp;
import com.nexus.demo.DatoNoExistenteEcxeption;
import com.nexus.demo.ENTITIES.Usuario;
import com.nexus.demo.GLOBALEXCEPTIONHANDLER.exceptions.DatoInvalidoEcxeption;
import com.nexus.demo.REPOSITORY.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author luis
 */
@Service
public class AuthService implements IAuthService {

    private UsuarioRepository usuarioRepo;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UsuarioRepository usuarioRepo, PasswordEncoder passwordEncoder) {
        this.usuarioRepo = usuarioRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public AuthDtoResp iniciarSesion(AuthDtoReq authDtoReq) {

        Usuario usuario = usuarioRepo.getUserByEmail(authDtoReq.getUsername().trim())
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El usuario no tiene cuenta en el sitstema"));

        Boolean passTrue = passwordEncoder.matches(authDtoReq.getPassword().trim(), usuario.getContrasenia());

        if (passTrue == false) {

            throw new DatoInvalidoEcxeption("La contraseña es incorrecta");
        }

        AuthDtoResp authDtoResp = new AuthDtoResp();

        authDtoResp.setId(usuario.getId());
        authDtoReq.setUsername(usuario.getEmail());
        authDtoReq.getRol();

        return authDtoResp;
    }

}
