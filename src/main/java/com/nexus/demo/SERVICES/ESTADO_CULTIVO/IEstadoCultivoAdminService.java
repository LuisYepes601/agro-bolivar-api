/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.ESTADO_CULTIVO;

import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.ESTADO_CULTIVO.EstadoCultivoAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.ESTACION_CULTIVO.EstacionCultivoAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.ESTACION_CULTIVO.EstadoCultivoAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.ESTADO_CULTIVO.EstadoCultivoDetailsDtoResp;
import com.nexus.demo.ENTITIES.EstadoCultivo;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author luis
 */
public interface IEstadoCultivoAdminService {

    public EstadoCultivo create(EstadoCultivoAdminDtoReq estadoCultivoAdminDtoReq);
    
    public EstadoCultivo update(Long id, EstadoCultivoAdminDtoReq estadoCultivoAdminDtoReq);
    
    public PageResponse<EstadoCultivoAdminDtoResp>getAll(String nombre, Boolean active, Pageable pageable);
    
    public EstadoCultivoDetailsDtoResp getDetailsById(Long id);
}
