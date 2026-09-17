/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.RESPONSE.ESTACION_CULTIVO;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

/**
 *
 * @author luis
 */
public class EstacionCultivoAdminDtoResp {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String nombre;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String descripcion;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDate fechaInicio;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDate fechaFin;

    public EstacionCultivoAdminDtoResp(Long id, String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public EstacionCultivoAdminDtoResp() {
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

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

}
