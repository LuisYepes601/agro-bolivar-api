/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.ROL;

import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.ROL.RolAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.ROL.RolAdminDtoResp;
import com.nexus.demo.ENTITIES.Rol;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author luis
 */
public interface IRolAdminService {

    public Rol create(RolAdminDtoReq rolAdminDtoReq);

    public Rol update(Long id, RolAdminDtoReq rolAdminDtoReq);

    public PageResponse<RolAdminDtoResp> getAll(String nombre, Boolean active, Pageable pageable);
    
    public RolAdminDtoResp getRolById(Long id);
}
