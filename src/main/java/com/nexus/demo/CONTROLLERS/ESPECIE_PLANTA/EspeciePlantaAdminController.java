/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONTROLLERS.ESPECIE_PLANTA;

import com.nexus.demo.DTOS.GLOBAL.BasicResponseDto;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.ESPECIE_PLANTA.EspeciePlantaAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.ESPECIE_PLANTA.EspeciePlantaAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.ESPECIE_PLANTA.EspeciePlantaDetailsDtoResp;
import com.nexus.demo.SERVICES.ESPECIE_PLANTA.IEspeciePlantaAdminService;
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
@Tag(name = "Administracion de Especies de plantas del sistema",
        description = "Módulo encargado de gestionar operaciones administrativas sobre las especies de plantas del sistema")
@RequestMapping(value = "/api/v1/especies-plantas/admin")
@RestController
public class EspeciePlantaAdminController {

    private IEspeciePlantaAdminService especiePlantaAdminService;

    @Autowired
    public EspeciePlantaAdminController(IEspeciePlantaAdminService especiePlantaAdminService) {
        this.especiePlantaAdminService = especiePlantaAdminService;
    }

    @Operation(description = "Operación encargada de crear especies de plantas en el sistema",
            method = "POST")
    @PostMapping()
    public ResponseEntity<BasicResponseDto> create(
            @Valid
            @RequestBody(required = true) EspeciePlantaAdminDtoReq especiePlantaAdminDtoReq) {

        especiePlantaAdminService.create(especiePlantaAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("La especie de planta se ha creado correctamnete en el sistema"));
    }

    @Operation(description = "Operación encargada de editar los dtaos de una especie",
            method = "PUT")
    @PutMapping(value = "/{id}")
    public ResponseEntity<BasicResponseDto> updateById(
            @PathVariable(
                    name = "id",
                    required = true) Long id,
            @Valid
            @RequestBody(required = true) EspeciePlantaAdminDtoReq especiePlantaAdminDtoReq) {

        especiePlantaAdminService.updateById(id, especiePlantaAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("Especie actualizada correctamente"));

    }

    @Operation(description = "Operación encaragda de mostrar las especies de plantas que estan en el sistema",
            method = "GET")
    @GetMapping()
    public ResponseEntity<PageResponse<EspeciePlantaAdminDtoResp>> getAll(
            @RequestParam(
                    name = "nombre",
                    required = false) String nombre,
            @RequestParam(
                    name = "is_delete",
                    required = false) Boolean is_delete,
            Pageable pageable
    ) {

        return ResponseEntity
                .ok()
                .body(especiePlantaAdminService.getAll(nombre, is_delete, pageable));
    }

    @Operation(description = "Operación encargada de mostrar los detalles de una especie de planta",
            method = "GET")
    @GetMapping(value = "/{id}/details")
    public ResponseEntity<EspeciePlantaDetailsDtoResp> getDetailsById(
            @PathVariable(
                    name = "id",
                    required = true) Long id
    ) {

        return ResponseEntity
                .ok()
                .body(especiePlantaAdminService.getDetailsByID(id));
    }

}
