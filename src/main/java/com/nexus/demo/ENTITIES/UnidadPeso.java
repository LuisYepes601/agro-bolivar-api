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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "unidad_peso")
public class UnidadPeso extends Auditoria{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = true)
    private String descripcion;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "unidadPeso")
    private List<Cultivo> cultivos;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "unidadPeso")
    private List<DatosEnvio> datosEnvios;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "unidadPeso")
    private List<Producto> productos;

    public UnidadPeso(Long id, String nombre, String descripcion, List<Cultivo> cultivos, List<DatosEnvio> datosEnvios, List<Producto> productos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cultivos = cultivos;
        this.datosEnvios = datosEnvios;
        this.productos = productos;
    }

    public UnidadPeso() {
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

    public List<Cultivo> getCultivos() {
        return cultivos;
    }

    public void setCultivos(List<Cultivo> cultivos) {
        this.cultivos = cultivos;
    }

    public List<DatosEnvio> getDatosEnvios() {
        return datosEnvios;
    }

    public void setDatosEnvios(List<DatosEnvio> datosEnvios) {
        this.datosEnvios = datosEnvios;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
