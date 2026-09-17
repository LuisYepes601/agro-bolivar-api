/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.REPOSITORY;

import com.nexus.demo.DTOS.RESPONSE.FAMILIA_BOTANICA.FamiliaBotanicaAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.FAMILIA_BOTANICA.FamiliaBotanicaDetailsDtoResp;
import com.nexus.demo.ENTITIES.FamiliaBotanica;
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
public interface FamiliaBotanicaRepository extends JpaRepository<FamiliaBotanica, Long> {

    @Query("""
           SELECT fb
           
           FROM FamiliaBotanica fb
           
           WHERE (LOWER(fb.nombre) = LOWER(:nombre))
           AND (fb.isDelete = false)
           """)
    public Optional<FamiliaBotanica> existeAndEstaActivo(@Param(value = "nombre") String nombre);

    @Query("""
           SELECT DISTINCT NEW com.nexus.demo.DTOS.RESPONSE.FAMILIA_BOTANICA.FamiliaBotanicaAdminDtoResp(
           
           fb.id,
           fb.nombre,
           fb.descripcion,
           fb.updateAt,
           fb.createAt
           )
           
           FROM FamiliaBotanica fb
           WHERE(:nombre IS NULL OR LOWER(fb.nombre) LIKE CONCAT(LOWER(CAST(:nombre AS string)),'%'))
           AND (:is_delete IS NULL OR fb.isDelete = :is_delete)
           """)
    public Page<FamiliaBotanicaAdminDtoResp> getAllAdmin(
            @Param(value = "nombre") String nombre,
            @Param(value = "is_delete") Boolean is_delete,
            Pageable pageable);

    @Query("""
           SELECT NEW com.nexus.demo.DTOS.RESPONSE.FAMILIA_BOTANICA.FamiliaBotanicaDetailsDtoResp(
           fb.deleteAt,
           fb.isDelete,
           fb.createBy,
           fb.creatorName,
           fb.updateBy,
           fb.updateName,
           fb.deleteBy,
           fb.deleteName
           
           )
           
           FROM FamiliaBotanica fb
           
           WHERE(fb.id = :id)
           
           """)
    public Optional<FamiliaBotanicaDetailsDtoResp> getDetailsByID(@Param(value = "id") Long id);
}
