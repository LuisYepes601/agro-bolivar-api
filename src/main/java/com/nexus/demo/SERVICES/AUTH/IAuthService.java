/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.AUTH;

import com.nexus.demo.DTOS.REQUEST.AUTH.AuthDtoReq;
import com.nexus.demo.DTOS.RESPONSE.AUTH.AuthDtoResp;
import org.springframework.stereotype.Service;

/**
 *
 * @author luis
 */
public interface IAuthService {

    public AuthDtoResp iniciarSesion(AuthDtoReq authDtoReq);

}
