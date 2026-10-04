/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.TIPO_DOCUMENTO;

import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.TIPO_SUELO.TipoDocumentoAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.TIPO_DOCUMENTO.TipoDocumentoAdminDtoResp;
import com.nexus.demo.ENTITIES.TipoDocumento;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author luis
 */
public interface ITipoDocumentoAdminService {
    
    public TipoDocumento create(TipoDocumentoAdminDtoReq  tipoDocumentoAdminDtoReq);
    
    public TipoDocumento update(Long id, TipoDocumentoAdminDtoReq tipoDocumentoAdminDtoReq);
    
    public PageResponse<TipoDocumentoAdminDtoResp>getAll(String nombre, Boolean active, Pageable pageable);
    
    public TipoDocumentoAdminDtoResp getById(Long id);
}
