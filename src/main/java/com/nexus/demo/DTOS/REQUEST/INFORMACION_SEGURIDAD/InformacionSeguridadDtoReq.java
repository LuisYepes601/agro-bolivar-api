/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.REQUEST.INFORMACION_SEGURIDAD;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 *
 * @author luis
 */
public class InformacionSeguridadDtoReq {

    @NotNull(message = "Debe indicar si el producto es tóxico")
    @Schema(description = "Indica si el producto es tóxico", example = "false")
    private Boolean esToxico;

    @Size(max = 500, message = "La descripción no puede superar los 500 caracteres")
    @Schema(description = "Descripción de la información de seguridad", example = "Producto de uso agrícola que requiere precauciones durante su manipulación")
    private String descripcion;

    @NotNull(message = "Debe indicar si el producto es corrosivo")
    @Schema(description = "Indica si el producto es corrosivo", example = "false")
    private Boolean esCorrosivo;

    @NotNull(message = "Debe indicar si el producto es inflamable")
    @Schema(description = "Indica si el producto es inflamable", example = "true")
    private Boolean esInflamable;

    @NotNull(message = "Debe indicar si el producto es peligroso")
    @Schema(description = "Indica si el producto está clasificado como peligroso", example = "true")
    private Boolean esPeligroso;

    @NotNull(message = "Debe indicar si requiere equipo de protección")
    @Schema(description = "Indica si el producto requiere equipo de protección personal", example = "true")
    private Boolean requiereEquipoProteccion;

    @NotNull(message = "Debe indicar si requiere manejo especial")
    @Schema(description = "Indica si el producto requiere un manejo especial", example = "true")
    private Boolean requiereManejoEspecial;

    @Size(max = 1000, message = "Las precauciones no pueden superar los 1000 caracteres")
    @Schema(description = "Precauciones para el uso del producto", example = "Utilizar guantes y evitar el contacto directo con la piel")
    private String precauciones;

    @Size(max = 1000, message = "Las advertencias no pueden superar los 1000 caracteres")
    @Schema(description = "Advertencias relacionadas con el producto", example = "Mantener fuera del alcance de los niños")
    private String advertencias;

    @Size(max = 1000, message = "Las instrucciones de manejo no pueden superar los 1000 caracteres")
    @Schema(description = "Instrucciones para el manejo del producto", example = "Manipular utilizando los elementos de protección recomendados")
    private String instruccionesManejo;

    @Size(max = 1000, message = "Las instrucciones de almacenamiento no pueden superar los 1000 caracteres")
    @Schema(description = "Instrucciones para almacenar el producto", example = "Almacenar en un lugar fresco, seco y ventilado")
    private String instruccionesAlmacenamiento;

    public InformacionSeguridadDtoReq(Boolean esToxico, String descripcion, Boolean esCorrosivo, Boolean esInflamable, Boolean esPeligroso, Boolean requiereEquipoProteccion, Boolean requiereManejoEspecial, String precauciones, String advertencias, String instruccionesManejo, String instruccionesAlmacenamiento) {
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

    public InformacionSeguridadDtoReq() {
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
