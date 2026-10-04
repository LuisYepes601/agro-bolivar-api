/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.INVENTARIO;

import com.nexus.demo.AuditableUtils;
import com.nexus.demo.DTOS.REQUEST.PRODUCTO.ProductoAdminDtoReq;
import com.nexus.demo.ENTITIES.Inventario;
import com.nexus.demo.ENTITIES.InventarioProducto;
import com.nexus.demo.ENTITIES.Producto;
import com.nexus.demo.GLOBALEXCEPTIONHANDLER.exceptions.DatoInvalidoEcxeption;
import com.nexus.demo.REPOSITORY.InventarioProductoRepository;
import com.nexus.demo.REPOSITORY.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author luis
 */
@Service
public class InventarioService implements IInventarioService {
    
    private InventarioProductoRepository inventarioProductoRepository;
    
    @Autowired
    public InventarioService(InventarioProductoRepository inventarioProductoRepository) {
        this.inventarioProductoRepository = inventarioProductoRepository;
    }
    
    @Transactional(rollbackFor = Exception.class)
    @Override
    public InventarioProducto asignarProductoAInventario(Producto producto, Inventario inventario, ProductoAdminDtoReq productoAdminDtoReq) {
        
        InventarioProducto inventarioProducto = new InventarioProducto();
        
        inventarioProducto.setProducto(producto);
        inventarioProducto.setInventario(inventario);
        
        if (productoAdminDtoReq.getCantActual() < productoAdminDtoReq.getCantidadMinima()) {
            
            throw new DatoInvalidoEcxeption("La cantidad minima no puede ser menor a la cantidad actual.");
        }
        
        if (productoAdminDtoReq.getCantActual() > productoAdminDtoReq.getCantidadMax()) {
            
            throw new DatoInvalidoEcxeption("La cantidad actual no puede ser mayor a la cantidad maxima.");
        }
        
        if (productoAdminDtoReq.getCantidadMinima() > productoAdminDtoReq.getCantidadMax()) {
            
            throw new DatoInvalidoEcxeption("La cantidad minima no puede ser mayor a la cantidad maxima.");
        }
        
        inventarioProducto.setCantActual(productoAdminDtoReq.getCantActual());
        inventarioProducto.setCantidadMax(productoAdminDtoReq.getCantidadMax());
        inventarioProducto.setCantidadMinima(productoAdminDtoReq.getCantidadMinima());
        
        AuditableUtils.create(inventarioProducto, "prueba", "prueba");
        
        return inventarioProductoRepository.save(inventarioProducto);
    }
    
}
