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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "estacion_cultivo")
public class EstacionCultivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = true, length = 300)
    private String descripcion;

    @Column(name = "fecha_inicio", nullable = true)
    private String fechaInicio;

    @Column(name = "fecha_fin", nullable = true)
    private String fechaFin;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estacionCultivo")
    private List<Planta> plantas;

    public EstacionCultivo() {
    }

}
