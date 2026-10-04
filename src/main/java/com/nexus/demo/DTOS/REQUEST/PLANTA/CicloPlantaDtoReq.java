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
public class CicloPlantaDtoReq {

    @NotNull(message = "El ID del ciclo de producción es obligatorio")
    @Positive(message = "El ID del ciclo de producción debe ser mayor que cero")
    @Schema(description = "ID del ciclo de producción asociado a la planta",
            example = "3",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private Long idCicloProduccion;

    @NotNull(message = "El ID del ciclo de germinación es obligatorio")
    @Positive(message = "El ID del ciclo de germinación debe ser mayor que cero")
    @Schema(
            description = "ID del ciclo de germinación asociado a la planta",
            example = "2",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private Long idCicloGerminacion;

    @NotNull(message = "El ID de la estación de cultivo es obligatorio")
    @Positive(message = "El ID de la estación de cultivo debe ser mayor que cero")
    @Schema(
            description = "ID de la estación de cultivo de la planta",
            example = "1",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private Long idEstacionCultivo;

    public CicloPlantaDtoReq(Long idCicloProduccion, Long idCicloGerminacion, Long idEstacionCultivo) {
        this.idCicloProduccion = idCicloProduccion;
        this.idCicloGerminacion = idCicloGerminacion;
        this.idEstacionCultivo = idEstacionCultivo;
    }

    public CicloPlantaDtoReq() {
    }

    public Long getIdCicloProduccion() {
        return idCicloProduccion;
    }

    public void setIdCicloProduccion(Long idCicloProduccion) {
        this.idCicloProduccion = idCicloProduccion;
    }

    public Long getIdCicloGerminacion() {
        return idCicloGerminacion;
    }

    public void setIdCicloGerminacion(Long idCicloGerminacion) {
        this.idCicloGerminacion = idCicloGerminacion;
    }

    public Long getIdEstacionCultivo() {
        return idEstacionCultivo;
    }

    public void setIdEstacionCultivo(Long idEstacionCultivo) {
        this.idEstacionCultivo = idEstacionCultivo;
    }

}
