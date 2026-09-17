/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.REQUEST.TIPO_SUELO;

/**
 *
 * @author luis
 */
public class TexturaSueloBasicDtoReq {
    
    public Long id;
    
    public String nombre;

    
    public TexturaSueloBasicDtoReq(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public TexturaSueloBasicDtoReq() {
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
    
    
     
    
    
    
    
}
