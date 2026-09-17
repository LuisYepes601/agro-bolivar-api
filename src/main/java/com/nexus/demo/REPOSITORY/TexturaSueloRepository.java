/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.REPOSITORY;

import com.nexus.demo.ENTITIES.TexturaSuelo;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author luis
 */
public interface TexturaSueloRepository extends JpaRepository<TexturaSuelo, Long>{
 
    
        @Query("""
               SELECT ts
               
               FROM TexturaSuelo ts
               
               WHERE(LOWER(ts.nombre) = LOWER(:nombre))
               AND(ts.isDelete = false)
               
               """)
        public Optional<TexturaSuelo>existeAndEstaActivo(@Param(value = "nombre")String nombre);

}
