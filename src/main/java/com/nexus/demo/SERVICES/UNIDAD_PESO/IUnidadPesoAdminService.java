/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.UNIDAD_PESO;

import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.UNIDAD_PESO.UnidadPesoAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.UNIDAD_PESO.UnidadPesoAdminDetailsDtoResp;
import com.nexus.demo.DTOS.RESPONSE.UNIDAD_PESO.UnidadPesoAdminDtoResp;
import com.nexus.demo.ENTITIES.UnidadPeso;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author luis
 */
public interface IUnidadPesoAdminService {
    
    public UnidadPeso create(UnidadPesoAdminDtoReq unidadPesoAdminDtoReq);
    
    public UnidadPeso update(Long id, UnidadPesoAdminDtoReq unidadPesoAdminDtoReq);
    
    public PageResponse<UnidadPesoAdminDtoResp>getAll(String nombre, Boolean active, Pageable pageable);
    
    public UnidadPesoAdminDetailsDtoResp getDetailsById(Long id);
}
