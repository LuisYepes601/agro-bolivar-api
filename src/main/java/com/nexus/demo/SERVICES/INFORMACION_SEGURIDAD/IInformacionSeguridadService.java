/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.SERVICES.INFORMACION_SEGURIDAD;

import com.nexus.demo.DTOS.REQUEST.INFORMACION_SEGURIDAD.InformacionSeguridadDtoReq;
import com.nexus.demo.DTOS.RESPONSE.INFORMACION_SEGURIDAD.InformacionSeguridadDtoResp;
import com.nexus.demo.ENTITIES.InformacionSeguridad;
import com.nexus.demo.REPOSITORY.InformacionSeguridadRepository;

/**
 *
 * @author luis
 */
public interface IInformacionSeguridadService {

    public InformacionSeguridad create(InformacionSeguridadDtoReq informacionSeguridadDtoReq);

    public InformacionSeguridad update(Long id, InformacionSeguridadDtoReq informacionSeguridadDtoReq);

    public InformacionSeguridadDtoResp getInfoSeguridadProducto(Long id_producto);

}
