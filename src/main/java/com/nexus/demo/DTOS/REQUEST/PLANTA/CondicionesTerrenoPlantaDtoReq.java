
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.REQUEST.PLANTA;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;

/**
 *
 * @author luis
 */
public class CondicionesTerrenoPlantaDtoReq {

    @DecimalMin(value = "0.0", message = "La precipitación mínima no puede ser negativa")
    @Digits(integer = 4, fraction = 2, message = "La precipitación mínima debe tener máximo 4 enteros y 2 decimales")
    @Schema(
            description = "Precipitación mínima requerida por la planta",
            example = "500.00"
    )
    private Double precipitacionMinima;

    @DecimalMin(value = "0.0", message = "La precipitación máxima no puede ser negativa")
    @Digits(integer = 4, fraction = 2, message = "La precipitación máxima debe tener máximo 4 enteros y 2 decimales")
    @Schema(
            description = "Precipitación máxima tolerada por la planta",
            example = "1500.00"
    )
    private Double precipitacionMaxima;

    @DecimalMin(value = "0.0", message = "La precipitación ideal no puede ser negativa")
    @Digits(integer = 4, fraction = 2, message = "La precipitación ideal debe tener máximo 4 enteros y 2 decimales")
    @Schema(
            description = "Precipitación ideal para la planta",
            example = "1000.00"
    )
    private Double precipitacionIdeal;

    @DecimalMin(value = "0.0", message = "La altitud mínima no puede ser negativa")
    @Digits(integer = 4, fraction = 2, message = "La altitud mínima debe tener máximo 4 enteros y 2 decimales")
    @Schema(
            description = "Altitud mínima adecuada para el cultivo en metros sobre el nivel del mar",
            example = "0.00"
    )
    private Double altitudMinima;

    @DecimalMin(value = "0.0", message = "La altitud máxima no puede ser negativa")
    @Digits(integer = 4, fraction = 2, message = "La altitud máxima debe tener máximo 4 enteros y 2 decimales")
    @Schema(
            description = "Altitud máxima adecuada para el cultivo en metros sobre el nivel del mar",
            example = "1500.00"
    )
    private Double altitudMaxima;

    @DecimalMin(value = "0.0", message = "El pH mínimo no puede ser negativo")
    @DecimalMax(value = "14.0", message = "El pH mínimo no puede ser superior a 14")
    @Digits(integer = 2, fraction = 1, message = "El pH mínimo debe tener máximo 2 enteros y 1 decimal")
    @Schema(
            description = "Valor mínimo de pH del suelo adecuado para la planta",
            example = "5.5"
    )
    private Double phSueloMinimo;

    @DecimalMin(value = "0.0", message = "El pH máximo no puede ser negativo")
    @DecimalMax(value = "14.0", message = "El pH máximo no puede ser superior a 14")
    @Digits(integer = 2, fraction = 1, message = "El pH máximo debe tener máximo 2 enteros y 1 decimal")
    @Schema(
            description = "Valor máximo de pH del suelo adecuado para la planta",
            example = "7.5"
    )
    private Double phSueloMaximo;

    @DecimalMin(value = "0.0", message = "El pH ideal no puede ser negativo")
    @DecimalMax(value = "14.0", message = "El pH ideal no puede ser superior a 14")
    @Digits(integer = 2, fraction = 1, message = "El pH ideal debe tener máximo 2 enteros y 1 decimal")
    @Schema(
            description = "Valor ideal de pH del suelo para la planta",
            example = "6.5"
    )
    private Double phSueloIdeal;

    public CondicionesTerrenoPlantaDtoReq(Double precipitacionMinima, Double precipitacionMaxima, Double precipitacionIdeal, Double altitudMinima, Double altitudMaxima, Double phSueloMinimo, Double phSueloMaximo, Double phSueloIdeal) {
        this.precipitacionMinima = precipitacionMinima;
        this.precipitacionMaxima = precipitacionMaxima;
        this.precipitacionIdeal = precipitacionIdeal;
        this.altitudMinima = altitudMinima;
        this.altitudMaxima = altitudMaxima;
        this.phSueloMinimo = phSueloMinimo;
        this.phSueloMaximo = phSueloMaximo;
        this.phSueloIdeal = phSueloIdeal;
    }

    public CondicionesTerrenoPlantaDtoReq() {
    }

    public Double getPrecipitacionMinima() {
        return precipitacionMinima;
    }

    public void setPrecipitacionMinima(Double precipitacionMinima) {
        this.precipitacionMinima = precipitacionMinima;
    }

    public Double getPrecipitacionMaxima() {
        return precipitacionMaxima;
    }

    public void setPrecipitacionMaxima(Double precipitacionMaxima) {
        this.precipitacionMaxima = precipitacionMaxima;
    }

    public Double getPrecipitacionIdeal() {
        return precipitacionIdeal;
    }

    public void setPrecipitacionIdeal(Double precipitacionIdeal) {
        this.precipitacionIdeal = precipitacionIdeal;
    }

    public Double getAltitudMinima() {
        return altitudMinima;
    }

    public void setAltitudMinima(Double altitudMinima) {
        this.altitudMinima = altitudMinima;
    }

    public Double getAltitudMaxima() {
        return altitudMaxima;
    }

    public void setAltitudMaxima(Double altitudMaxima) {
        this.altitudMaxima = altitudMaxima;
    }

    public Double getPhSueloMinimo() {
        return phSueloMinimo;
    }

    public void setPhSueloMinimo(Double phSueloMinimo) {
        this.phSueloMinimo = phSueloMinimo;
    }

    public Double getPhSueloMaximo() {
        return phSueloMaximo;
    }

    public void setPhSueloMaximo(Double phSueloMaximo) {
        this.phSueloMaximo = phSueloMaximo;
    }

    public Double getPhSueloIdeal() {
        return phSueloIdeal;
    }

    public void setPhSueloIdeal(Double phSueloIdeal) {
        this.phSueloIdeal = phSueloIdeal;
    }

}
