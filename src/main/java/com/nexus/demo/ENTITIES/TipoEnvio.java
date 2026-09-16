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
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "tipo_envio",
        indexes = {
        
            @Index(name = "idx_tipo_envio_nombre", columnList = "nombre")
        })
public class TipoEnvio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", nullable = true, length = 200)
    private String descripcion;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoEnvio")
    private List<DatosEnvio> datosEnvios;

    public TipoEnvio(Long id, String nombre, String descripcion, List<DatosEnvio> datosEnvios) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.datosEnvios = datosEnvios;
    }

    public TipoEnvio() {
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

    public List<DatosEnvio> getDatosEnvios() {
        return datosEnvios;
    }

    public void setDatosEnvios(List<DatosEnvio> datosEnvios) {
        this.datosEnvios = datosEnvios;
    }

}
