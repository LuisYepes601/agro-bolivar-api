/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.REPOSITORY;

import com.nexus.demo.DTOS.RESPONSE.DASHBOARD.DashBoardUserBasicDtoResp;
import com.nexus.demo.DTOS.RESPONSE.USUARIO.UsuarioDtoReso;
import com.nexus.demo.ENTITIES.Usuario;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author luis
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(
            """
            SELECT u
    
            FROM Usuario u

            WHERE u.email = :email  
           
    """
    )
    public Optional<Usuario> emailEnUso(
            @Param(value = "email") String email
    );

    @Query("""
           SELECT u
           
           FROM Usuario u
           
           WHERE (LOWER(u.email) = LOWER(:email))
           
           """)
    public Optional<Usuario> getUserByEmail(@Param(value = "email") String email);

    @Query("""
              SELECT NEW com.nexus.demo.DTOS.RESPONSE.DASHBOARD.DashBoardUserBasicDtoResp(
           
              u.primerNombre,
              r.nombre,
              u.imgUser
           
           )
                      
                      FROM Usuario u
                      LEFT JOIN u.rol r
                      
                      WHERE (u.id = :id)
           
           """)
    public Optional<DashBoardUserBasicDtoResp> getBasicDashboardHomeUser(@Param(value = "id") Long id);
    
    
    @Query("""
           SELECT NEW com.nexus.demo.DTOS.RESPONSE.USUARIO.UsuarioDtoReso(
           u.id,
           u.primerNombre,
           u.segundoNombre,
           u.email,
           u.apellidoPaterno,
           u.apellidoMaterno,
           r.nombre,
           td.nombre,
           u.estado,
           u.imgUser,
           u.numDocumento,
           u.telefono
           
           )
           
           FROM Usuario u
           LEFT JOIN u.rol r
           LEFT JOIN u.tipoDocumento td
           
           WHERE u.id = :id
           
           """)
    public Optional<UsuarioDtoReso>getUsuarioById(@Param(value = "id")Long id);
}
