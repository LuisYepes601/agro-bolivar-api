/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.SERVICES.CATEGORIA_PRODUCTO;

import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.CATEGORIA_PRODUCTO.CategoriaAdminProdDtoReq;
import com.nexus.demo.DTOS.RESPONSE.CATEGORIA_PRODUCTO.CategoriaProductoAdminDtoResp;
import com.nexus.demo.ENTITIES.CategoriaProducto;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author luis
 */
public interface ICategoriaProductoAdminService {
    
    public CategoriaProducto create(CategoriaAdminProdDtoReq categoriaAdminProdDtoReq );
    
    public CategoriaProducto updateById(Long id, CategoriaAdminProdDtoReq categoriaAdminProdDtoReq);
    
    public PageResponse<CategoriaProductoAdminDtoResp>getAll(String nombre, Boolean delete, Pageable pageable);
    
    public CategoriaProductoAdminDtoResp getCategoriaById(Long id);
}
