
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.REPOSITORY;

import com.nexus.demo.DTOS.RESPONSE.CATEGORIA_PRODUCTO.CategoriaProductoAdminDtoResp;
import com.nexus.demo.ENTITIES.CategoriaProducto;
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
public interface CategoriaRepository extends JpaRepository<CategoriaProducto, Long> {

    @Query("""
           SELECT cp
           
           FROM CategoriaProducto cp
           
           WHERE (LOWER(cp.nombre) = LOWER(:nombre))
           AND (cp.isDelete = false)
           
           """)
    public Optional<CategoriaProducto> existeAndEstaActivo(@Param(value = "nombre") String nombre);

    @Query("""
           SELECT DISTINCT NEW com.nexus.demo.DTOS.RESPONSE.CATEGORIA_PRODUCTO.CategoriaProductoAdminDtoResp(
           cp.id,
           cp.nombre,
           cp.descripcion
           )
           
           FROM CategoriaProducto cp
           
           WHERE(:nombre IS NULL OR LOWER(cp.nombre) LIKE CONCAT( LOWER(CAST(:nombre AS string)), '%'))
           AND (:is_delete IS NULL OR cp.isDelete = :is_delete)
           """)
    public Page<CategoriaProductoAdminDtoResp> getAllAdmin(
            @Param(value = "nombre") String nombre,
            @Param(value = "is_delete") Boolean is_delete,
            Pageable pageable
    );

    @Query("""
           SELECT DISTINCT NEW com.nexus.demo.DTOS.RESPONSE.CATEGORIA_PRODUCTO.CategoriaProductoAdminDtoResp(
           cp.id,
           cp.nombre,
           cp.descripcion
           )
           
           FROM CategoriaProducto cp
           
           WHERE(cp.id = :id)
           """)
    public Optional<CategoriaProductoAdminDtoResp> getCategoriaById(
            @Param(value = "id") Long id);
}
