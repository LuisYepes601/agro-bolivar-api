/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONTROLLERS.GENERO_PLANTA;

import com.nexus.demo.DTOS.GLOBAL.BasicResponseDto;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.GENERO_PLANTA.GeneroPlantaAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.GENERO_PLANTA.GeneroPlantaAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.GENERO_PLANTA.GeneroPlantaDetailsDtoResp;
import com.nexus.demo.SERVICES.GENERO_PLANTA.IGeneroPlantaAdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author luis
 */
@Tag(name = "Administarción de Generos de plantas",
        description = "Módulo encargado de gestionar las operaciones administrativas sobre los generos de plantas"
        + "del sistema")
@RequestMapping(value = "/api/v1/genero-plantas/admin")
@RestController
public class GeneroPlantaAdminController {

    private IGeneroPlantaAdminService generoPlantaAdminService;

    @Autowired
    public GeneroPlantaAdminController(IGeneroPlantaAdminService generoPlantaAdminService) {
        this.generoPlantaAdminService = generoPlantaAdminService;
    }

    @Operation(description = "Operación encargada de crear generos de plnatas en el sistema",
            method = "POST")
    @PostMapping()
    public ResponseEntity<BasicResponseDto> create(
            @Valid
            @RequestBody(required = true) GeneroPlantaAdminDtoReq generoPlantaAdminDtoReq) {

        generoPlantaAdminService.create(generoPlantaAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("Se ha creado con exito el genero de planta"));
    }

    @Operation(description = "Operación encargada de editar datos de un genero de planta del sistema",
            method = "PUT")
    @PutMapping(value = "/{id}")
    public ResponseEntity<BasicResponseDto> updateById(
            @PathVariable(
                    name = "id",
                    required = true) Long id,
            @RequestBody(required = true) GeneroPlantaAdminDtoReq generoPlantaAdminDtoReq) {

        generoPlantaAdminService.updateById(id, generoPlantaAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("Se ha actualizado con exito el genero de la planta"));
    }

    @Operation(description = "Operación encaragda de mostrar todos los generos de plantas del sistema, segun su filtro",
            method = "GET")
    @GetMapping()
    public ResponseEntity<PageResponse<GeneroPlantaAdminDtoResp>> getAll(
            @RequestParam(
                    name = "nombre",
                    required = false) String nombre,
            @RequestParam(
                    name = "active",
                    required = false) Boolean active,
            Pageable pageable
    ) {

        return ResponseEntity
                .ok()
                .body(generoPlantaAdminService.getAll(nombre, active, pageable));
    }

    @Operation(description = "Operación encaragda de mostrar lso detalles de un genero de planta del sistema",
            method = "GET")
    @GetMapping(value = "/{id}/details")
    public ResponseEntity<GeneroPlantaDetailsDtoResp> getDetailsById(
            @PathVariable(name = "id",
                    required = true) Long id) {

        return ResponseEntity
                .ok()
                .body(generoPlantaAdminService.getDetailsById(id));
    }
}
