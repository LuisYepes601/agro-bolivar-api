/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.ENTITIES;

/**
 *
 * @author luis
 */
import com.nexus.demo.Auditoria;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "genero_planta",
        indexes = {
            @Index(name = "idx_genero_planta_nombre", columnList = "nombre")
        })
public class GeneroPlanta extends Auditoria{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = true, length = 200)
    private String descripcion;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "generoPlanta")
    private List<Planta> plantas;

    // Constructor
    public GeneroPlanta() {
    }

    public GeneroPlanta(Long id, String nombre, String descripcion, List<Planta> plantas) {
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
