/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.CICLO_PRODUCCION;

import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.CICLO_PRODUCCION.CicloProduccionAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.CICLO_PRODUCCION.CicloProduccionAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.CICLO_PRODUCCION.CicloProduccionDetailsDtoResp;
import com.nexus.demo.ENTITIES.CicloProduccion;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author luis
 */
public interface ICicloProduccionAdminService {
    
    
    public CicloProduccion create(CicloProduccionAdminDtoReq  cicloProduccionAdminDtoReq);
    
    public CicloProduccion update(Long id, CicloProduccionAdminDtoReq cicloProduccionAdminDtoReq);
    
    public PageResponse<CicloProduccionAdminDtoResp>getAll(String nombre, Boolean active, Pageable pageable);
    
    public CicloProduccionDetailsDtoResp getDetailsById(Long id);
}
