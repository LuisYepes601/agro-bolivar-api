/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.ENTITIES;

/**
 *
 * @author luis
 */
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "familia_botanica",
        indexes = {
            @Index(name = "idx_familia_botanica_nombre", columnList = "nombre")
        })
public class FamiliaBotanica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = true, length = 300)
    private String descripcion;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "familiaBotanica")
    private List<Planta> plantas;

    // Constructor
    public FamiliaBotanica() {
    }

    public FamiliaBotanica(Long id, String nombre, String descripcion, List<Planta> plantas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.plantas = plantas;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Planta> getPlantas() {
        return plantas;
    }

    public void setPlantas(List<Planta> plantas) {
        this.plantas = plantas;
    }

}
