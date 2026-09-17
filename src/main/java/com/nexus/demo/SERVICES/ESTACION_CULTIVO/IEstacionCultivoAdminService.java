/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.SERVICES.ESTACION_CULTIVO;

import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.ESTACION_CULTIVO.EstacionCultivoAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.ESTACION_CULTIVO.EstacionCultivoAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.ESTACION_CULTIVO.EstacionCultivoDetailsDtoResp;
import com.nexus.demo.ENTITIES.EstacionCultivo;
import java.util.Optional;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author luis
 */
public interface IEstacionCultivoAdminService {

    public EstacionCultivo create(EstacionCultivoAdminDtoReq estacionCultivoAdminDtoReq);

    public EstacionCultivo updateByID(Long id, EstacionCultivoAdminDtoReq estacionCultivoAdminDtoReq);

    public PageResponse<EstacionCultivoAdminDtoResp> getAllAdmin(String nombre, Boolean active, Pageable pageable);

    public EstacionCultivoDetailsDtoResp getDetailsByID(Long id);
}
