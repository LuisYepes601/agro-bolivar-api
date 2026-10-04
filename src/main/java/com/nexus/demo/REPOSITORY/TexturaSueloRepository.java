/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.REPOSITORY;

import com.nexus.demo.DTOS.RESPONSE.TEXTURA_SUELO.TexturaSueloAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.TEXTURA_SUELO.TexturaSueloDetailsDtoResp;
import com.nexus.demo.ENTITIES.TexturaSuelo;
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
public interface TexturaSueloRepository extends JpaRepository<TexturaSuelo, Long> {

    @Query("""
               SELECT ts
               
               FROM TexturaSuelo ts
               
               WHERE(LOWER(ts.nombre) = LOWER(:nombre))
               AND(ts.isDelete = false)
               
               """)
    public Optional<TexturaSuelo> existeAndEstaActivo(@Param(value = "nombre") String nombre);

    @Query("""
           SELECT NEW com.nexus.demo.DTOS.RESPONSE.TEXTURA_SUELO.TexturaSueloAdminDtoResp(
           ts.id, 
           ts.nombre,
           ts.descripcion, 
           ts.forma,
           ts.createAt,
           ts.updateAt
           
           )
           
           FROM TexturaSuelo ts
           WHERE(:nombre IS NULL OR LOWER (ts.nombre) LIKE CONCAT(LOWER(CAST(:nombre AS string)), '%') )
           AND(:forma IS NULL OR LOWER(ts.forma) LIKE CONCAT(LOWER(CAST(:forma AS string)),'%'))
           AND(:is_delete IS NULL OR ts.isDelete = :is_delete)
           
           """)
    public Page<TexturaSueloAdminDtoResp> getAllAdmin(
            @Param(value = "nombre") String nombre,
            @Param(value = "forma") String forma,
            @Param(value = "is_delete") Boolean is_delete,
            Pageable pageable);

    @Query("""
           SELECT NEW com.nexus.demo.DTOS.RESPONSE.TEXTURA_SUELO.TexturaSueloDetailsDtoResp(
           ts.deleteAt,
           ts.isDelete,
           ts.createBy,
           ts.creatorName,
           ts.updateBy,
           ts.updateName,
           ts.deleteBy,
           ts.deleteName
           )
           
           FROM TexturaSuelo ts
           WHERE(ts.id = :id)
           """)
    public Optional<TexturaSueloDetailsDtoResp> getDetailsById(@Param(value = "id") Long id);

}
