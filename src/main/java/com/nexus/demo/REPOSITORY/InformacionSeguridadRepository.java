/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.REPOSITORY;

import com.nexus.demo.DTOS.RESPONSE.INFORMACION_SEGURIDAD.InformacionSeguridadDtoResp;
import com.nexus.demo.ENTITIES.InformacionSeguridad;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author luis
 */
public interface InformacionSeguridadRepository extends JpaRepository<InformacionSeguridad, Long> {

    @Query("""
           SELECT NEW com.nexus.demo.DTOS.RESPONSE.INFORMACION_SEGURIDAD.InformacionSeguridadDtoResp(
           
           is.id,
           is.esToxico,
           is.descripcion,
           is.esCorrosivo,
           is.esInflamable,
           is.esPeligroso,
           is.requiereEquipoProteccion,
           is.requiereManejoEspecial,
           is.precauciones,
           is.advertencias,
           is.instruccionesManejo,
           is.instruccionesAlmacenamiento
           
        
           
           )
           
           FROM InformacionSeguridad is
           LEFT JOIN is.prodcuto p
           
           WHERE (p.id =:id_prod)
           
           """)
    public Optional<InformacionSeguridadDtoResp> obtenerByIdProducto(
            @Param(value = "id_prod") Long id_prod);
}
