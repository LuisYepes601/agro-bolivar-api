/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.REPOSITORY;

import com.nexus.demo.DTOS.RESPONSE.CULTIVO.CultivoAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.CULTIVO.CultivoDtoResp;
import com.nexus.demo.ENTITIES.Cultivo;
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
public interface CultivoRepository extends JpaRepository<Cultivo, Long> {

    @Query("""
           SELECT NEW com.nexus.demo.DTOS.RESPONSE.CULTIVO.CultivoAdminDtoResp(
           c.id,
           p.nombre,
           u.email,
           u.telefono,
           p.imgPlanta,
           ec.nombre,
           c.precioPorKg
           
           )
           
           FROM Cultivo c
           LEFT JOIN c.planta p
           LEFT JOIN c.usuario u
           LEFT JOIN c.estadoCultivo ec
           
           WHERE (:nombre_cultivo IS NULL OR LOWER(p.nombre) LIKE CONCAT(LOWER(CAST(:nombre_cultivo AS string)),'%'))
           AND(:id_estado IS NULL OR ec.id = :id_estado)
           AND(:is_delete IS NULL OR c.isDelete = :is_delete)
           AND (:id_usuario IS NULL OR c.usuario.id = :id_usuario)
           
           
           """)
    public Page<CultivoAdminDtoResp> getAllAdmin(
            @Param(value = "nombre_cultivo") String nombre_cultivo,
            @Param(value = "id_estado") Boolean id_estado,
            @Param(value = "is_delete") Boolean is_delete,
            @Param(value = "id_usuario")Long id_usuario,
            Pageable pageable);

    @Query("""
           SELECT NEW com.nexus.demo.DTOS.RESPONSE.CULTIVO.CultivoDtoResp(
           c.id,
           u.id,
           u.primerNombre,
           p.nombre,
           c.imgCultivo,
           c.fechaInicio,
           c.fechaEstimadaFin,
           c.cantidadSembrada,
           up.id,
           up.nombre,
           c.areaSembrada,
           ua.id,
           ua.nombre,
           ec.id,
           ec.nombre,
           c.cantidadDisponible,
           c.precioPorKg,
           c.cantidadDisponibleParaVenta,
           u.email,
           u.telefono
               
           
           )
           
           FROM Cultivo c
           LEFT JOIN c.usuario u
           LEFT JOIN c.planta p
           LEFT JOIN c.unidadPeso up
           LEFT JOIN c.unidadArea ua
           LEFT JOIN c.estadoCultivo ec
           
           """)
    public Optional<CultivoDtoResp> ObtenerById(
            @Param(value = "id") Long id);
}
