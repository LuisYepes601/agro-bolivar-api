/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.REPOSITORY;

import com.nexus.demo.DTOS.RESPONSE.GENERO_PLANTA.GeneroPlantaAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.GENERO_PLANTA.GeneroPlantaDetailsDtoResp;
import com.nexus.demo.ENTITIES.GeneroPlanta;
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
public interface GeneroPlantaRepository extends JpaRepository<GeneroPlanta, Long> {

    @Query("""
           SELECT gp
           
           FROM GeneroPlanta gp
           
           WHERE(LOWER(gp.nombre) = LOWER(:nombre))
           AND (gp.isDelete = false)
           
           """)
    public Optional<GeneroPlanta> existeAndEstaActivo(@Param(value = "nombre") String nombre);

    @Query("""
           SELECT DISTINCT NEW com.nexus.demo.DTOS.RESPONSE.GENERO_PLANTA.GeneroPlantaAdminDtoResp(
           gp.id, 
           gp.nombre,
           gp.descripcion, 
           gp.createAt,
           gp.updateAt
           )
           
           FROM GeneroPlanta gp
           
           WHERE(:nombre IS NULL OR LOWER(gp.nombre) LIKE CONCAT(LOWER(CAST(:nombre AS string)),'%'))
           AND (:is_delete IS NULL OR gp.isDelete = :is_delete)
           
           """)
    public Page<GeneroPlantaAdminDtoResp> getAllAdmin(
            @Param(value = "nombre") String nombre,
            @Param(value = "is_delete") Boolean is_delete,
            Pageable pageable);
    
    
    @Query("""
           SELECT NEW com.nexus.demo.DTOS.RESPONSE.GENERO_PLANTA.GeneroPlantaDetailsDtoResp(
           gp.deleteAt,
           gp.isDelete,
           gp.createBy,
           gp.creatorName,
           gp.updateBy,
           gp.updateName,
           gp.deleteBy,
           gp.deleteName
           
           )
           
           FROM GeneroPlanta gp
           
           WHERE (gp.id = :id)
           
           """)
    public Optional<GeneroPlantaDetailsDtoResp>getDetailsById(@Param(value = "id")Long id);
}
