/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.REPOSITORY;

import com.nexus.demo.DTOS.RESPONSE.MARCA_PRODUCTO.MarcaProductoAdminDtoResp;
import com.nexus.demo.ENTITIES.MarcaProducto;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author luis
 */
public interface MarcaProductoRepository extends JpaRepository<MarcaProducto, Long> {

    @Query("""
           SELECT mp
           
           FROM MarcaProducto mp
           
           WHERE (LOWER(mp.nombre) = LOWER(:nombre))
           AND (mp.isDelete = false)
           
           
           """)
    public Optional<MarcaProducto> existeAndEstaActivo(@Param(value = "nombre") String nombre);

    @Query("""
           SELECT DISTINCT NEW com.nexus.demo.DTOS.RESPONSE.MARCA_PRODUCTO.MarcaProductoAdminDtoResp(
           mp.id,
           mp.nombre, 
           mp.descripcion
           
           )
           
           FROM MarcaProducto mp
           
           WHERE(:nombre IS NULL OR LOWER(mp.nombre) LIKE CONCAT (LOWER(CAST(:nombre AS string )), '%'))
           AND (:is_delete IS NULL OR mp.isDelete = :is_delete)
          
           
           """)
    public Page<MarcaProductoAdminDtoResp> getAllAdmin(
            @Param(value = "nombre") String nombre,
            @Param(value = "is_delete") Boolean is_delete,
            Pageable pageable);

    @Query("""
           SELECT DISTINCT NEW com.nexus.demo.DTOS.RESPONSE.MARCA_PRODUCTO.MarcaProductoAdminDtoResp(
           mp.id,
           mp.nombre, 
           mp.descripcion
           
           )
           
           FROM MarcaProducto mp
           
           WHERE(mp.id = :id)
          
           
           """)
    public Optional<MarcaProductoAdminDtoResp> getMarcaById(@Param(value = "id") Long id);

}
