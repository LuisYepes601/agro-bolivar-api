/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.REPOSITORY;

import com.nexus.demo.ENTITIES.Inventario;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author luis
 */
public interface InventarioRepository extends JpaRepository<Inventario, Long> {

    @Query("""
           SELECT inv
           
           FROM Inventario inv
           
           LEFT JOIN inv.usuario us
           
           WHERE (us.id =:id_user)
           AND (inv.isDelete = false)
           
           """)
    public Optional<Inventario> getByIdUserAndActive(@Param(value = "id_user") Long id_user);

}
