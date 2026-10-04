/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.RESPONSE.PRODUCTO;

/**
 *
 * @author luis
 */
public class ProductoAdminDtoResp {

    private Long id;

    private String nombre;

    private String descripcion;

    private Double precioUnidad;

    private String categoria;

    private String imgProdcuto;

    private String marcaProducto;

    private String unidadPeso;

    private Double peso;

    private Double cantidadMinima;

    private Double cantidadMax;

    private Double cantActual;

    public ProductoAdminDtoResp(Long id, String nombre, String descripcion, Double precioUnidad, String categoria, String imgProdcuto, String marcaProducto, String unidadPeso, Double peso, Double cantidadMinima, Double cantidadMax, Double cantActual) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioUnidad = precioUnidad;
        this.categoria = categoria;
        this.imgProdcuto = imgProdcuto;
        this.marcaProducto = marcaProducto;
        this.unidadPeso = unidadPeso;
        this.peso = peso;
        this.cantidadMinima = cantidadMinima;
        this.cantidadMax = cantidadMax;
        this.cantActual = cantActual;
    }

    public ProductoAdminDtoResp() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getImgProdcuto() {
        return imgProdcuto;
    }

    public void setImgProdcuto(String imgProdcuto) {
        this.imgProdcuto = imgProdcuto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public String getUnidadPeso() {
        return unidadPeso;
    }

    public void setUnidadPeso(String unidadPeso) {
        this.unidadPeso = unidadPeso;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
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
