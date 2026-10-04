/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.PRODUCTO;

import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.PRODUCTO.ProductoAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.PRODUCTO.ProductoAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.PRODUCTO.ProductoDtoResp;
import com.nexus.demo.ENTITIES.Producto;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author luis
 */
public interface IProductoAdminService {

    public Producto create(ProductoAdminDtoReq productoAdminDtoReq, MultipartFile fotoProducto);

    public PageResponse<ProductoDtoResp> getAllBasic(String nombre, Long id_cat, Long id_user, Long id_marca, Double precion_min, Double precio_max, Pageable pageable);

    public ProductoAdminDtoResp getProductoById(Long id);

    public Producto updateById(Long id, ProductoAdminDtoReq productoAdminDtoReq, MultipartFile fotoProducto);
}
