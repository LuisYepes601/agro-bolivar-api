/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.REQUEST.CATEGORIA_PRODUCTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 *
 * @author luis
 */
public class CategoriaAdminProdDtoReq {

    @NotBlank(message = "El nombre de la categoría es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    @Pattern(
            regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü0-9]+(?:[ .'-][A-Za-zÁÉÍÓÚáéíóúÑñÜü0-9]+)*$",
            message = "El nombre solo puede contener letras, números, espacios, puntos, apóstrofes y guiones"
    )
    @Schema(
            description = "Nombre de la categoría del producto",
            example = "Granos y Cereales",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String nombre;

    @Size(max = 500, message = "La descripción no puede superar los 500 caracteres")
    @Pattern(
            regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü0-9 .,;:()'\"¿?!¡+\\-/]*$",
            message = "La descripción contiene caracteres no permitidos"
    )
    @Schema(
            description = "Descripción de la categoría del producto",
            example = "Categoría para productos como arroz, maíz, avena y otros cereales",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    private String descripcion;

    public CategoriaAdminProdDtoReq(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public CategoriaAdminProdDtoReq() {
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
