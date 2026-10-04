/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.REQUEST.PRODUCTO;

import com.nexus.demo.DTOS.REQUEST.INFORMACION_SEGURIDAD.InformacionSeguridadDtoReq;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 *
 * @author luis
 */
public class ProductoAdminDtoReq {

    @NotBlank(message = "El nombre del producto es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    @Schema(description = "Nombre del producto", example = "Arroz Diana")
    private String nombre;

    @Size(max = 500, message = "La descripción no puede superar los 500 caracteres")
    @Schema(description = "Descripción del producto", example = "Arroz blanco de excelente calidad")
    private String descripcion;

    @NotNull(message = "El precio por unidad es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor que 0")
    @Digits(integer = 10, fraction = 2, message = "El precio debe tener máximo 10 dígitos enteros y 2 decimales")
    @Schema(description = "Precio del producto por unidad", example = "4500.00", minimum = "0.01")
    private Double precioUnidad;

    @NotNull(message = "La categoría del producto es obligatoria")
    @Schema(description = "ID de la categoría del producto", example = "1")
    private Long id_categoria_producto;

    @NotNull(message = "La unidad de peso es obligatoria")
    @Schema(description = "ID de la unidad de medida del producto", example = "1")
    private Long id_unidad_peso;

    private InformacionSeguridadDtoReq informacionSeguridadDtoReq;

    @NotNull(message = "La marca del producto es obligatoria")
    @Schema(description = "ID de la marca del producto", example = "1")
    private Long id_marca_producto;

    private Long id_user;

    @NotNull(message = "El peso es obligatorio")
    @DecimalMin(
            value = "0.01",
            message = "El peso debe ser mayor que 0"
    )
    @Digits(
            integer = 10,
            fraction = 2,
            message = "El peso debe tener máximo 10 dígitos enteros y 2 decimales"
    )
    @Schema(
            description = "Peso del producto",
            example = "1.50",
            minimum = "0.01"
    )
    private Double peso;

    @NotNull(message = "La cantidad mínima es obligatoria")
    @DecimalMin(
            value = "0.01",
            message = "La cantidad mínima debe ser mayor que 0"
    )
    @Digits(
            integer = 10,
            fraction = 2,
            message = "La cantidad mínima debe tener máximo 10 dígitos enteros y 2 decimales"
    )
    @Schema(
            description = "Cantidad mínima de unidades permitida en el inventario",
            example = "10.00",
            minimum = "0.01"
    )
    private Double cantidadMinima;

    @NotNull(message = "La cantidad máxima es obligatoria")
    @DecimalMin(
            value = "0.01",
            message = "La cantidad máxima debe ser mayor que 0"
    )
    @Digits(
            integer = 10,
            fraction = 2,
            message = "La cantidad máxima debe tener máximo 10 dígitos enteros y 2 decimales"
    )
    @Schema(
            description = "Cantidad máxima de unidades permitida en el inventario",
            example = "100.00",
            minimum = "0.01"
    )
    private Double cantidadMax;

    @NotNull(message = "La cantidad actual es obligatoria")
    @DecimalMin(
            value = "0.00",
            message = "La cantidad actual no puede ser negativa"
    )
    @Digits(
            integer = 10,
            fraction = 2,
            message = "La cantidad actual debe tener máximo 10 dígitos enteros y 2 decimales"
    )
    @Schema(
            description = "Cantidad actual disponible del producto",
            example = "50.00",
            minimum = "0.00"
    )
    private Double cantActual;

    public ProductoAdminDtoReq(String nombre, String descripcion, Double precioUnidad, Long id_categoria_producto, Long id_unidad_peso, InformacionSeguridadDtoReq informacionSeguridadDtoReq, Long id_marca_producto, Long id_user, Double peso, Double cantidadMinima, Double cantidadMax, Double cantActual) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioUnidad = precioUnidad;
        this.id_categoria_producto = id_categoria_producto;
        this.id_unidad_peso = id_unidad_peso;
        this.informacionSeguridadDtoReq = informacionSeguridadDtoReq;
        this.id_marca_producto = id_marca_producto;
        this.id_user = id_user;
        this.peso = peso;
        this.cantidadMinima = cantidadMinima;
        this.cantidadMax = cantidadMax;
        this.cantActual = cantActual;
    }

    public ProductoAdminDtoReq() {
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

    public Double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(Double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public Long getId_categoria_producto() {
        return id_categoria_producto;
    }

    public void setId_categoria_producto(Long id_categoria_producto) {
        this.id_categoria_producto = id_categoria_producto;
    }

    public Long getId_unidad_peso() {
        return id_unidad_peso;
    }

    public void setId_unidad_peso(Long id_unidad_peso) {
        this.id_unidad_peso = id_unidad_peso;
    }

    public InformacionSeguridadDtoReq getInformacionSeguridadDtoReq() {
        return informacionSeguridadDtoReq;
    }

    public void setInformacionSeguridadDtoReq(InformacionSeguridadDtoReq informacionSeguridadDtoReq) {
        this.informacionSeguridadDtoReq = informacionSeguridadDtoReq;
    }

    public Long getId_marca_producto() {
        return id_marca_producto;
    }

    public void setId_marca_producto(Long id_marca_producto) {
        this.id_marca_producto = id_marca_producto;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public Double getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(Double cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public Double getCantidadMax() {
        return cantidadMax;
    }

    public void setCantidadMax(Double cantidadMax) {
        this.cantidadMax = cantidadMax;
    }

    public Double getCantActual() {
        return cantActual;
    }

    public void setCantActual(Double cantActual) {
        this.cantActual = cantActual;
    }

}
