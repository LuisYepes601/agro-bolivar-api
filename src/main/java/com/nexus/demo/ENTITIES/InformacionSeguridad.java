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
import jakarta.persistence.OneToOne;
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

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "informacionSeguridad")
    private Producto prodcuto;

    public InformacionSeguridad(Long id, Boolean esToxico, String descripcion, Boolean esCorrosivo, Boolean esInflamable, Boolean esPeligroso, Boolean requiereEquipoProteccion, Boolean requiereManejoEspecial, String precauciones, String advertencias, String instruccionesManejo, String instruccionesAlmacenamiento, Producto prodcuto) {
        this.id = id;
        this.esToxico = esToxico;
        this.descripcion = descripcion;
        this.esCorrosivo = esCorrosivo;
        this.esInflamable = esInflamable;
        this.esPeligroso = esPeligroso;
        this.requiereEquipoProteccion = requiereEquipoProteccion;
        this.requiereManejoEspecial = requiereManejoEspecial;
        this.precauciones = precauciones;
        this.advertencias = advertencias;
        this.instruccionesManejo = instruccionesManejo;
        this.instruccionesAlmacenamiento = instruccionesAlmacenamiento;
        this.prodcuto = prodcuto;
    }

    public InformacionSeguridad() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getEsToxico() {
        return esToxico;
    }

    public void setEsToxico(Boolean esToxico) {
        this.esToxico = esToxico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEsCorrosivo() {
        return esCorrosivo;
    }

    public void setEsCorrosivo(Boolean esCorrosivo) {
        this.esCorrosivo = esCorrosivo;
    }

    public Boolean getEsInflamable() {
        return esInflamable;
    }

    public void setEsInflamable(Boolean esInflamable) {
        this.esInflamable = esInflamable;
    }

    public Boolean getEsPeligroso() {
        return esPeligroso;
    }

    public void setEsPeligroso(Boolean esPeligroso) {
        this.esPeligroso = esPeligroso;
    }

    public Boolean getRequiereEquipoProteccion() {
        return requiereEquipoProteccion;
    }

    public void setRequiereEquipoProteccion(Boolean requiereEquipoProteccion) {
        this.requiereEquipoProteccion = requiereEquipoProteccion;
    }

    public Boolean getRequiereManejoEspecial() {
        return requiereManejoEspecial;
    }

    public void setRequiereManejoEspecial(Boolean requiereManejoEspecial) {
        this.requiereManejoEspecial = requiereManejoEspecial;
    }

    public String getPrecauciones() {
        return precauciones;
    }

    public void setPrecauciones(String precauciones) {
        this.precauciones = precauciones;
    }

    public String getAdvertencias() {
        return advertencias;
    }

    public void setAdvertencias(String advertencias) {
        this.advertencias = advertencias;
    }

    public String getInstruccionesManejo() {
        return instruccionesManejo;
    }

    public void setInstruccionesManejo(String instruccionesManejo) {
        this.instruccionesManejo = instruccionesManejo;
    }

    public String getInstruccionesAlmacenamiento() {
        return instruccionesAlmacenamiento;
    }

    public void setInstruccionesAlmacenamiento(String instruccionesAlmacenamiento) {
        this.instruccionesAlmacenamiento = instruccionesAlmacenamiento;
    }

    public Producto getProdcuto() {
        return prodcuto;
    }

    public void setProdcuto(Producto prodcuto) {
        this.prodcuto = prodcuto;
    }

}
