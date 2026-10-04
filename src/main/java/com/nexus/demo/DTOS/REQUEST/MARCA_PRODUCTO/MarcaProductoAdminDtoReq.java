/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.REQUEST.MARCA_PRODUCTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 *
 * @author luis
 */
public class MarcaProductoAdminDtoReq {

    @NotBlank(message = "El nombre de la marca es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    @Pattern(
            regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ0-9]+(?:[ .'-][a-zA-ZáéíóúÁÉÍÓÚñÑ0-9]+)*$",
            message = "El nombre solo puede contener letras, números, espacios, puntos, apóstrofes y guiones"
    )
    @Schema(
            description = "Nombre de la marca del producto",
            example = "Diana",
            minLength = 2,
            maxLength = 100
    )
    private String nombre;

    @Size(max = 500, message = "La descripción no puede superar los 500 caracteres")
    @Schema(
            description = "Descripción de la marca del producto",
            example = "Marca colombiana de productos alimenticios",
            maxLength = 500
    )
    private String descripcion;

    public MarcaProductoAdminDtoReq(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public MarcaProductoAdminDtoReq() {
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
