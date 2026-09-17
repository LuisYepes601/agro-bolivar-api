/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.ENTITIES;

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

/**
 *
 * @author luis
 */
@Entity
@Table(name = "textura_suelo",
        indexes = {
            @Index(name = "idx_textura_suelo_nombre", columnList = "nombre")
        })
public class TexturaSuelo extends Auditoria{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = true, length = 200)
    private String descripcion;

    @Column(nullable = true, length = 100)
    private String forma;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "texturaSuelo")
    private List<TexturaTipoSuelo> texturaTipoSuelos;

    // Constructor
    public TexturaSuelo() {
    }

    public TexturaSuelo(Long id, String nombre, String descripcion, String forma, List<TexturaTipoSuelo> texturaTipoSuelos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.forma = forma;
        this.texturaTipoSuelos = texturaTipoSuelos;
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

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public List<TexturaTipoSuelo> getTexturaTipoSuelos() {
        return texturaTipoSuelos;
    }

    public void setTexturaTipoSuelos(List<TexturaTipoSuelo> texturaTipoSuelos) {
        this.texturaTipoSuelos = texturaTipoSuelos;
    }

}
