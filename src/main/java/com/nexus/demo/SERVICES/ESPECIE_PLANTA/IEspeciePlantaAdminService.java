/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.ESPECIE_PLANTA;

import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.ESPECIE_PLANTA.EspeciePlantaAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.ESPECIE_PLANTA.EspeciePlantaAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.ESPECIE_PLANTA.EspeciePlantaDetailsDtoResp;
import com.nexus.demo.ENTITIES.Especie;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author luis
 */
public interface IEspeciePlantaAdminService {
    
    public Especie create(EspeciePlantaAdminDtoReq especiePlantaAdminDtoReq);
    
    public Especie updateById(Long id, EspeciePlantaAdminDtoReq especiePlantaAdminDtoReq);
    
    public PageResponse<EspeciePlantaAdminDtoResp>getAll(String nombre, Boolean active, Pageable pageable);
    
    public EspeciePlantaDetailsDtoResp getDetailsByID(Long id);
}
