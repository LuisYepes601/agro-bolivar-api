/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.REPOSITORY;

import com.nexus.demo.DTOS.REQUEST.TIPO_PLANTA.TipoPlantaDetailsDtoResp;
import com.nexus.demo.DTOS.RESPONSE.TIPO_PLANTA.TipoPlantaAdminDtoResp;
import com.nexus.demo.ENTITIES.TipoPlanta;
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
public interface TipoPlantaRepository extends JpaRepository<TipoPlanta, Long> {

    @Query("""
           SELECT tp
           
           FROM TipoPlanta tp
           
           WHERE (LOWER(tp.nombre) = LOWER(:nombre))
           AND (tp.isDelete = false)
           
           """)
    public Optional<TipoPlanta> existeYEstaActivo(@Param(value = "nombre") String nombre);

    @Query("""
           SELECT NEW com.nexus.demo.DTOS.RESPONSE.TIPO_PLANTA.TipoPlantaAdminDtoResp(
           tp.id,
           tp.nombre,
           tp.descripcion,
           tp.createAt,
           tp.updateAt,
           tp.createBy
           )
           
           FROM TipoPlanta tp
           
           WHERE(:nombre IS NULL OR LOWER(tp.nombre) LIKE CONCAT(LOWER(CAST(:nombre AS string)),'%'))
           AND (:is_delete IS NULL OR tp.isDelete = :is_delete)
           
           """)
    public Page<TipoPlantaAdminDtoResp> getAllAdmin(
            @Param(value = "nombre") String nombre,
            @Param(value = "is_delete") Boolean is_delete,
            Pageable pageable);

    @Query("""
           SELECT NEW com.nexus.demo.DTOS.REQUEST.TIPO_PLANTA.TipoPlantaDetailsDtoResp(
           tp.deleteAt,
           tp.isDelete,
           tp.creatorName,
           tp.updateBy,
           tp.updateName,
           tp.deleteBy,
           tp.deleteName
           )
           
           FROM TipoPlanta tp
           WHERE(tp.id = :id)
           
           """)
    public Optional<TipoPlantaDetailsDtoResp> getDetailsByID(@Param(value = "id") Long id);
}
