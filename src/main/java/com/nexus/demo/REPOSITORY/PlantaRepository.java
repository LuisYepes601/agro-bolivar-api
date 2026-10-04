/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.REPOSITORY;

import com.nexus.demo.DTOS.RESPONSE.PLANTA.PlantaDatosBasicAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.PLANTA.PlantaEditarAdminDtoResp;
import com.nexus.demo.ENTITIES.Especie;
import com.nexus.demo.ENTITIES.Planta;
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
public interface PlantaRepository extends JpaRepository<Planta, Long> {

    @Query("""
           SELECT p
           
           FROM Planta p
           
           WHERE (LOWER(p.nombre) = LOWER(:nombre))
           AND (p.isDelete = false)
           """)
    public Optional<Planta> existeAndEstaActivo(@Param(value = "nombre") String nombre);

    @Query("""
          SELECT DISTINCT NEW  com.nexus.demo.DTOS.RESPONSE.PLANTA.PlantaDatosBasicAdminDtoResp(
          p.id,
          p.nombre,
          p.nombreCientifico,
          p.descripcion,
          fb.id,
          fb.nombre,
          gp.id,
          gp.nombre,
          es.id,
          es.nombre,
          tp.id,
          tp.nombre
          
          
          ) 
          FROM Planta p
          LEFT JOIN p.familiaBotanica fb
          LEFT JOIN p.generoPlanta gp
          LEFT JOIN p.especie es
          LEFT JOIN p.tipoPlanta tp
          LEFT JOIN p.estacionCultivo ec
           
           WHERE (:nombre IS NULL OR LOWER(p.nombre) LIKE CONCAT(LOWER(CAST(:nombre AS string)),'%'))
           AND (:is_delete IS NULL OR p.isDelete = :is_delete)
           AND(:id_especie IS NULL OR es.id = :id_especie)
           AND(:id_tipo IS NULL OR tp.id = :id_tipo)
           AND(:id_familia IS NULL OR fb.id = :id_familia)
           AND(:id_estacion_cultivo IS NULL OR ec.id = :id_estacion_cultivo)
          
          """)
    public Page<PlantaDatosBasicAdminDtoResp> getAllAdmin(
            @Param(value = "nombre") String nombre,
            @Param(value = "is_delete") Boolean is_delete,
            @Param(value = "id_especie") Long id_especie,
            @Param(value = "id_tipo") Long id_tipo,
            @Param(value = "id_familia") Long id_familia,
            @Param(value = "id_estacion_cultivo") Long id_estacion_cultivo,
            Pageable pageable);

    @Query("""
           SELECT DISTINCT NEW com.nexus.demo.DTOS.RESPONSE.PLANTA.PlantaEditarAdminDtoResp(
           p.id,
           p.nombre,
           p.nombreCientifico,
           p.descripcion,
           p.temperaturaMinima,
           p.temperaturaMaxima,
           p.temperaturaIdeal,
           p.humedadMinima,
           p.humedadMaxima,
           p.humedadIdeal,
           p.horasSolaresMinimas,
           p.horasSolaresMaximas,
           p.horasSolaresIdeales,
           p.precipitacionMinima,
           p.precipitacionMaxima,
           p.precipitacionIdeal,
           p.altitudMinima,
           p.altitudMaxima,
           p.phSueloMinimo,
           p.phSueloMaximo,
           p.phSueloIdeal,
           p.frecuenciaRiego,
           fb.id,
           fb.nombre,
           gp.id,
           gp.nombre,
           ep.id,
           ep.nombre,
           cp.id,
           cp.nombre,
           cg.id,
           cg.nombre,
           ec.id,
           ec.nombre,
           tp.id,
           tp.nombre
           
           )
           
           FROM Planta p
           LEFT JOIN p.familiaBotanica fb
           LEFT JOIN p.generoPlanta gp
           LEFT JOIN p.especie ep
           LEFT JOIN p.cicloProduccion cp
           LEFT JOIN p.cicloGerminacion cg
           LEFT JOIN p.estacionCultivo ec
           LEFT JOIN p.tipoPlanta tp
           
           WHERE (p.id = :id)
           
           """)
    public Optional<PlantaEditarAdminDtoResp> getByID(@Param(value = "id") Long id);
}
