/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.REPOSITORY;

import com.nexus.demo.DTOS.RESPONSE.ROL.RolAdminDtoResp;
import com.nexus.demo.ENTITIES.Rol;
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
public interface RolRepository extends JpaRepository<Rol, Long> {

    @Query("""
           SELECT r
           
           FROM Rol r
           
           WHERE(r.isDelete = false)
           AND(LOWER(r.nombre) = LOWER(:nombre))
           
           """)
    public Optional<Rol> existeAndEstaActivo(@Param(value = "nombre") String nombre);

    @Query("""
           SELECT DISTINCT NEW com.nexus.demo.DTOS.RESPONSE.ROL.RolAdminDtoResp(
           r.id,
           r.nombre,
           r.descripcion
           )
           
           FROM Rol r
           
           WHERE(:nombre IS NULL OR LOWER(r.nombre) LIKE CONCAT(LOWER(CAST(:nombre AS string)),'%') )
           AND (:is_delete IS NULL OR r.isDelete = :is_delete)
           
           
           """)
    public Page<RolAdminDtoResp> getAllAdmin(
            @Param(value = "nombre") String nombre,
            @Param(value = "is_delete") Boolean is_delete,
            Pageable pageable);
    
        @Query("""
           SELECT DISTINCT NEW com.nexus.demo.DTOS.RESPONSE.ROL.RolAdminDtoResp(
           r.id,
           r.nombre,
           r.descripcion
           )
           
           FROM Rol r
           
           WHERE(r.id = :id)
           
           """)
    public Optional<RolAdminDtoResp>obternerRolById(@Param(value = "id")Long id);
}
