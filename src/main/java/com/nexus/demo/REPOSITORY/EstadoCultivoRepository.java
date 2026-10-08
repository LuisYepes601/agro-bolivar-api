/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.REPOSITORY;

import com.nexus.demo.DTOS.RESPONSE.ESTACION_CULTIVO.EstadoCultivoAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.ESTADO_CULTIVO.EstadoCultivoDetailsDtoResp;
import com.nexus.demo.ENTITIES.EstadoCultivo;
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
public interface EstadoCultivoRepository extends JpaRepository<EstadoCultivo, Long> {

    @Query("""
           SELECT ec
           FROM EstadoCultivo ec
           
           WHERE(LOWER(ec.nombre) = LOWER(:nombre))
           AND ec.isDelete = false
           """)
    public Optional<EstadoCultivo> existeAndEstaActivo(@Param(value = "nombre") String nombre);

    @Query("""
    SELECT NEW com.nexus.demo.DTOS.RESPONSE.ESTACION_CULTIVO.EstadoCultivoAdminDtoResp(
        ec.id,
        ec.nombre,
        ec.descripcion,
        ec.createAt,
        ec.updateAt
    )
    FROM EstadoCultivo ec
           
    WHERE (:nombre IS NULL OR LOWER(ec.nombre) LIKE CONCAT(LOWER(CAST(:nombre AS string)), '%'))
      AND (:isDelete IS NULL OR ec.isDelete = :isDelete)
    ORDER BY ec.id DESC
           
    """)
    Page<EstadoCultivoAdminDtoResp> getAllAdmin(
            @Param("nombre") String nombre,
            @Param("isDelete") Boolean isDelete,
            Pageable pageable
    );

    @Query("""
           
           SELECT NEW com.nexus.demo.DTOS.RESPONSE.ESTADO_CULTIVO.EstadoCultivoDetailsDtoResp(
           ec.deleteAt,
           ec.isDelete,
           ec.createBy,
           ec.creatorName,
           ec.updateBy,
           ec.updateName,
           ec.deleteBy,
           ec.deleteName
           
           )
           
           FROM EstadoCultivo ec
           WHERE(ec.id = :id)
           """)
    public Optional<EstadoCultivoDetailsDtoResp> getDetailsByID(@Param(value = "id") Long id);
}
