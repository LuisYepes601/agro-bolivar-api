/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.REPOSITORY;

import com.nexus.demo.DTOS.RESPONSE.UNIDAD_PESO.UnidadPesoAdminDetailsDtoResp;
import com.nexus.demo.DTOS.RESPONSE.UNIDAD_PESO.UnidadPesoAdminDtoResp;
import com.nexus.demo.ENTITIES.UnidadPeso;
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
public interface UnidadPesoRepository extends JpaRepository<UnidadPeso, Long> {

    @Query("""
           SELECT up
           
           FROM UnidadPeso up
           
           WHERE(LOWER(up.nombre) = LOWER(:nombre))
           AND (up.isDelete = false)
           """)
    public Optional<UnidadPeso> existeAndEstaActivo(@Param(value = "nombre") String nombre);

    @Query("""
       SELECT NEW com.nexus.demo.DTOS.RESPONSE.UNIDAD_PESO.UnidadPesoAdminDtoResp(
           up.id,
           up.nombre,
           up.descripcion,
           up.createAt,
           up.updateAt
       )
       FROM UnidadPeso up
           
       WHERE (:nombre IS NULL OR 
              LOWER(up.nombre) LIKE LOWER(CONCAT(CAST(:nombre AS string), '%')))
       AND (:isDelete IS NULL OR up.isDelete = :isDelete)
       ORDER BY up.id DESC
       """)
    Page<UnidadPesoAdminDtoResp> getAllAdmin(
            @Param("nombre") String nombre,
            @Param("isDelete") Boolean isDelete,
            Pageable pageable
    );

    @Query("""
       SELECT NEW com.nexus.demo.DTOS.RESPONSE.UNIDAD_PESO.UnidadPesoAdminDetailsDtoResp(
           up.deleteAt,
           up.isDelete,
           up.createBy,
           up.creatorName,
           up.updateBy,
           up.updateName,
           up.deleteBy,
           up.deleteName
       )
       FROM UnidadPeso up
       WHERE up.id = :id
       """)
    Optional<UnidadPesoAdminDetailsDtoResp> getDetailByID(
            @Param("id") Long id
    );
}
