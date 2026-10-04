/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.SERVICES.INVENTARIO;

import com.nexus.demo.DTOS.REQUEST.PRODUCTO.ProductoAdminDtoReq;
import com.nexus.demo.ENTITIES.Inventario;
import com.nexus.demo.ENTITIES.InventarioProducto;
import com.nexus.demo.ENTITIES.Producto;

/**
 *
 * @author luis
 */
public interface IInventarioService {
    
    public InventarioProducto asignarProductoAInventario(Producto producto, Inventario inventario, ProductoAdminDtoReq productoAdminDtoReq);
}
