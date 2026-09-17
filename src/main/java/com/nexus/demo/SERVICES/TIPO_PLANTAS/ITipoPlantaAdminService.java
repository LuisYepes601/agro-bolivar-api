/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.TIPO_PLANTAS;

import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.TIPO_PLANTA.TipoPlantaAdminDtoReq;
import com.nexus.demo.DTOS.REQUEST.TIPO_PLANTA.TipoPlantaDetailsDtoResp;
import com.nexus.demo.DTOS.RESPONSE.TIPO_PLANTA.TipoPlantaAdminDtoResp;
import com.nexus.demo.ENTITIES.TipoPlanta;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author luis
 */
public interface ITipoPlantaAdminService {

    public TipoPlanta create(TipoPlantaAdminDtoReq tipoPlantaAdminDtoReq);
    
    public TipoPlanta updateById(Long id, TipoPlantaAdminDtoReq tipoPlantaAdminDtoReq);
    
    public PageResponse<TipoPlantaAdminDtoResp>getAllAdmin(String nombre, Boolean is_delete, Pageable pageable);
    
    public TipoPlantaDetailsDtoResp getDetailsById(Long id);
}
