/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.SERVICES.TIPO_SUELO;

import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.TIPO_SUELO.TipoSueloAdminDtoReq;
import com.nexus.demo.DTOS.REQUEST.TIPO_SUELO.TipoSueloBasicDtoReq;
import com.nexus.demo.DTOS.RESPONSE.TIPO_SUELO.TipoSueloAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.TIPO_SUELO.TipoSueloDetailsDtoResp;
import com.nexus.demo.ENTITIES.TipoSuelo;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author luis
 */
public interface ITipoSueloAdminService {

    public TipoSuelo create(TipoSueloAdminDtoReq tipoSueloAdminDtoReq);

    public TipoSuelo editarDatosBasicos(Long id_tipo_suelo, TipoSueloBasicDtoReq tipoSueloBaicDtoReq);

    public PageResponse<TipoSueloAdminDtoResp> getAll(String nombre, String color, Boolean active, Pageable pageable);

    public TipoSueloDetailsDtoResp getDetailsById(Long id);

    public void eliminarTexturaDeTipoSuelo(Long id_textura, Long id_tipo_suelo);

}
