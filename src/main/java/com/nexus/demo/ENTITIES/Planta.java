/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.ENTITIES;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author luis
 */
@Table(name = "planta")
@Entity()
public class Planta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_familia_botanica")
    private FamiliaBotanica familiaBotanica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_genero_planta")
    private GeneroPlanta generoPlanta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_especie")
    private Especie especie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_etapa")
    private Etapa etapa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_produccion")
    private CicloProduccion cicloProduccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_germinacion")
    private CicloGerminacion cicloGerminacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estacion_cultivo")
    private EstacionCultivo estacionCultivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_planta")
    private TipoPlanta tipoPlanta;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "planta")
    private List<Cultivo> cultivos;

}
