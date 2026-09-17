/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.FAMILIA_BOTANICA;

import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.FAMILIA_BOTANICA.FamiliaBotanicaDtoReq;
import com.nexus.demo.DTOS.RESPONSE.FAMILIA_BOTANICA.FamiliaBotanicaAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.FAMILIA_BOTANICA.FamiliaBotanicaDetailsDtoResp;
import com.nexus.demo.ENTITIES.FamiliaBotanica;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author luis
 */
public interface IFamiliaBotanicaAdminService {
    
    public FamiliaBotanica create(FamiliaBotanicaDtoReq familiaBotanicaDtoReq);
    
    public FamiliaBotanica updateById(Long id, FamiliaBotanicaDtoReq familiaBotanicaDtoReq);
    
    public PageResponse<FamiliaBotanicaAdminDtoResp>getAll(String nombre, Boolean active, Pageable pageable);
    
    public FamiliaBotanicaDetailsDtoResp getDetailsById(Long id);
}
