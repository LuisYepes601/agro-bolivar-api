/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.CICLO_GERMINACION;

import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.CICLO_GERMINACION.CicloGerminacionAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.CICLO_GERMINACION.CicloGerminacionAdminDetailsDtoResp;
import com.nexus.demo.DTOS.RESPONSE.CICLO_GERMINACION.CicloGerminacionAdminDtoResp;
import com.nexus.demo.ENTITIES.CicloGerminacion;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author luis
 */
public interface ICicloGerminacionAdminService {
    
    public CicloGerminacion create(CicloGerminacionAdminDtoReq cicloGerminacionAdminDtoReq);
    
    public CicloGerminacion updateByID(Long id, CicloGerminacionAdminDtoReq cicloGerminacionAdminDtoReq);
    
    public PageResponse<CicloGerminacionAdminDtoResp>getAll(String nombre, Boolean active, Pageable pageable);
    
    public CicloGerminacionAdminDetailsDtoResp getDetailsByID(Long id);
}
