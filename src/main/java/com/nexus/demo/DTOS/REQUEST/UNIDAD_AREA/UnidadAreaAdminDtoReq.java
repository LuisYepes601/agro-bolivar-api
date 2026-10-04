/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.REQUEST.UNIDAD_AREA;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 *
 * @author luis
 */
public class UnidadAreaAdminDtoReq {
     
    @Schema(
        description = "Nombre de la unidad de área",
        example = "Hectárea",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    @Pattern(
        regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü0-9]+(?:[ A-Za-zÁÉÍÓÚáéíóúÑñÜü0-9]*)$",
        message = "El nombre solo puede contener letras, números y espacios"
    )
    private String nombre;

    @Schema(
        description = "Descripción de la unidad de área",
        example = "Unidad utilizada para medir superficies de terreno",
        nullable = true
    )
    @Size(max = 255, message = "La descripción no puede superar los 255 caracteres")
    @Pattern(
        regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü0-9.,;:()°%\\-+*/ ]*$",
        message = "La descripción contiene caracteres no permitidos"
    )
    private String descripcion;

    public UnidadAreaAdminDtoReq(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public UnidadAreaAdminDtoReq() {
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

    
}
