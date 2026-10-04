/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.REPOSITORY;

import com.nexus.demo.ENTITIES.InventarioProducto;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author luis
 */
public interface InventarioProductoRepository extends JpaRepository<InventarioProducto, Long>{
    
    
    @Query("""
           
           SELECT ip
           
           FROM InventarioProducto ip
           
           WHERE (ip.producto.id = :id)
           """)
    public Optional<InventarioProducto>getByIdProducto(@Param(value = "id")Long id);
}
