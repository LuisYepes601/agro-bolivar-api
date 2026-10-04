/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.RESPONSE.INFORMACION_SEGURIDAD;

/**
 *
 * @author luis
 */
public class InformacionSeguridadDtoResp {

    private Long id;

    private Boolean esToxico;

    private String descripcion;

    private Boolean esCorrosivo;

    private Boolean esInflamable;

    private Boolean esPeligroso;

    private Boolean requiereEquipoProteccion;

    private Boolean requiereManejoEspecial;

    private String precauciones;

    private String advertencias;

    private String instruccionesManejo;

    private String instruccionesAlmacenamiento;

    public InformacionSeguridadDtoResp(Long id, Boolean esToxico, String descripcion, Boolean esCorrosivo, Boolean esInflamable, Boolean esPeligroso, Boolean requiereEquipoProteccion, Boolean requiereManejoEspecial, String precauciones, String advertencias, String instruccionesManejo, String instruccionesAlmacenamiento) {
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
    }

    public InformacionSeguridadDtoResp() {
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

}
