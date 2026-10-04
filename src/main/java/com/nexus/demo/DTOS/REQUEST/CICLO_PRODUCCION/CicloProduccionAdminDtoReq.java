
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.REQUEST.CICLO_PRODUCCION;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 *
 * @author luis
 */
public class CicloProduccionAdminDtoReq {

 
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    @Schema(
        description = "Nombre del ciclo de producción",
        example = "MENSUAL"
    )
    private String nombre;

    @NotNull(message = "Los días mínimos son obligatorios")
    @Min(value = 1, message = "Los días mínimos deben ser mayores a 0")
    @Max(value = 3650, message = "Los días mínimos no pueden superar los 3650 días")
    @Schema(
        description = "Cantidad mínima de días del ciclo de producción",
        example = "25"
    )
    private Integer diasMinimos;

    @NotNull(message = "Los días máximos son obligatorios")
    @Min(value = 1, message = "Los días máximos deben ser mayores a 0")
    @Max(value = 3650, message = "Los días máximos no pueden superar los 3650 días")
    @Schema(
        description = "Cantidad máxima de días del ciclo de producción",
        example = "35"
    )
    private Integer diasMaximos;

    @Size(max = 255, message = "La descripción no puede superar los 255 caracteres")
    @Schema(
        description = "Descripción del ciclo de producción",
        example = "Ciclo de producción aproximado de un mes"
    )
    private String descripcion;

    public CicloProduccionAdminDtoReq(String nombre, Integer diasMinimos, Integer diasMaximos, String descripcion) {
        this.nombre = nombre;
        this.diasMinimos = diasMinimos;
        this.diasMaximos = diasMaximos;
        this.descripcion = descripcion;
    }

    public CicloProduccionAdminDtoReq() {
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
