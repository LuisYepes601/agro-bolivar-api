/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.SERVICES.TIPO_SUELO;

import com.nexus.demo.DTOS.REQUEST.TIPO_SUELO.TipoSueloAdminDtoReq;
import com.nexus.demo.ENTITIES.TipoSuelo;

/**
 *
 * @author luis
 */
public interface ITipoSueloAdminService {
    
    public TipoSuelo create(TipoSueloAdminDtoReq tipoSueloAdminDtoReq);
    
   
}
