/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.RESPONSE.PRODUCTO;

/**
 *
 * @author luis
 */
public class ProductoDtoResp {

    private Long id;

    private String nombre;

    private String descripcion;

    private Double precioUnidad;

    private Long id_categoria;

    private String categoria;

    private String imgProdcuto;

    private String telefono;

    public ProductoDtoResp(Long id, String nombre, String descripcion, Double precioUnidad, Long id_categoria, String categoria, String imgProdcuto, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioUnidad = precioUnidad;
        this.id_categoria = id_categoria;
        this.categoria = categoria;
        this.imgProdcuto = imgProdcuto;
        this.telefono = telefono;
    }

    public ProductoDtoResp() {
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

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
