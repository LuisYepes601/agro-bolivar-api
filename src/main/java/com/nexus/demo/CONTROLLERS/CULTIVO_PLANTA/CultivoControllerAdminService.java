/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONTROLLERS.CULTIVO_PLANTA;

import com.nexus.demo.DTOS.GLOBAL.BasicResponseDto;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.CULTIVO.CultivoAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.CULTIVO.CultivoAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.CULTIVO.CultivoDtoResp;
import com.nexus.demo.SERVICES.CULTIVOS.ICultivoAdminService;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author luis
 */
@Tag(name = "Administración de cultivos",
        description = "Módulo encargado de gestionar las distintas operaciones sobre lso cultivos del sistema")
@RequestMapping(value = "/api/v1/cultivos/admin")
@RestController
public class CultivoControllerAdminService {

    private ICultivoAdminService cultivoAdminService;

    @Autowired
    public CultivoControllerAdminService(ICultivoAdminService cultivoAdminService) {
        this.cultivoAdminService = cultivoAdminService;
    }

    @Operation(description = "Operación encargada de crear cultivos en el sistema",
            method = "POST")
    @PostMapping()
    public ResponseEntity<BasicResponseDto> create(
            @Valid()
            @RequestPart(name = "body", required = true) CultivoAdminDtoReq cultivoAdminDtoReq,
            @RequestPart(name = "fotoCultivo", required = true) MultipartFile fotoCultivo
    ) {

        cultivoAdminService.create(cultivoAdminDtoReq, fotoCultivo);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("El cultivo ha sido creado con exito en el sistema"));
    }

    @Operation(description = "Operación encargada de actualizar datos de un cultivo",
            method = "PUT")
    @PutMapping(value = "/{id}")
    public ResponseEntity<BasicResponseDto> editarById(
            @PathVariable(name = "id", required = true) Long id,
            @RequestBody(required = true) CultivoAdminDtoReq cultivoAdminDtoReq
    ) {

        cultivoAdminService.updateById(id, cultivoAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("El cultivo ha sido editado con exito"));

    }

    @Operation(description = "Operación encraagda de editar la foto de un cultivo",
            method = "PUT")
    @PutMapping(value = "/{id}/foto-cultivo")
    public ResponseEntity<BasicResponseDto> editarFotoCultivo(
            @PathVariable(name = "id", required = true) Long id,
            @RequestPart(name = "foto", required = true) MultipartFile foto
    ) {

        cultivoAdminService.editarFotoCultivo(id, foto);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("Se ha editado con exito la foto del cultivo"));
    }

    @Operation(description = "Operación encargada de cargar lso cultivo segun sus filtros",
            method = "GET")
    @GetMapping()
    public ResponseEntity<PageResponse<CultivoAdminDtoResp>> getAll(
            @RequestParam(name = "nombre", required = false) String nombre,
            @RequestParam(name = "estado", required = false) Boolean estado,
            @RequestParam(name = "active", required = false) Boolean active,
            @RequestParam(name = "id_usuario", required = false)Long id_usuario,
            Pageable pageable
    ) {

        return ResponseEntity
                .ok()
                .body(cultivoAdminService.getAll(nombre, estado, active, id_usuario, pageable));

    }

    @Operation(description = "Operación encargada de obtener detalles de un cultivo",
            method = "GET")
    @GetMapping(value = "/{id}")
    public ResponseEntity<CultivoDtoResp> getCultivoByID(
            @PathVariable(name = "id", required = true) Long id
    ) {

        return ResponseEntity
                .ok()
                .body(cultivoAdminService.getCultivoPorId(id));
    }

}
