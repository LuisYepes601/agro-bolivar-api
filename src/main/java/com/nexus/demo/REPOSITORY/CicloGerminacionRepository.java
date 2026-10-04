/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.REPOSITORY;

import com.nexus.demo.DTOS.RESPONSE.CICLO_GERMINACION.CicloGerminacionAdminDetailsDtoResp;
import com.nexus.demo.DTOS.RESPONSE.CICLO_GERMINACION.CicloGerminacionAdminDtoResp;
import com.nexus.demo.ENTITIES.CicloGerminacion;
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
public interface CicloGerminacionRepository extends JpaRepository<CicloGerminacion, Long> {

    @Query("""
           SELECT cg
           
           FROM CicloGerminacion cg
           
           WHERE (LOWER(cg.nombre) = LOWER(:nombre))
           AND (cg.isDelete = false)
           
           """)
    public Optional<CicloGerminacion> existeAndEstaActivo(@Param(value = "nombre") String nombre);

    @Query("""
           SELECT DISTINCT NEW com.nexus.demo.DTOS.RESPONSE.CICLO_GERMINACION.CicloGerminacionAdminDtoResp(
           cg.id,
           cg.nombre,
           cg.diasMinimos,
           cg.diasMaximos,
           cg.descripcion,
           cg.createAt,
           cg.updateAt
           
           )
           
           FROM CicloGerminacion cg
           
           WHERE(:nombre IS NULL OR LOWER(cg.nombre) LIKE CONCAT(LOWER(CAST(:nombre AS string)), '%'))
           AND (:is_delete IS NULL OR cg.isDelete = :is_delete)
           
           """)
    public Page<CicloGerminacionAdminDtoResp> getAll(
            @Param(value = "nombre") String nombre,
            @Param(value = "is_delete") Boolean is_delete,
            Pageable pageable);

    @Query("""
           SELECT NEW com.nexus.demo.DTOS.RESPONSE.CICLO_GERMINACION.CicloGerminacionAdminDetailsDtoResp(

           cg.deleteAt,
           cg.isDelete,
           cg.createBy,
           cg.creatorName,
           cg.updateBy,
           cg.updateName,
           cg.deleteBy,
           cg.deleteName
           
           )
           
           FROM CicloGerminacion cg
           WHERE (cg.id = :id)
           
           """)
    public Optional<CicloGerminacionAdminDetailsDtoResp> getDetailsById(@Param(value = "id") Long id);

}
