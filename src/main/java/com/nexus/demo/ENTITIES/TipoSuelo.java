/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.ENTITIES;

/**
 *
 * @author luis
 */
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
@Table(name = "tipo_suelo",
        indexes = {
            @Index(name = "idx_tipo_suelo_nombre", columnList = "nombre")

        })
public class TipoSuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = true, length = 200)
    private String descripcion;

    @Column(nullable = true)
    private Double phMinimo;

    @Column(nullable = true)
    private Double phMaximo;

    @Column(nullable = true)
    private String color;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoSuelo")
    private List<TexturaTipoSuelo> texturaTipoSuelos;

    public TipoSuelo(Long id, String nombre, String descripcion, Double phMinimo, Double phMaximo, String color, List<TexturaTipoSuelo> texturaTipoSuelos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.phMinimo = phMinimo;
        this.phMaximo = phMaximo;
        this.color = color;
        this.texturaTipoSuelos = texturaTipoSuelos;
    }

    // Constructor
    public TipoSuelo() {
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

    public Double getPhMinimo() {
        return phMinimo;
    }

    public void setPhMinimo(Double phMinimo) {
        this.phMinimo = phMinimo;
    }

    public Double getPhMaximo() {
        return phMaximo;
    }

    public void setPhMaximo(Double phMaximo) {
        this.phMaximo = phMaximo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<TexturaTipoSuelo> getTexturaTipoSuelos() {
        return texturaTipoSuelos;
    }

    public void setTexturaTipoSuelos(List<TexturaTipoSuelo> texturaTipoSuelos) {
        this.texturaTipoSuelos = texturaTipoSuelos;
    }
}
