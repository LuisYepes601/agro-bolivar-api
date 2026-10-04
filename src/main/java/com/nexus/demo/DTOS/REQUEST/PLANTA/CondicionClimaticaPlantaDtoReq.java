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
public class CondicionClimaticaPlantaDtoReq {

    @DecimalMin(value = "-50.0", message = "La temperatura mínima no puede ser menor a -50 °C")
    @DecimalMax(value = "60.0", message = "La temperatura mínima no puede superar los 60 °C")
    @Digits(integer = 3, fraction = 2, message = "La temperatura mínima debe tener máximo 3 enteros y 2 decimales")
    @Schema(
            description = "Temperatura mínima soportada por la planta en grados Celsius",
            example = "10.00"
    )
    private Double temperaturaMinima;

    @DecimalMin(value = "-50.0", message = "La temperatura máxima no puede ser menor a -50 °C")
    @DecimalMax(value = "60.0", message = "La temperatura máxima no puede superar los 60 °C")
    @Digits(integer = 3, fraction = 2, message = "La temperatura máxima debe tener máximo 3 enteros y 2 decimales")
    @Schema(
            description = "Temperatura máxima soportada por la planta en grados Celsius",
            example = "35.00"
    )
    private Double temperaturaMaxima;

    @DecimalMin(value = "-50.0", message = "La temperatura ideal no puede ser menor a -50 °C")
    @DecimalMax(value = "60.0", message = "La temperatura ideal no puede superar los 60 °C")
    @Digits(integer = 3, fraction = 2, message = "La temperatura ideal debe tener máximo 3 enteros y 2 decimales")
    @Schema(
            description = "Temperatura ideal para el crecimiento de la planta",
            example = "25.00"
    )
    private Double temperaturaIdeal;

    @DecimalMin(value = "0.0", message = "La humedad mínima no puede ser negativa")
    @DecimalMax(value = "100.0", message = "La humedad mínima no puede superar el 100%")
    @Digits(integer = 3, fraction = 2, message = "La humedad mínima debe tener máximo 3 enteros y 2 decimales")
    @Schema(
            description = "Humedad relativa mínima requerida por la planta en porcentaje",
            example = "40.00"
    )
    private Double humedadMinima;

    @DecimalMin(value = "0.0", message = "La humedad máxima no puede ser negativa")
    @DecimalMax(value = "100.0", message = "La humedad máxima no puede superar el 100%")
    @Digits(integer = 3, fraction = 2, message = "La humedad máxima debe tener máximo 3 enteros y 2 decimales")
    @Schema(
            description = "Humedad relativa máxima requerida por la planta en porcentaje",
            example = "80.00"
    )
    private Double humedadMaxima;

    @DecimalMin(value = "0.0", message = "La humedad ideal no puede ser negativa")
    @DecimalMax(value = "100.0", message = "La humedad ideal no puede superar el 100%")
    @Digits(integer = 3, fraction = 2, message = "La humedad ideal debe tener máximo 3 enteros y 2 decimales")
    @Schema(
            description = "Humedad relativa ideal para la planta en porcentaje",
            example = "60.00"
    )
    private Double humedadIdeal;

    @Digits(integer = 2, fraction = 2, message = "Las horas solares mínimas deben tener máximo 2 enteros y 2 decimales")
    @Schema(
            description = "Cantidad mínima de horas de exposición solar diaria",
            example = "4.00"
    )
    private Double horasSolaresMinimas;

    @DecimalMin(value = "0.0", message = "Las horas solares máximas no pueden ser negativas")
    @Digits(integer = 2, fraction = 2, message = "Las horas solares máximas deben tener máximo 2 enteros y 2 decimales")
    @Schema(
            description = "Cantidad máxima de horas de exposición solar diaria",
            example = "10.00"
    )
    private Double horasSolaresMaximas;

    @DecimalMin(value = "0.0", message = "Las horas solares ideales no pueden ser negativas")
    @Digits(integer = 2, fraction = 2, message = "Las horas solares ideales deben tener máximo 2 enteros y 2 decimales")
    @Schema(
            description = "Cantidad ideal de horas de exposición solar diaria",
            example = "6.00"
    )
    private Double horasSolaresIdeales;

    public CondicionClimaticaPlantaDtoReq(Double temperaturaMinima, Double temperaturaMaxima, Double temperaturaIdeal, Double humedadMinima, Double humedadMaxima, Double humedadIdeal, Double horasSolaresMinimas, Double horasSolaresMaximas, Double horasSolaresIdeales) {
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
        this.temperaturaIdeal = temperaturaIdeal;
        this.humedadMinima = humedadMinima;
        this.humedadMaxima = humedadMaxima;
        this.humedadIdeal = humedadIdeal;
        this.horasSolaresMinimas = horasSolaresMinimas;
        this.horasSolaresMaximas = horasSolaresMaximas;
        this.horasSolaresIdeales = horasSolaresIdeales;
    }

    public CondicionClimaticaPlantaDtoReq() {
    }

    public Double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(Double temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public Double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(Double temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public Double getTemperaturaIdeal() {
        return temperaturaIdeal;
    }

    public void setTemperaturaIdeal(Double temperaturaIdeal) {
        this.temperaturaIdeal = temperaturaIdeal;
    }

    public Double getHumedadMinima() {
        return humedadMinima;
    }

    public void setHumedadMinima(Double humedadMinima) {
        this.humedadMinima = humedadMinima;
    }

    public Double getHumedadMaxima() {
        return humedadMaxima;
    }

    public void setHumedadMaxima(Double humedadMaxima) {
        this.humedadMaxima = humedadMaxima;
    }

    public Double getHumedadIdeal() {
        return humedadIdeal;
    }

    public void setHumedadIdeal(Double humedadIdeal) {
        this.humedadIdeal = humedadIdeal;
    }

    public Double getHorasSolaresMinimas() {
        return horasSolaresMinimas;
    }

    public void setHorasSolaresMinimas(Double horasSolaresMinimas) {
        this.horasSolaresMinimas = horasSolaresMinimas;
    }

    public Double getHorasSolaresMaximas() {
        return horasSolaresMaximas;
    }

    public void setHorasSolaresMaximas(Double horasSolaresMaximas) {
        this.horasSolaresMaximas = horasSolaresMaximas;
    }

    public Double getHorasSolaresIdeales() {
        return horasSolaresIdeales;
    }

    public void setHorasSolaresIdeales(Double horasSolaresIdeales) {
        this.horasSolaresIdeales = horasSolaresIdeales;
    }

    
}
