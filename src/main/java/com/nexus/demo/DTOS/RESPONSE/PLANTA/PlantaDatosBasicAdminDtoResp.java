/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.RESPONSE.PLANTA;

import com.nexus.demo.DTOS.RESPONSE.ESPECIE_PLANTA.EspecieBasicDtoRes;
import com.nexus.demo.DTOS.RESPONSE.ESPECIE_PLANTA.EspeciePlantaAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.FAMILIA_BOTANICA.FamiliaBotanicaAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.FAMILIA_BOTANICA.FamiliaBotanicaBasicDtoResponse;
import com.nexus.demo.DTOS.RESPONSE.GENERO_PLANTA.GeneroPlantaAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.GENERO_PLANTA.GeneroPlantaBasicDtoRes;
import com.nexus.demo.DTOS.RESPONSE.TIPO_PLANTA.TipoPlantaAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.TIPO_PLANTA.TipoPlantaBasicDtoRes;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 *
 * @author luis
 */
public class PlantaDatosBasicAdminDtoResp {

    @Schema(description = "ID de la planta", example = "1")
    private Long id;

    @Schema(description = "Nombre común de la planta", example = "Tomate")
    private String nombre;

    @Schema(description = "Nombre científico de la planta", example = "Solanum lycopersicum")
    private String nombreCientifico;

    @Schema(description = "Descripción de la planta", example = "Planta hortícola de fruto")
    private String descripcion;

    private Long idFamilia;
    private String nombreFamilia;

    private Long idGenero;
    private String nombreGenero;

    private Long idEspecie;
    private String nombreEspecie;

    private Long idTipo;
    private String nombreTipo;

    public PlantaDatosBasicAdminDtoResp(Long id, String nombre, String nombreCientifico, String descripcion, Long idFamilia, String nombreFamilia, Long idGenero, String nombreGenero, Long idEspecie, String nombreEspecie, Long idTipo, String nombreTipo) {
        this.id = id;
        this.nombre = nombre;
        this.nombreCientifico = nombreCientifico;
        this.descripcion = descripcion;
        this.idFamilia = idFamilia;
        this.nombreFamilia = nombreFamilia;
        this.idGenero = idGenero;
        this.nombreGenero = nombreGenero;
        this.idEspecie = idEspecie;
        this.nombreEspecie = nombreEspecie;
        this.idTipo = idTipo;
        this.nombreTipo = nombreTipo;
    }

    public PlantaDatosBasicAdminDtoResp() {
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

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Long idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getNombreFamilia() {
        return nombreFamilia;
    }

    public void setNombreFamilia(String nombreFamilia) {
        this.nombreFamilia = nombreFamilia;
    }

    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }

    public Long getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(Long idEspecie) {
        this.idEspecie = idEspecie;
    }

    public String getNombreEspecie() {
        return nombreEspecie;
    }

    public void setNombreEspecie(String nombreEspecie) {
        this.nombreEspecie = nombreEspecie;
    }

    public Long getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Long idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

}
