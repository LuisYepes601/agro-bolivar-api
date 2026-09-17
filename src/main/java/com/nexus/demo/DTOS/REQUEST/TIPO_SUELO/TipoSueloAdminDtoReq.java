/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.REQUEST.TIPO_SUELO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.util.List;

/**
 *
 * @author luis
 */
public class TipoSueloAdminDtoReq {

    @Schema(example = "nombre",
            requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    @Pattern(regexp = "^[\\p{L}\\p{N}][\\p{L}\\p{N} .,'-]*$", message = "El nombre solo puede contener letras, números, espacios y los caracteres . , ' -")
    private String nombre;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @Size(max = 200, message = "La descripción no puede superar los 200 caracteres")
    @Pattern(regexp = "^[\\p{L}\\p{N}][\\p{L}\\p{N} .,';:()¿?!¡\"\\-]*$", message = "La descripción contiene caracteres no permitidos")
    private String descripcion;

    @DecimalMin(value = "0.0", message = "El pH mínimo no puede ser menor que 0")
    @DecimalMax(value = "14.0", message = "El pH mínimo no puede ser mayor que 14")
    private Double phMinimo;

    @DecimalMin(value = "0.0", message = "El pH máximo no puede ser menor que 0")
    @DecimalMax(value = "14.0", message = "El pH máximo no puede ser mayor que 14")
    private Double phMaximo;

    @Size(max = 50, message = "El color no puede superar los 50 caracteres")
    @Pattern(regexp = "^[\\p{L}\\p{N}][\\p{L}\\p{N} .,'-]*$", message = "El color solo puede contener letras, números, espacios y los caracteres . , ' -")
    private String color;

    private List<TexturaSueloBasicDtoReq> texturas;

    public TipoSueloAdminDtoReq(String nombre, String descripcion, Double phMinimo, Double phMaximo, String color, List<TexturaSueloBasicDtoReq> texturas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.phMinimo = phMinimo;
        this.phMaximo = phMaximo;
        this.color = color;
        this.texturas = texturas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getPhMinimo() {
        return phMinimo;
    }

    public Double getPhMaximo() {
        return phMaximo;
    }

    public String getColor() {
        return color;
    }

    public TipoSueloAdminDtoReq() {
    }

    public List<TexturaSueloBasicDtoReq> getTexturas() {
        return texturas;
    }

    public void setTexturas(List<TexturaSueloBasicDtoReq> texturas) {
        this.texturas = texturas;
    }

}
