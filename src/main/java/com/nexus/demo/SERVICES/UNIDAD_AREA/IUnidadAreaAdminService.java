/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.SERVICES.UNIDAD_AREA;

import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.UNIDAD_AREA.UnidadAreaAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.UNIDAD_AREA.UnidadAreaAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.UNIDAD_AREA.UnidadAreaDetailsDtoResp;
import com.nexus.demo.ENTITIES.UnidadArea;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author luis
 */
public interface IUnidadAreaAdminService {

    public UnidadArea create(UnidadAreaAdminDtoReq unidadAreaAdminDtoReq);

    public UnidadArea update(Long id, UnidadAreaAdminDtoReq unidadAreaAdminDtoReq);

    public PageResponse<UnidadAreaAdminDtoResp> getAll(String nombre, Boolean active, Pageable pageable);

    public UnidadAreaDetailsDtoResp getDetailsById(Long id);
}
