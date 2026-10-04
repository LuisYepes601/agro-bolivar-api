/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.RESPONSE.CULTIVO;

/**
 *
 * @author luis
 */
public class CultivoAdminDtoResp {

    private Long id;

    private String nombre;

    private String email;

    private String telefono;

    private String urlFoto;

    public String estado;

    private Double precioPorKg;

    public CultivoAdminDtoResp(Long id, String nombre, String email, String telefono, String urlFoto, String estado, Double precioPorKg) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.urlFoto = urlFoto;
        this.estado = estado;
        this.precioPorKg = precioPorKg;
    }

    public CultivoAdminDtoResp() {
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

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getPrecioPorKg() {
        return precioPorKg;
    }

    public void setPrecioPorKg(Double precioPorKg) {
        this.precioPorKg = precioPorKg;
    }

}
