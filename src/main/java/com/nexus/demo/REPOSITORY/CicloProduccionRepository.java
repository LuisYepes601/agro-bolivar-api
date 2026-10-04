/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.REPOSITORY;

import com.nexus.demo.DTOS.RESPONSE.CICLO_PRODUCCION.CicloProduccionAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.CICLO_PRODUCCION.CicloProduccionDetailsDtoResp;
import com.nexus.demo.ENTITIES.CicloProduccion;
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
public interface CicloProduccionRepository extends JpaRepository<CicloProduccion, Long> {

    @Query("""
           SELECT cp
           
           FROM CicloProduccion cp
           
           WHERE(LOWER(cp.nombre) = LOWER (:nombre))
           AND (cp.isDelete = false)
           """)
    public Optional<CicloProduccion> existeAndEstaActivo(@Param(value = "nombre") String nombre);

    @Query("""
           SELECT NEW com.nexus.demo.DTOS.RESPONSE.CICLO_PRODUCCION.CicloProduccionAdminDtoResp(
           cp.id,
           cp.nombre, 
           cp.diasMinimos,
           cp.diasMaximos,
           cp.descripcion,
           cp.createAt,
           cp.updateAt
           
           )
           
           FROM CicloProduccion cp
           
           WHERE(:nombre IS NULL OR LOWER(cp.nombre) LIKE CONCAT(LOWER(CAST(:nombre AS string)),'%'))
           AND(:is_delete IS NULL OR cp.isDelete = :is_delete)
                      
           """)
    public Page<CicloProduccionAdminDtoResp> getAllAdmin(
            @Param(value = "nombre") String nombre,
            @Param(value = "is_delete") Boolean is_delete,
            Pageable pageable);

    @Query("""
           SELECT NEW com.nexus.demo.DTOS.RESPONSE.CICLO_PRODUCCION.CicloProduccionDetailsDtoResp(
           
               cp.deleteAt,
               cp.isDelete,
               cp.createBy,
               cp.creatorName,
               cp.updateBy,
               cp.updateName,
               cp.deleteBy,
               cp.deleteName
           )
           
           FROM CicloProduccion cp
           WHERE (cp.id = :id)
           
           """)
    public Optional<CicloProduccionDetailsDtoResp> getDetailsByID(@Param(value = "id") Long id);
}
