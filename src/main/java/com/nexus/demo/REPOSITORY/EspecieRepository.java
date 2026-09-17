/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.REPOSITORY;

import com.nexus.demo.DTOS.RESPONSE.ESPECIE_PLANTA.EspeciePlantaAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.ESPECIE_PLANTA.EspeciePlantaDetailsDtoResp;
import com.nexus.demo.ENTITIES.Especie;
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
public interface EspecieRepository extends JpaRepository<Especie, Long> {

    @Query("""
           SELECT e
           
           FROM Especie e
           
           WHERE (LOWER(e.nombre) = LOWER(:nombre))
           AND (e.isDelete = false)
           """)
    public Optional<Especie> existeAndEstaActivo(@Param(value = "nombre") String nombre);

    @Query("""
           SELECT NEW com.nexus.demo.DTOS.RESPONSE.ESPECIE_PLANTA.EspeciePlantaAdminDtoResp(
           e.id,
           e.nombre, 
           e.descripcion,
           e.createAt,
           e.updateAt
           )
           
           FROM Especie e
           
           WHERE(:nombre IS NULL OR LOWER(e.nombre) LIKE CONCAT(LOWER(CAST(:nombre AS string)),'%'))
           AND(:is_delete IS NULL OR e.isDelete = :is_delete)
           """)
    public Page<EspeciePlantaAdminDtoResp> getAllAdmin(
            @Param(value = "nombre") String nombre,
            @Param(value = "is_delete") Boolean is_delete,
            Pageable pageable
    );

    @Query("""
           SELECT NEW com.nexus.demo.DTOS.RESPONSE.ESPECIE_PLANTA.EspeciePlantaDetailsDtoResp(
           e.deleteAt,
           e.isDelete,
           e.createBy,
           e.creatorName,
           e.updateBy,
           e.updateName,
           e.deleteBy,
           e.deleteName
           )
           
           FROM Especie e
           WHERE(e.id = :id)
           
           """)
    public Optional<EspeciePlantaDetailsDtoResp> getDetailsByID(@Param(value = "id") Long id);
}
