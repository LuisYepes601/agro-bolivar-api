/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.REQUEST.ESTADO_CULTIVO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 *
 * @author luis
 */
public class EstadoCultivoAdminDtoReq {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Pattern(
            regexp = "^[a-zA-ZÁÉÍÓÚáéíóúÑñÜü0-9]+(?:[ .'-][a-zA-ZÁÉÍÓÚáéíóúÑñÜü0-9]+)*$",
            message = "El nombre solo puede contener letras, números, espacios, puntos, guiones y apóstrofes"
    )
    @Schema(
            description = "Nombre del registro",
            example = "MENSUAL"
    )
    private String nombre;

    @Size(max = 500, message = "La descripción no puede superar los 500 caracteres")
    @Pattern(
            regexp = "^[a-zA-ZÁÉÍÓÚáéíóúÑñÜü0-9]+(?:[ .,';:()\\-_/][a-zA-ZÁÉÍÓÚáéíóúÑñÜü0-9]+)*$",
            message = "La descripción contiene caracteres no permitidos"
    )
    @Schema(
            description = "Descripción del registro",
            example = "Ciclo de producción aproximado de un mes"
    )
    private String descripcion;

    public EstadoCultivoAdminDtoReq(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public EstadoCultivoAdminDtoReq() {
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
