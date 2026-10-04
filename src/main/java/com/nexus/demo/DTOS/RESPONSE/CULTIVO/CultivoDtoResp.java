/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.RESPONSE.CULTIVO;

import java.time.LocalDate;

/**
 *
 * @author luis
 */
public class CultivoDtoResp {

    private Long id;

    private Long id_user;

    private String nombre_usuario;

    private String nombre_cultivo;

    private String url_img_cultivo;

    private LocalDate fechaInicio;

    private LocalDate fechaEstimadaFin;

    private Double cantidadSembrada;

    private Long id_unidad_peso;

    private String unidad_peso;

    private Double area_sembrada;

    private Long id_area_sembrada;

    private String areaSembrada;

    private Long id_estado_cultivo;

    private String estado_cultivo;

    private Double cantidadDisponible;

    private Double precioPorKg;

    private Double cantidadDisponibleParaVenta;
    
    private String email;
    
    private String telefono;

    public CultivoDtoResp() {
    }

    public CultivoDtoResp(Long id, Long id_user, String nombre_usuario, String nombre_cultivo, String url_img_cultivo, LocalDate fechaInicio, LocalDate fechaEstimadaFin, Double cantidadSembrada, Long id_unidad_peso, String unidad_peso, Double area_sembrada, Long id_area_sembrada, String areaSembrada, Long id_estado_cultivo, String estado_cultivo, Double cantidadDisponible, Double precioPorKg, Double cantidadDisponibleParaVenta, String email, String telefono) {
        this.id = id;
        this.id_user = id_user;
        this.nombre_usuario = nombre_usuario;
        this.nombre_cultivo = nombre_cultivo;
        this.url_img_cultivo = url_img_cultivo;
        this.fechaInicio = fechaInicio;
        this.fechaEstimadaFin = fechaEstimadaFin;
        this.cantidadSembrada = cantidadSembrada;
        this.id_unidad_peso = id_unidad_peso;
        this.unidad_peso = unidad_peso;
        this.area_sembrada = area_sembrada;
        this.id_area_sembrada = id_area_sembrada;
        this.areaSembrada = areaSembrada;
        this.id_estado_cultivo = id_estado_cultivo;
        this.estado_cultivo = estado_cultivo;
        this.cantidadDisponible = cantidadDisponible;
        this.precioPorKg = precioPorKg;
        this.cantidadDisponibleParaVenta = cantidadDisponibleParaVenta;
        this.email = email;
        this.telefono = telefono;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getNombre_cultivo() {
        return nombre_cultivo;
    }

    public void setNombre_cultivo(String nombre_cultivo) {
        this.nombre_cultivo = nombre_cultivo;
    }

    public String getUrl_img_cultivo() {
        return url_img_cultivo;
    }

    public void setUrl_img_cultivo(String url_img_cultivo) {
        this.url_img_cultivo = url_img_cultivo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
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

    public String getUnidad_peso() {
        return unidad_peso;
    }

    public void setUnidad_peso(String unidad_peso) {
        this.unidad_peso = unidad_peso;
    }

    public Double getArea_sembrada() {
        return area_sembrada;
    }

    public void setArea_sembrada(Double area_sembrada) {
        this.area_sembrada = area_sembrada;
    }

    public Long getId_area_sembrada() {
        return id_area_sembrada;
    }

    public void setId_area_sembrada(Long id_area_sembrada) {
        this.id_area_sembrada = id_area_sembrada;
    }

    public String getAreaSembrada() {
        return areaSembrada;
    }

    public void setAreaSembrada(String areaSembrada) {
        this.areaSembrada = areaSembrada;
    }

    public Long getId_estado_cultivo() {
        return id_estado_cultivo;
    }

    public void setId_estado_cultivo(Long id_estado_cultivo) {
        this.id_estado_cultivo = id_estado_cultivo;
    }

    public String getEstado_cultivo() {
        return estado_cultivo;
    }

    public void setEstado_cultivo(String estado_cultivo) {
        this.estado_cultivo = estado_cultivo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
