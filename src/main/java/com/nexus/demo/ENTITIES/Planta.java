/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.ENTITIES;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author luis
 */
@Table(name = "planta")
@Entity()
public class Planta {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_familia_botanica")
    private FamiliaBotanica familiaBotanica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_genero_planta")
    private GeneroPlanta generoPlanta;

}
