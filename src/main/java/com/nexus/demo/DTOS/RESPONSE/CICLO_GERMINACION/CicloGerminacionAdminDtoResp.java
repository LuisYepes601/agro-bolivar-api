/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.RESPONSE.CICLO_GERMINACION;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

/**
 *
 * @author luis
 */
public class CicloGerminacionAdminDtoResp {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String nombre;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Integer diasMinimos;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Integer diasMaximos;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String descripcion;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime createAt;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime updateAt;

    public CicloGerminacionAdminDtoResp(Long id, String nombre, Integer diasMinimos, Integer diasMaximos, String descripcion, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.nombre = nombre;
        this.diasMinimos = diasMinimos;
        this.diasMaximos = diasMaximos;
        this.descripcion = descripcion;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public CicloGerminacionAdminDtoResp() {
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

    public Integer getDiasMinimos() {
        return diasMinimos;
    }

    public void setDiasMinimos(Integer diasMinimos) {
        this.diasMinimos = diasMinimos;
    }

    public Integer getDiasMaximos() {
        return diasMaximos;
    }

    public void setDiasMaximos(Integer diasMaximos) {
        this.diasMaximos = diasMaximos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
