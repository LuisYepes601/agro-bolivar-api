/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.REPOSITORY;

import com.nexus.demo.DTOS.RESPONSE.UNIDAD_AREA.UnidadAreaAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.UNIDAD_AREA.UnidadAreaDetailsDtoResp;
import com.nexus.demo.ENTITIES.UnidadArea;
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
public interface UnidadAreaRepository extends JpaRepository<UnidadArea, Long> {

    @Query("""
           SELECT up
           
           FROM UnidadArea up
           
           WHERE(LOWER(up.nombre) = LOWER(:nombre))
           AND (up.isDelete = false)
           """)
    public Optional<UnidadArea> existeAndEstaActivo(@Param(value = "nombre") String nombre);

    @Query("""
           SELECT NEW com.nexus.demo.DTOS.RESPONSE.UNIDAD_AREA.UnidadAreaAdminDtoResp(
               up.id,
               up.nombre,
               up.descripcion,
               up.createAt,
               up.updateAt
           )
           FROM UnidadArea up
           WHERE (:nombre IS NULL OR 
                  LOWER(up.nombre) LIKE LOWER(CONCAT(CAST(:nombre AS string), '%')))
           AND (:isDelete IS NULL OR up.isDelete = :isDelete)
           ORDER BY up.id DESC
           """)
    Page<UnidadAreaAdminDtoResp> getAllAdmin(
            @Param("nombre") String nombre,
            @Param("isDelete") Boolean isDelete,
            Pageable pageable
    );

    @Query("""
           SELECT NEW com.nexus.demo.DTOS.RESPONSE.UNIDAD_AREA.UnidadAreaDetailsDtoResp(
           ua.deleteAt,
           ua.isDelete,
           ua.createBy,
           ua.creatorName,
           ua.updateBy,
           ua.updateName,
           ua.deleteBy,
           ua.deleteName
           )
           
           FROM UnidadArea ua
           
           
           WHERE(ua.id = :id)
           """)
    public Optional<UnidadAreaDetailsDtoResp> getDetailByID(@Param(value = "id") Long id);

}
