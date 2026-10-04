/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.REPOSITORY;

import com.nexus.demo.DTOS.RESPONSE.TIPO_DOCUMENTO.TipoDocumentoAdminDtoResp;
import com.nexus.demo.ENTITIES.TipoDocumento;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author luis
 */
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Long> {

    @Query("""
           SELECT td
           
           FROM TipoDocumento td
           
           WHERE(:nombre IS NULL OR LOWER(td.nombre) = LOWER(:nombre))
           AND (td.isDelete = false)
           
           """)
    public Optional<TipoDocumento> existeAndEstaActivo(@Param(value = "nombre") String nombre);

    @Query("""
           SELECT DISTINCT NEW com.nexus.demo.DTOS.RESPONSE.TIPO_DOCUMENTO.TipoDocumentoAdminDtoResp(
           
           td.id,
           td.nombre,
           td.descripcion
           
           )
           
           FROM TipoDocumento td
           
           WHERE (:nombre IS NULL OR LOWER(td.nombre) LIKE CONCAT (LOWER(CAST(:nombre AS string)),'%'))
           AND (:is_delete IS NULL OR td.isDelete = :is_delete)
           
           
           """)
    public Page<TipoDocumentoAdminDtoResp> getAllAdmin(
            @Param(value = "nombre") String nombre,
            @Param(value = "is_delete") Boolean is_delete,
            Pageable pageable
    );

    @Query("""
           SELECT DISTINCT NEW com.nexus.demo.DTOS.RESPONSE.TIPO_DOCUMENTO.TipoDocumentoAdminDtoResp(
           
           td.id,
           td.nombre,
           td.descripcion
           
           )
           
           FROM TipoDocumento td
           
           WHERE (td.id = :id)
           
           """)
    public Optional<TipoDocumentoAdminDtoResp> obtenerById(@Param(value = "id") Long id);
}
