/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.REPOSITORY;

import com.nexus.demo.DTOS.RESPONSE.ESTACION_CULTIVO.EstacionCultivoAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.ESTACION_CULTIVO.EstacionCultivoDetailsDtoResp;
import com.nexus.demo.ENTITIES.EstacionCultivo;
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
public interface EstacionCultivoRepository extends JpaRepository<EstacionCultivo, Long> {

    @Query("""
           SELECT ec
           
           FROM EstacionCultivo ec
           
           WHERE (LOWER(ec.nombre) = LOWER(:nombre))
           AND (ec.isDelete = false)
           
           """)
    public Optional<EstacionCultivo> existeYEstaActivo(@Param(value = "nombre") String nombre);

    @Query("""
           SELECT NEW com.nexus.demo.DTOS.RESPONSE.ESTACION_CULTIVO.EstacionCultivoAdminDtoResp(
           ec.id,
           ec.nombre,
           ec.descripcion,
           ec.fechaInicio,
           ec.fechaFin
           )
           
           FROM EstacionCultivo ec
           WHERE(:nombre IS NULL OR LOWER(ec.nombre) LIKE CONCAT(LOWER(CAST(:nombre AS string)),'%'))
           AND (:is_delete IS NULL OR ec.isDelete = :is_delete)
           
           """)
    public Page<EstacionCultivoAdminDtoResp> getAllAdmin(
            @Param(value = "nombre") String nombre,
            @Param(value = "is_delete") Boolean is_delete,
            Pageable pageable);

    @Query("""
           SELECT NEW com.nexus.demo.DTOS.RESPONSE.ESTACION_CULTIVO.EstacionCultivoDetailsDtoResp(
           ec.deleteAt,
           ec.isDelete,
           ec.createBy,
           ec.creatorName,
           ec.updateBy,
           ec.updateName,
           ec.deleteBy,
           ec.deleteName
           )
           
           FROM EstacionCultivo ec
           WHERE (ec.id = :id)
           """)
    public Optional<EstacionCultivoDetailsDtoResp> getDetailsById(@Param(value = "id") Long id);
}
