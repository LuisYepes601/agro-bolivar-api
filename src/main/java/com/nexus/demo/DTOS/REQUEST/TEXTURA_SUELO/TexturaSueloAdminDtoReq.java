/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.REQUEST.TEXTURA_SUELO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 *
 * @author luis
 */
public class TexturaSueloAdminDtoReq {

    @Schema(description = "Nombre del tipo de suelo", example = "Arcilloso")
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Pattern(
            regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü0-9 ]+$",
            message = "El nombre solo puede contener letras, números y espacios"
    )
    private String nombre;

    @Schema(description = "Descripción del tipo de suelo", example = "Suelo con alta capacidad de retención de agua")
    @Size(max = 300, message = "La descripción no puede superar los 300 caracteres")
    private String descripcion;

    @Schema(description = "Forma o característica física del suelo", example = "Granular")
    @NotBlank(message = "La forma es obligatoria")
    @Size(min = 3, max = 100, message = "La forma debe tener entre 3 y 100 caracteres")
    @Pattern(
            regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü ]+$",
            message = "La forma solo puede contener letras y espacios"
    )
    private String forma;

    public TexturaSueloAdminDtoReq(String nombre, String descripcion, String forma) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.forma = forma;
    }

    public TexturaSueloAdminDtoReq() {
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

}
