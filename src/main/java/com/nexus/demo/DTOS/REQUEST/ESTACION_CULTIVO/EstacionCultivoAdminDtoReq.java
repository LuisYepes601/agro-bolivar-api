/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.REQUEST.ESTACION_CULTIVO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

/**
 *
 * @author luis
 */
public class EstacionCultivoAdminDtoReq {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Pattern(
            regexp = "^[\\p{L}\\p{M}0-9]+(?:[ .,'()\\-/][\\p{L}\\p{M}0-9]+)*$",
            message = "El nombre solo puede contener letras, números, espacios y caracteres . , ' ( ) - /"
    )
    @Schema(
            description = "Nombre del tipo de planta",
            example = "Hortaliza",
            minLength = 3,
            maxLength = 100,
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String nombre;

    @Size(max = 300, message = "La descripción no puede superar los 300 caracteres")
    @Pattern(
            regexp = "^[\\p{L}\\p{M}0-9]+(?:[ .,'()\\-/][\\p{L}\\p{M}0-9]+)*$",
            message = "La descripción contiene caracteres no permitidos"
    )
    @Schema(
            description = "Descripción del tipo de planta",
            example = "Plantas cultivadas principalmente para consumo humano",
            maxLength = 300,
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    private String descripcion;

    @Schema(
            description = "Fecha de inicio de vigencia del tipo de planta",
            example = "2026-01-01",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    private LocalDate fechaInicio;

    @Schema(
            description = "Fecha de finalización de vigencia del tipo de planta",
            example = "2026-12-31",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    private LocalDate fechaFin;

    public EstacionCultivoAdminDtoReq(String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public EstacionCultivoAdminDtoReq() {
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

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    
}
