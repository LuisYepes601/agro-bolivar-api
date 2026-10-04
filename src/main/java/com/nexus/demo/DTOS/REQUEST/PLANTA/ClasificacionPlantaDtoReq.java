/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.REQUEST.PLANTA;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 *
 * @author luis
 */
public class ClasificacionPlantaDtoReq {

    @NotNull(message = "El ID de la familia botánica es obligatorio")
    @Positive(message = "El ID de la familia botánica debe ser mayor que cero")
    @Schema(
            description = "ID de la familia botánica a la que pertenece la planta",
            example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long idFamiliaBotanica;

    @NotNull(message = "El ID del género de la planta es obligatorio")
    @Positive(message = "El ID del género de la planta debe ser mayor que cero")
    @Schema(
            description = "ID del género al que pertenece la planta",
            example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long idGeneroPlanta;

    @NotNull(message = "El ID de la especie es obligatorio")
    @Positive(message = "El ID de la especie debe ser mayor que cero")
    @Schema(
            description = "ID de la especie de la planta",
            example = "5", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long idEspecie;

    @NotNull(message = "El ID del tipo de planta es obligatorio")
    @Positive(message = "El ID del tipo de planta debe ser mayor que cero")
    @Schema(description = "ID del tipo de planta", example = "4", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long idTipoPlanta;

    public ClasificacionPlantaDtoReq(Long idFamiliaBotanica, Long idGeneroPlanta, Long idEspecie, Long idTipoPlanta) {
        this.idFamiliaBotanica = idFamiliaBotanica;
        this.idGeneroPlanta = idGeneroPlanta;
        this.idEspecie = idEspecie;
        this.idTipoPlanta = idTipoPlanta;
    }

    public ClasificacionPlantaDtoReq() {
    }

    public Long getIdFamiliaBotanica() {
        return idFamiliaBotanica;
    }

    public void setIdFamiliaBotanica(Long idFamiliaBotanica) {
        this.idFamiliaBotanica = idFamiliaBotanica;
    }

    public Long getIdGeneroPlanta() {
        return idGeneroPlanta;
    }

    public void setIdGeneroPlanta(Long idGeneroPlanta) {
        this.idGeneroPlanta = idGeneroPlanta;
    }

    public Long getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(Long idEspecie) {
        this.idEspecie = idEspecie;
    }

    public Long getIdTipoPlanta() {
        return idTipoPlanta;
    }

    public void setIdTipoPlanta(Long idTipoPlanta) {
        this.idTipoPlanta = idTipoPlanta;
    }

}
