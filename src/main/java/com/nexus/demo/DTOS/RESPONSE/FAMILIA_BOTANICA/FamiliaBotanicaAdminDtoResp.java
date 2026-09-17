/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.RESPONSE.FAMILIA_BOTANICA;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

/**
 *
 * @author luis
 */
public class FamiliaBotanicaAdminDtoResp {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String nombre;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String descripcion;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime updateAt;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime createAt;

    public FamiliaBotanicaAdminDtoResp(Long id, String nombre, String descripcion, LocalDateTime updateAt, LocalDateTime createAt) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.updateAt = updateAt;
        this.createAt = createAt;
    }

    public FamiliaBotanicaAdminDtoResp() {
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

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

}
