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
@Table(name = "etapa")
public class Etapa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = true, length = 200)
    private String descripcion;

    @Column(nullable = true)
    private Integer diaInicio;

    @Column(nullable = true)
    private Integer diaFin;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "etapa")
    private List<Planta> plantas;

    public Etapa() {
    }

    public Etapa(Long id, String nombre, String descripcion, Integer diaInicio, Integer diaFin, List<Planta> plantas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.diaInicio = diaInicio;
        this.diaFin = diaFin;
        this.plantas = plantas;
    }

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

    public Integer getDiaInicio() {
        return diaInicio;
    }

    public void setDiaInicio(Integer diaInicio) {
        this.diaInicio = diaInicio;
    }

    public Integer getDiaFin() {
        return diaFin;
    }

    public void setDiaFin(Integer diaFin) {
        this.diaFin = diaFin;
    }

    public List<Planta> getPlantas() {
        return plantas;
    }

    public void setPlantas(List<Planta> plantas) {
        this.plantas = plantas;
    }
    
    
}
