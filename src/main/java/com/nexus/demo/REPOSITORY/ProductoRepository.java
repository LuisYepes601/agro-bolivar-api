/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.REPOSITORY;

import com.nexus.demo.DTOS.RESPONSE.PRODUCTO.ProductoAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.PRODUCTO.ProductoDtoResp;
import com.nexus.demo.ENTITIES.Producto;
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
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("""
           SELECT DISTINCT NEW com.nexus.demo.DTOS.RESPONSE.PRODUCTO.ProductoDtoResp(
           p.id,
           p.nombre,
           p.descripcion,
           p.precioUnidad,
           c.id,
           c.nombre,
           p.imgProdcuto,
           us.telefono
           
           
           )
           
           FROM Producto p
           LEFT JOIN p.categoriaProducto c
           LEFT JOIN p.marcaProducto mp
           LEFT JOIN p.usuario us
           
           WHERE (:nombre IS NULL OR LOWER(p.nombre) LIKE CONCAT (LOWER(CAST(:nombre AS string)), '%'))
           AND (:id_categoria IS NULL OR c.id = :id_categoria)
           AND (:id_user IS NULL OR us.id = :id_user)
           AND (:id_marca_producto IS NULL OR mp.id = :id_marca_producto)
           AND(
           (p.precioUnidad BETWEEN :precio_min AND :precio_max)
           OR (:precio_min IS NULL AND :precio_max IS NULL) 
           OR (:precio_max IS NULL)
           OR(:precio_min IS NULL)
           )
           
           """)
    public Page<ProductoDtoResp> getAllBasic(
            @Param(value = "nombre") String nombre,
            @Param(value = "id_categoria") Long id_categoria,
            @Param(value = "id_user") Long id_user,
            @Param(value = "id_marca_producto") Long id_marca_producto,
            @Param(value = "precio_min") Double precio_min,
            @Param(value = "precio_max") Double precio_max,
            Pageable pageable
    );

    @Query("""
           SELECT NEW com.nexus.demo.DTOS.RESPONSE.PRODUCTO.ProductoAdminDtoResp(
           p.id, 
           p.nombre,
           p.descripcion,
           p.precioUnidad,
           c.nombre,
           p.imgProdcuto,
           mp.nombre,
           up.nombre,
           p.peso,
           ip.cantidadMinima,
           ip.cantidadMax,
           ip.cantActual
             
           
           )
           
           FROM Producto p
           LEFT JOIN p.categoriaProducto c
           LEFT JOIN p.marcaProducto mp
           LEFT JOIN p.unidadPeso up
           LEFT JOIN p.inventarios ip
           
           WHERE (p.id = :id_producto)
           
           """)
    public Optional<ProductoAdminDtoResp> getProductoByIdAdmin(@Param(value = "id_producto") Long id_producto);
}
