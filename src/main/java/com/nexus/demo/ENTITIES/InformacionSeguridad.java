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
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "informacion_seguridad")
public class InformacionSeguridad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "es_toxico", nullable = false)
    private Boolean esToxico;

    @Column(name = "descripcion", nullable = true)
    private String descripcion;

    @Column(name = "es_corrosivo", nullable = false)
    private Boolean esCorrosivo;

    @Column(name = "es_inflamable", nullable = false)
    private Boolean esInflamable;

    @Column(name = "es_peligroso", nullable = false)
    private Boolean esPeligroso;

    @Column(name = "requiere_equipo_proteccion", nullable = false)
    private Boolean requiereEquipoProteccion;

    @Column(name = "requiere_manejo_especial", nullable = false)
    private Boolean requiereManejoEspecial;

    @Column(name = "precauciones", nullable = true)
    private String precauciones;

    @Column(name = "advertencias", nullable = true)
    private String advertencias;

    @Column(name = "instrucciones_manejo", nullable = true)
    private String instruccionesManejo;

    @Column(name = "instrucciones_almacenamiento", nullable = true)
    private String instruccionesAlmacenamiento;

    public InformacionSeguridad() {
    }

}
