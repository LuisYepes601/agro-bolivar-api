/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.REQUEST.ESPECIE_PLANTA;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 *
 * @author luis
 */
public class EspeciePlantaAdminDtoReq {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 150, message = "El nombre no puede superar los 150 caracteres")
    @Pattern(regexp = "^[\\p{L}\\p{N}][\\p{L}\\p{N} .,'-]*$", message = "El nombre solo puede contener letras, números, espacios y los caracteres . , ' -")
    
    private String nombre;
    @Size(max = 300, message = "La descripción no puede superar los 300 caracteres")
    @Pattern(regexp = "^[\\p{L}\\p{N}][\\p{L}\\p{N} .,';:()¿?!¡\"\\-]*$", message = "La descripción contiene caracteres no permitidos")
    private String descripcion;

    public EspeciePlantaAdminDtoReq(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public EspeciePlantaAdminDtoReq() {
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
