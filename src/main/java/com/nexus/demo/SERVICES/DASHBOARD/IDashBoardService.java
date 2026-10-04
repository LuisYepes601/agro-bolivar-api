/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.SERVICES.DASHBOARD;

import com.nexus.demo.DTOS.RESPONSE.DASHBOARD.DashBoardUserBasicDtoResp;

/**
 *
 * @author luis
 */
public interface IDashBoardService {

    public DashBoardUserBasicDtoResp getDatosBasicosUsuarioHomeDashBoard(Long id_user);
}
