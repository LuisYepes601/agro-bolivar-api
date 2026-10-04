/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.DASHBOARD;

import com.nexus.demo.DTOS.RESPONSE.DASHBOARD.DashBoardUserBasicDtoResp;
import com.nexus.demo.DatoNoExistenteEcxeption;
import com.nexus.demo.REPOSITORY.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author luis
 */
@Service
public class DashBoardService implements IDashBoardService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public DashBoardService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public DashBoardUserBasicDtoResp getDatosBasicosUsuarioHomeDashBoard(Long id_user) {

        return usuarioRepository.getBasicDashboardHomeUser(id_user)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El usuario no existe en el sistema"));

    }

}
