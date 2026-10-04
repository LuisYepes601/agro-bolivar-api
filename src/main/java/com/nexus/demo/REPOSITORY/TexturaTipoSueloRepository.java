/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.REPOSITORY;

import com.nexus.demo.ENTITIES.TexturaTipoSuelo;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author luis
 */
public interface TexturaTipoSueloRepository extends JpaRepository<TexturaTipoSuelo, Long> {

    @Query("""
           
           SELECT tts
           
           FROM TexturaTipoSuelo tts
           LEFT JOIN tts.tipoSuelo ts
           LEFT JOIN tts.texturaSuelo tsu
           
           WHERE(ts.id = :id_tipo_suelo)
           AND (tsu.id = :id_textura)
           AND (tts.isDelete = false)
           """)
    public Optional<TexturaTipoSuelo> existeAndEstaActivo(
            @Param(value = "id_tipo_suelo") Long id_tipo_suelo,
            @Param(value = "id_textura") Long id_textura);
}
