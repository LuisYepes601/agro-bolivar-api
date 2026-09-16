/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.REQUEST.PLANTA;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/**
 *
 * @author luis
 */
public class PlantaDtoReq {

    @NotNull(message = "El ID de la familia botánica es obligatorio")
    @Positive(message = "El ID de la familia botánica debe ser mayor que cero")
    @Schema(
            description = "ID de la familia botánica a la que pertenece la planta",
            example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long idFamiliaBotanica;

    @NotNull(message = "El ID del género de la planta es obligatorio")
    @Positive(message = "El ID del género de la planta debe ser mayor que cero")
    @Schema(
            description = "ID del género al que pertenece la planta",
            example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long idGeneroPlanta;

    @NotNull(message = "El ID de la especie es obligatorio")
    @Positive(message = "El ID de la especie debe ser mayor que cero")
    @Schema(
            description = "ID de la especie de la planta",
            example = "5", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long idEspecie;

    @NotNull(message = "El ID del ciclo de producción es obligatorio")
    @Positive(message = "El ID del ciclo de producción debe ser mayor que cero")
    @Schema(description = "ID del ciclo de producción asociado a la planta",
            example = "3",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private Long idCicloProduccion;

    @NotNull(message = "El ID del ciclo de germinación es obligatorio")
    @Positive(message = "El ID del ciclo de germinación debe ser mayor que cero")
    @Schema(
            description = "ID del ciclo de germinación asociado a la planta",
            example = "2",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private Long idCicloGerminacion;

    @NotNull(message = "El ID de la estación de cultivo es obligatorio")
    @Positive(message = "El ID de la estación de cultivo debe ser mayor que cero")
    @Schema(
            description = "ID de la estación de cultivo de la planta",
            example = "1",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private Long idEstacionCultivo;

    @NotNull(message = "El ID del tipo de planta es obligatorio")
    @Positive(message = "El ID del tipo de planta debe ser mayor que cero")
    @Schema(description = "ID del tipo de planta", example = "4", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long idTipoPlanta;

    @NotBlank(message = "El nombre de la planta es obligatorio")
    @Size(max = 100, message = "El nombre de la planta no puede superar los 100 caracteres")
    @Schema(
            description = "Nombre común de la planta",
            example = "Tomate",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String nombre;

    @Size(max = 150, message = "El nombre científico no puede superar los 150 caracteres")
    @Schema(
            description = "Nombre científico de la planta",
            example = "Solanum lycopersicum"
    )
    private String nombreCientifico;

    @Size(max = 500, message = "La descripción no puede superar los 500 caracteres")
    @Schema(
            description = "Descripción general de la planta",
            example = "Planta herbácea cultivada por su fruto comestible"
    )
    private String descripcion;

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

    @DecimalMin(value = "0.0", message = "Las horas solares mínimas no pueden ser negativas")
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

    @Size(max = 255, message = "La URL de la imagen no puede superar los 255 caracteres")
    @Schema(
            description = "URL de la imagen de la planta",
            example = "https://res.cloudinary.com/demo/image/upload/planta.jpg"
    )
    private String imgPlanta;

    @Size(max = 255, message = "El public ID de la imagen no puede superar los 255 caracteres")
    @Schema(
            description = "Identificador público de la imagen almacenada",
            example = "plantas/tomate_001"
    )
    private String publicIdImgPlanta;

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

    @Size(max = 50, message = "La frecuencia de riego no puede superar los 50 caracteres")
    @Schema(
            description = "Frecuencia recomendada de riego",
            example = "Cada 2 días"
    )
    private String frecuenciaRiego;

    public PlantaDtoReq(Long idFamiliaBotanica, Long idGeneroPlanta, Long idEspecie, Long idCicloProduccion, Long idCicloGerminacion, Long idEstacionCultivo, Long idTipoPlanta, String nombre, String nombreCientifico, String descripcion, Double temperaturaMinima, Double temperaturaMaxima, Double temperaturaIdeal, Double humedadMinima, Double humedadMaxima, Double humedadIdeal, Double horasSolaresMinimas, Double horasSolaresMaximas, Double horasSolaresIdeales, String imgPlanta, String publicIdImgPlanta, Double precipitacionMinima, Double precipitacionMaxima, Double precipitacionIdeal, Double altitudMinima, Double altitudMaxima, Double phSueloMinimo, Double phSueloMaximo, Double phSueloIdeal, String frecuenciaRiego) {
        this.idFamiliaBotanica = idFamiliaBotanica;
        this.idGeneroPlanta = idGeneroPlanta;
        this.idEspecie = idEspecie;
        this.idCicloProduccion = idCicloProduccion;
        this.idCicloGerminacion = idCicloGerminacion;
        this.idEstacionCultivo = idEstacionCultivo;
        this.idTipoPlanta = idTipoPlanta;
        this.nombre = nombre;
        this.nombreCientifico = nombreCientifico;
        this.descripcion = descripcion;
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
        this.temperaturaIdeal = temperaturaIdeal;
        this.humedadMinima = humedadMinima;
        this.humedadMaxima = humedadMaxima;
        this.humedadIdeal = humedadIdeal;
        this.horasSolaresMinimas = horasSolaresMinimas;
        this.horasSolaresMaximas = horasSolaresMaximas;
        this.horasSolaresIdeales = horasSolaresIdeales;
        this.imgPlanta = imgPlanta;
        this.publicIdImgPlanta = publicIdImgPlanta;
        this.precipitacionMinima = precipitacionMinima;
        this.precipitacionMaxima = precipitacionMaxima;
        this.precipitacionIdeal = precipitacionIdeal;
        this.altitudMinima = altitudMinima;
        this.altitudMaxima = altitudMaxima;
        this.phSueloMinimo = phSueloMinimo;
        this.phSueloMaximo = phSueloMaximo;
        this.phSueloIdeal = phSueloIdeal;
        this.frecuenciaRiego = frecuenciaRiego;
    }

    public PlantaDtoReq() {
    }

    public Long getIdFamiliaBotanica() {
        return idFamiliaBotanica;
    }

    public void setIdFamiliaBotanica(Long idFamiliaBotanica) {
        this.idFamiliaBotanica = idFamiliaBotanica;
    }

    public Long getIdGeneroPlanta() {
        return idGeneroPlanta;
    }

    public void setIdGeneroPlanta(Long idGeneroPlanta) {
        this.idGeneroPlanta = idGeneroPlanta;
    }

    public Long getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(Long idEspecie) {
        this.idEspecie = idEspecie;
    }

    public Long getIdCicloProduccion() {
        return idCicloProduccion;
    }

    public void setIdCicloProduccion(Long idCicloProduccion) {
        this.idCicloProduccion = idCicloProduccion;
    }

    public Long getIdCicloGerminacion() {
        return idCicloGerminacion;
    }

    public void setIdCicloGerminacion(Long idCicloGerminacion) {
        this.idCicloGerminacion = idCicloGerminacion;
    }

    public Long getIdEstacionCultivo() {
        return idEstacionCultivo;
    }

    public void setIdEstacionCultivo(Long idEstacionCultivo) {
        this.idEstacionCultivo = idEstacionCultivo;
    }

    public Long getIdTipoPlanta() {
        return idTipoPlanta;
    }

    public void setIdTipoPlanta(Long idTipoPlanta) {
        this.idTipoPlanta = idTipoPlanta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public String getImgPlanta() {
        return imgPlanta;
    }

    public void setImgPlanta(String imgPlanta) {
        this.imgPlanta = imgPlanta;
    }

    public String getPublicIdImgPlanta() {
        return publicIdImgPlanta;
    }

    public void setPublicIdImgPlanta(String publicIdImgPlanta) {
        this.publicIdImgPlanta = publicIdImgPlanta;
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

    public String getFrecuenciaRiego() {
        return frecuenciaRiego;
    }

    public void setFrecuenciaRiego(String frecuenciaRiego) {
        this.frecuenciaRiego = frecuenciaRiego;
    }

}
