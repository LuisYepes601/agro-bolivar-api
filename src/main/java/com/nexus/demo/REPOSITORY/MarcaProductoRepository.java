/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.REPOSITORY;

import com.nexus.demo.ENTITIES.MarcaProducto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author luis
 */
public interface MarcaProductoRepository extends JpaRepository<MarcaProducto, Long>{
    
}
