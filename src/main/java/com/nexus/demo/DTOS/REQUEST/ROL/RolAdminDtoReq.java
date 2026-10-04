/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.REQUEST.ROL;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 *
 * @author luis
 */
public class RolAdminDtoReq {

    @Schema(
            description = "Nombre del rol",
            example = "Administrador",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "El nombre del rol es obligatorio")
    @Size(
            min = 2,
            max = 50,
            message = "El nombre del rol debe tener entre 2 y 50 caracteres"
    )
    @Pattern(
            regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+$",
            message = "El nombre del rol solo puede contener letras y espacios"
    )
    private String nombre;

    @Schema(
            description = "Descripción de las funciones o permisos asociados al rol",
            example = "Rol encargado de administrar los usuarios y la información del sistema",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Size(
            max = 255,
            message = "La descripción no puede superar los 255 caracteres"
    )
    private String descripcion;

    public RolAdminDtoReq(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public RolAdminDtoReq() {
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
