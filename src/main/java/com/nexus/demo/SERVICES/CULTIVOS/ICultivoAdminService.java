/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.SERVICES.CULTIVOS;

import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.CULTIVO.CultivoAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.CULTIVO.CultivoAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.CULTIVO.CultivoDtoResp;
import com.nexus.demo.ENTITIES.Cultivo;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author luis
 */
public interface ICultivoAdminService {

    public Cultivo create(CultivoAdminDtoReq cultivoAdminDtoReq, MultipartFile fotoCultivo);

    public Cultivo updateById(Long id, CultivoAdminDtoReq cultivoAdminDtoReq);

    public Cultivo editarFotoCultivo(Long id, MultipartFile foto);

    public PageResponse<CultivoAdminDtoResp> getAll(String nombre, Boolean estado, Boolean active, Pageable pageable);

    public CultivoDtoResp getCultivoPorId(Long id);

}
