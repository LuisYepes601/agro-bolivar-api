/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.REPOSITORY;

import com.nexus.demo.DTOS.RESPONSE.TIPO_SUELO.TipoSueloAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.TIPO_SUELO.TipoSueloDetailsDtoResp;
import com.nexus.demo.ENTITIES.TipoSuelo;
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
public interface TipoSueloRepository extends JpaRepository<TipoSuelo, Long> {

    @Query("""
           SELECT ts
           
           FROM TipoSuelo ts
           
           WHERE (LOWER(ts.nombre) = LOWER(:nombre))
           AND (ts.isDelete = false)
           
           """)
    public Optional<TipoSuelo> existeAndEstaActivo(@Param(value = "nombre") String nombre);

    @Query("""
           SELECT NEW com.nexus.demo.DTOS.RESPONSE.TIPO_SUELO.TipoSueloAdminDtoResp(
           ts.id,
           ts.nombre,
           ts.descripcion,
           ts.phMinimo,
           ts.phMaximo,
           ts.color
           
           )
           
           FROM TipoSuelo ts
           
           WHERE(:nombre IS NULL OR LOWER(ts.nombre) LIKE CONCAT(LOWER(CAST(:nombre AS string)), '%'))
           AND(:color IS NULL OR LOWER(ts.color) LIKE CONCAT(LOWER(CAST(:color AS string)),'%'))
           AND(:is_delete IS NULL OR ts.isDelete = :is_delete)
           
           """)
    public Page<TipoSueloAdminDtoResp> getAllAdmin(
            @Param(value = "nombre") String nombre,
            @Param(value = "color") String color,
            @Param(value = "is_delete") Boolean is_delete,
            Pageable pageable);

    @Query("""
           SELECT NEW com.nexus.demo.DTOS.RESPONSE.TIPO_SUELO.TipoSueloDetailsDtoResp(
           ts.createAt,
           ts.updateAt,
           ts.deleteAt,
           ts.isDelete,
           ts.createBy,
           ts.creatorName,
           ts.updateBy,
           ts.updateName,
           ts.deleteBy,
           ts.deleteName
           
           )
           
           FROM TipoSuelo ts
           WHERE(ts.id = :id)
           
           """)
    public Optional<TipoSueloDetailsDtoResp> getDetailsById(@Param(value = "id") Long id);
}
