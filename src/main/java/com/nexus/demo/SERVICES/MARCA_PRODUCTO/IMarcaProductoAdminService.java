/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.MARCA_PRODUCTO;

import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.MARCA_PRODUCTO.MarcaProductoAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.MARCA_PRODUCTO.MarcaProductoAdminDtoResp;
import com.nexus.demo.ENTITIES.MarcaProducto;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author luis
 */
public interface IMarcaProductoAdminService {

    public MarcaProducto create(MarcaProductoAdminDtoReq marcaProductoAdminDtoReq);
    
    public MarcaProducto update(Long id, MarcaProductoAdminDtoReq marcaProductoAdminDtoReq);
    
    public PageResponse<MarcaProductoAdminDtoResp>getAll(String nombre, Boolean delete, Pageable pageable);
    
    public MarcaProductoAdminDtoResp getByID(Long id);

}
