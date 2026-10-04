/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.REQUEST.CULTIVO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;

/**
 *
 * @author luis
 */
public class CultivoAdminDtoReq {

    @Schema(
            description = "Fecha de inicio del cultivo",
            example = "2026-09-23",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "La fecha de inicio es obligatoria")
    private LocalDate fechaInicio;

    @Schema(
            description = "Identificador de la planta que se va a cultivar",
            example = "1",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "El ID de la planta es obligatorio")
    @Positive(message = "El ID de la planta debe ser mayor que cero")
    private Long id_planta;

    @Schema(
            description = "Identificador del usuario propietario del cultivo",
            example = "1",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "El ID del usuario es obligatorio")
    @Positive(message = "El ID del usuario debe ser mayor que cero")
    private Long id_user;

    @Schema(
            description = "Fecha estimada de finalización del cultivo",
            example = "2027-01-20",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "La fecha estimada de fin es obligatoria")
    private LocalDate fechaEstimadaFin;

    @Schema(
            description = "Cantidad de producto sembrado",
            example = "150.50",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "La cantidad sembrada es obligatoria")
    @DecimalMin(value = "0.01", message = "La cantidad sembrada debe ser mayor que cero")
    @Digits(integer = 10, fraction = 2, message = "La cantidad sembrada debe tener máximo 10 enteros y 2 decimales")
    private Double cantidadSembrada;

    @Schema(
            description = "Identificador de la unidad de peso utilizada",
            example = "1",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "El ID de la unidad de peso es obligatorio")
    @Positive(message = "El ID de la unidad de peso debe ser mayor que cero")
    private Long id_unidad_peso;

    @Schema(
            description = "Área utilizada para sembrar el cultivo",
            example = "2.50",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "El área sembrada es obligatoria")
    @DecimalMin(value = "0.01", message = "El área sembrada debe ser mayor que cero")
    @Digits(integer = 10, fraction = 2, message = "El área sembrada debe tener máximo 10 enteros y 2 decimales")
    private Double areaSembrada;

    @Schema(
            description = "Identificador de la unidad de área",
            example = "1",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "El ID de la unidad de área es obligatorio")
    @Positive(message = "El ID de la unidad de área debe ser mayor que cero")
    private Long id_unidad_area;

    @Schema(
            description = "Identificador del estado actual del cultivo",
            example = "1",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "El ID del estado del cultivo es obligatorio")
    @Positive(message = "El ID del estado del cultivo debe ser mayor que cero")
    private Long id_estado_cultivo;

    @Schema(
            description = "Cantidad de producto disponible",
            example = "100.00",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "La cantidad disponible es obligatoria")
    @DecimalMin(value = "0.00", message = "La cantidad disponible no puede ser negativa")
    @Digits(integer = 10, fraction = 2, message = "La cantidad disponible debe tener máximo 10 enteros y 2 decimales")
    private Double cantidadDisponible;

    @Schema(
            description = "Precio por kilogramo del producto",
            example = "4500.00",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "El precio por kilogramo es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio por kilogramo debe ser mayor que cero")
    @Digits(integer = 10, fraction = 2, message = "El precio por kilogramo debe tener máximo 10 enteros y 2 decimales")
    private Double precioPorKg;

    @Schema(
            description = "Cantidad disponible del producto destinada para venta",
            example = "80.00",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "La cantidad disponible para venta es obligatoria")
    @DecimalMin(value = "0.00", message = "La cantidad disponible para venta no puede ser negativa")
    @Digits(integer = 10, fraction = 2, message = "La cantidad disponible para venta debe tener máximo 10 enteros y 2 decimales")
    private Double cantidadDisponibleParaVenta;

    public CultivoAdminDtoReq(LocalDate fechaInicio, Long id_planta, Long id_user, LocalDate fechaEstimadaFin, Double cantidadSembrada, Long id_unidad_peso, Double areaSembrada, Long id_unidad_area, Long id_estado_cultivo, Double cantidadDisponible, Double precioPorKg, Double cantidadDisponibleParaVenta) {
        this.fechaInicio = fechaInicio;
        this.id_planta = id_planta;
        this.id_user = id_user;
        this.fechaEstimadaFin = fechaEstimadaFin;
        this.cantidadSembrada = cantidadSembrada;
        this.id_unidad_peso = id_unidad_peso;
        this.areaSembrada = areaSembrada;
        this.id_unidad_area = id_unidad_area;
        this.id_estado_cultivo = id_estado_cultivo;
        this.cantidadDisponible = cantidadDisponible;
        this.precioPorKg = precioPorKg;
        this.cantidadDisponibleParaVenta = cantidadDisponibleParaVenta;
    }

    public CultivoAdminDtoReq() {
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Long getId_planta() {
        return id_planta;
    }

    public void setId_planta(Long id_planta) {
        this.id_planta = id_planta;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public LocalDate getFechaEstimadaFin() {
        return fechaEstimadaFin;
    }

    public void setFechaEstimadaFin(LocalDate fechaEstimadaFin) {
        this.fechaEstimadaFin = fechaEstimadaFin;
    }

    public Double getCantidadSembrada() {
        return cantidadSembrada;
    }

    public void setCantidadSembrada(Double cantidadSembrada) {
        this.cantidadSembrada = cantidadSembrada;
    }

    public Long getId_unidad_peso() {
        return id_unidad_peso;
    }

    public void setId_unidad_peso(Long id_unidad_peso) {
        this.id_unidad_peso = id_unidad_peso;
    }

    public Double getAreaSembrada() {
        return areaSembrada;
    }

    public void setAreaSembrada(Double areaSembrada) {
        this.areaSembrada = areaSembrada;
    }

    public Long getId_unidad_area() {
        return id_unidad_area;
    }

    public void setId_unidad_area(Long id_unidad_area) {
        this.id_unidad_area = id_unidad_area;
    }

    public Long getId_estado_cultivo() {
        return id_estado_cultivo;
    }

    public void setId_estado_cultivo(Long id_estado_cultivo) {
        this.id_estado_cultivo = id_estado_cultivo;
    }

    public Double getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(Double cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public Double getPrecioPorKg() {
        return precioPorKg;
    }

    public void setPrecioPorKg(Double precioPorKg) {
        this.precioPorKg = precioPorKg;
    }

    public Double getCantidadDisponibleParaVenta() {
        return cantidadDisponibleParaVenta;
    }

    public void setCantidadDisponibleParaVenta(Double cantidadDisponibleParaVenta) {
        this.cantidadDisponibleParaVenta = cantidadDisponibleParaVenta;
    }

}
