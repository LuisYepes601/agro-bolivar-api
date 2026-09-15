/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.ENTITIES;

/**
 *
 * @author luis
 */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cultivo")
public class Cultivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "id_planta", nullable = false)
    private Long idPlanta;

    @Column(name = "fecha_inicio", nullable = false)
    private String fechaInicio;

    @Column(name = "fecha_estimada_fin", nullable = true)
    private String fechaEstimadaFin;

    @Column(name = "cantidad_sembrada", nullable = false)
    private Double cantidadSembrada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unidad_peso")
    private UnidadPeso unidadPeso;

    @Column(name = "area_sembrada", nullable = true)
    private Double areaSembrada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unidad_area")
    private UnidadArea unidadArea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_cultivo")
    private EstadoCultivo estadoCultivo;

    @Column(name = "cantidad_disponible", nullable = true)
    private Double cantidadDisponible;

    @Column(name = "precio_por_kg", nullable = true)
    private Double precioPorKg;

    @Column(name = "cantidad_disponible_para_venta", nullable = true)
    private Double cantidadDisponibleParaVenta;

    public Cultivo() {
    }
}
