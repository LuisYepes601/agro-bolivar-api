/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.REQUEST.CICLO_GERMINACION;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 *
 * @author luis
 */
public class CicloGerminacionAdminDtoReq {

    
    @Schema(
        description = "Nombre del ciclo de germinación",
        example = "Germinación temprana",
        minLength = 3,
        maxLength = 100
    )
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Pattern(
        regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü0-9]+(?:[ .'-][A-Za-zÁÉÍÓÚáéíóúÑñÜü0-9]+)*$",
        message = "El nombre solo puede contener letras, números, espacios, puntos, guiones y apóstrofes"
    )
    private String nombre;

    @Schema(
        description = "Cantidad mínima de días necesarios para la germinación",
        example = "5",
        minimum = "1"
    )
    @NotNull(message = "Los días mínimos son obligatorios")
    @Min(value = 1, message = "Los días mínimos deben ser mayores o iguales a 1")
    private Integer diasMinimos;

    @Schema(
        description = "Cantidad máxima de días necesarios para la germinación",
        example = "10",
        minimum = "1"
    )
    @NotNull(message = "Los días máximos son obligatorios")
    @Min(value = 1, message = "Los días máximos deben ser mayores o iguales a 1")
    private Integer diasMaximos;

    @Schema(
        description = "Descripción del ciclo de germinación",
        example = "Periodo inicial en el que la semilla comienza a germinar",
        minLength = 10,
        maxLength = 500
    )
    @NotBlank(message = "La descripción es obligatoria")
    @Size(min = 10, max = 500, message = "La descripción debe tener entre 10 y 500 caracteres")
    @Pattern(
        regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü0-9]+(?:[ .,:;()'\"¿?¡!\\-][A-Za-zÁÉÍÓÚáéíóúÑñÜü0-9]+)*$",
        message = "La descripción contiene caracteres no permitidos"
    )
    private String descripcion;

    public CicloGerminacionAdminDtoReq(String nombre, Integer diasMinimos, Integer diasMaximos, String descripcion) {
        this.nombre = nombre;
        this.diasMinimos = diasMinimos;
        this.diasMaximos = diasMaximos;
        this.descripcion = descripcion;
    }

    public CicloGerminacionAdminDtoReq() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDiasMinimos() {
        return diasMinimos;
    }

    public void setDiasMinimos(Integer diasMinimos) {
        this.diasMinimos = diasMinimos;
    }

    public Integer getDiasMaximos() {
        return diasMaximos;
    }

    public void setDiasMaximos(Integer diasMaximos) {
        this.diasMaximos = diasMaximos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    

}
