/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.REPOSITORY;

import com.nexus.demo.ENTITIES.Planta;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.Optional;
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
}
