/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.GENERO_PLANTA;

import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.GENERO_PLANTA.GeneroPlantaAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.GENERO_PLANTA.GeneroPlantaAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.GENERO_PLANTA.GeneroPlantaDetailsDtoResp;
import com.nexus.demo.ENTITIES.GeneroPlanta;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author luis
 */
public interface IGeneroPlantaAdminService {

    public GeneroPlanta create(GeneroPlantaAdminDtoReq generoPlantaAdminDtoReq);
    
    public GeneroPlanta updateById(Long id, GeneroPlantaAdminDtoReq generoPlantaAdminDtoReq);
    
    public PageResponse<GeneroPlantaAdminDtoResp>getAll(String nombre, Boolean active, Pageable pageable);
    
    public GeneroPlantaDetailsDtoResp getDetailsById(Long id);
}
