/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.SERVICES.TEXTURA_SUELO;

import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.TEXTURA_SUELO.TexturaSueloAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.TEXTURA_SUELO.TexturaSueloAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.TEXTURA_SUELO.TexturaSueloDetailsDtoResp;
import com.nexus.demo.ENTITIES.TexturaSuelo;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author luis
 */
public interface ITexturaSueloAdminService {

    public TexturaSuelo create(TexturaSueloAdminDtoReq texturaSueloAdminDtoReq);

    public PageResponse<TexturaSueloAdminDtoResp> getAll(String nombre, String forma, Boolean active, Pageable pageable);

    public TexturaSuelo updateById(Long id, TexturaSueloAdminDtoReq texturaSueloAdminDtoReq);
    
    public TexturaSueloDetailsDtoResp getDetailsById(Long id);
}
