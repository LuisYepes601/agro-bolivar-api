/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONTROLLERS.PLANTAS;

import com.nexus.demo.DTOS.GLOBAL.BasicResponseDto;
import com.nexus.demo.DTOS.REQUEST.PLANTA.PlantaDtoReq;
import com.nexus.demo.SERVICES.PLANTAS.IPlantaAdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author luis
 */
@Tag(name = "Adminstración de Plantas",
        description = "Módulo encargado de gestionar todas las operaciones administativas con respecto a las "
        + "plantas del sistema")
@RequestMapping(value = "/api/v1/plantas/admin")
@RestController
public class PlantaAdminController {

    private IPlantaAdminService plantaAdminService;

    public PlantaAdminController(IPlantaAdminService plantaAdminService) {
        this.plantaAdminService = plantaAdminService;
    }

    @Operation(description = "Operación encargada de crear una planta en el sistema",
            method = "GET")
    @PostMapping()
    public ResponseEntity<BasicResponseDto> create(
            @Valid
            @RequestPart(name = "body", required = true) PlantaDtoReq body,
            @RequestPart(name = "fotoPlanta", required = true) MultipartFile fotoPlanta
    ) {

        plantaAdminService.create(body, fotoPlanta);
        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("La planata ha sido creada con existo al sistema"));

    }
}
