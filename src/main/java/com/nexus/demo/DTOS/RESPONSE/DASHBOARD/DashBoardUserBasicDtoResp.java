/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.RESPONSE.DASHBOARD;

/**
 *
 * @author luis
 */
public class DashBoardUserBasicDtoResp {

    private String nombre;

    private String rol;

    private String fotoPerfil;

    public DashBoardUserBasicDtoResp(String nombre, String rol, String fotoPerfil) {
        this.nombre = nombre;
        this.rol = rol;
        this.fotoPerfil = fotoPerfil;
    }

    public DashBoardUserBasicDtoResp() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

}
