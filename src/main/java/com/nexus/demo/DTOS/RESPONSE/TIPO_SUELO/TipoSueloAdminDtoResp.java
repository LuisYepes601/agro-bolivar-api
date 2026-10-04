/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.RESPONSE.TIPO_SUELO;

/**
 *
 * @author luis
 */
public class TipoSueloAdminDtoResp {

    public Long id;

    public String nombre;
    private String descripcion;
    private Double phMinimo;
    private Double phMaximo;
    private String color;

    public TipoSueloAdminDtoResp(Long id, String nombre, String descripcion, Double phMinimo, Double phMaximo, String color) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.phMinimo = phMinimo;
        this.phMaximo = phMaximo;
        this.color = color;
    }

    public TipoSueloAdminDtoResp() {
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

    public Double getPhMinimo() {
        return phMinimo;
    }

    public void setPhMinimo(Double phMinimo) {
        this.phMinimo = phMinimo;
    }

    public Double getPhMaximo() {
        return phMaximo;
    }

    public void setPhMaximo(Double phMaximo) {
        this.phMaximo = phMaximo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
