/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.REQUEST.PLANTA;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 *
 * @author luis
 */
public class PlantaBasicDtoReq {

    @NotBlank(message = "El nombre de la planta es obligatorio")
    @Size(max = 100, message = "El nombre de la planta no puede superar los 100 caracteres")
    @Schema(
            description = "Nombre común de la planta",
            example = "Tomate",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String nombre;
    @Size(max = 150, message = "El nombre científico no puede superar los 150 caracteres")
    @Schema(
            description = "Nombre científico de la planta",
            example = "Solanum lycopersicum"
    )
    private String nombreCientifico;
    
        @Size(max = 500, message = "La descripción no puede superar los 500 caracteres")
    @Schema(
            description = "Descripción general de la planta",
            example = "Planta herbácea cultivada por su fruto comestible"
    )
    private String descripcion;

    public PlantaBasicDtoReq(String nombre, String nombreCientifico, String descripcion) {
        this.nombre = nombre;
        this.nombreCientifico = nombreCientifico;
        this.descripcion = descripcion;
    }

    public PlantaBasicDtoReq() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
        
        
}
