/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.REQUEST.PLANTA;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;

/**
 *
 * @author luis
 */
public class RiegoPlantaDtoReq {

    @Size(max = 50, message = "La frecuencia de riego no puede superar los 50 caracteres")
    @Schema(
            description = "Frecuencia recomendada de riego",
            example = "Cada 2 días"
    )
    private String frecuenciaRiego;

    public RiegoPlantaDtoReq(String frecuenciaRiego) {
        this.frecuenciaRiego = frecuenciaRiego;
    }

    public RiegoPlantaDtoReq() {
    }

    public String getFrecuenciaRiego() {
        return frecuenciaRiego;
    }

    public void setFrecuenciaRiego(String frecuenciaRiego) {
        this.frecuenciaRiego = frecuenciaRiego;
    }

}
