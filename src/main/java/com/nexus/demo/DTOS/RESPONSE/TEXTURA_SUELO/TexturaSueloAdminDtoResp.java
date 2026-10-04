/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.RESPONSE.TEXTURA_SUELO;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

/**
 *
 * @author luis
 */
public class TexturaSueloAdminDtoResp {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String nombre;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String descripcion;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String forma;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime createAt;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime updateAt;

    public TexturaSueloAdminDtoResp(Long id, String nombre, String descripcion, String forma, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.forma = forma;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public TexturaSueloAdminDtoResp() {
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

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
    
    
}
