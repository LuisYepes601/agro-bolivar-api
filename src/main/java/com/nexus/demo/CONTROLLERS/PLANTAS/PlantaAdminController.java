/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONTROLLERS.PLANTAS;

import com.nexus.demo.DTOS.GLOBAL.BasicResponseDto;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.PLANTA.CicloPlantaDtoReq;
import com.nexus.demo.DTOS.REQUEST.PLANTA.ClasificacionPlantaDtoReq;
import com.nexus.demo.DTOS.REQUEST.PLANTA.CondicionClimaticaPlantaDtoReq;
import com.nexus.demo.DTOS.REQUEST.PLANTA.CondicionesTerrenoPlantaDtoReq;
import com.nexus.demo.DTOS.REQUEST.PLANTA.PlantaBasicDtoReq;
import com.nexus.demo.DTOS.REQUEST.PLANTA.PlantaDtoReq;
import com.nexus.demo.DTOS.REQUEST.PLANTA.RiegoPlantaDtoReq;
import com.nexus.demo.DTOS.RESPONSE.PLANTA.PlantaDatosBasicAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.PLANTA.PlantaDtoRespMenu;
import com.nexus.demo.DTOS.RESPONSE.PLANTA.PlantaEditarAdminDtoResp;
import com.nexus.demo.SERVICES.PLANTAS.IPlantaAdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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

    @Operation(description = "Operación encargada de editar los datos basicos de una planta",
            method = "PUT")
    @PutMapping(value = "/{id}/datos-basicos")
    public ResponseEntity<BasicResponseDto> editarDatosBasicos(
            @Valid
            @RequestBody(required = true) PlantaBasicDtoReq plantaBasicDtoReq,
            @PathVariable(name = "id", required = true) Long id) {

        plantaAdminService.editarDatosBasicos(id, plantaBasicDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto());
    }

    @Operation(description = "Operación encargada de editar los datos de clasificación de una planta",
            method = "PUT")
    @PutMapping(value = "/{id}/clasificacion")
    public ResponseEntity<BasicResponseDto> editarDatosClasificacion(
            @RequestPart(name = "id", required = true) Long id,
            @Valid()
            @RequestBody(required = true) ClasificacionPlantaDtoReq clasificacionPlantaDtoReq
    ) {

        plantaAdminService.editarClasificacion(id, clasificacionPlantaDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("Se ha editado correctamente la clasificación de la planta"));

    }

    @Operation(description = "Operación encargada de editar lsos ciclos de planta del sistema",
            method = "PUT")
    @PutMapping(value = "/{id}/ciclos")
    public ResponseEntity<BasicResponseDto> editarCiclosPlanta(
            @PathVariable(name = "id", required = true) Long id,
            @Valid
            @RequestBody(required = true) CicloPlantaDtoReq cicloPlantaDtoReq
    ) {

        plantaAdminService.editarCiclo(id, cicloPlantaDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("El ciclo de la planta ha sido editado correctamente"));

    }

    @Operation(description = "Operación encargada de editar las condiciones climaticas de una planta",
            method = "PUT")
    @PutMapping(value = "/{id}/condiciones-climaticas")
    public ResponseEntity<BasicResponseDto> editarCondicionesClimaticas(
            @RequestParam(name = "id", required = true) Long id,
            @Valid
            @RequestBody(required = true) CondicionClimaticaPlantaDtoReq condicionClimaticaPlantaDtoReq
    ) {

        plantaAdminService.editarCondicionClimatica(id, condicionClimaticaPlantaDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("La condición climatica de la planta se ha editado con exito en el sistema"));
    }

    @Operation(description = "Operación encargada de editar las condiciones de terrenos",
            method = "PUT")
    @PutMapping(value = "/{id}/condiciones-terreno")
    public ResponseEntity<BasicResponseDto> editarCondicionesDeTerreno(
            @PathVariable(name = "id", required = true) Long id,
            @Valid
            @RequestBody(required = true) CondicionesTerrenoPlantaDtoReq condicionesTerrenoPlantaDtoReq
    ) {

        plantaAdminService.editarCondicionesTerreno(id, condicionesTerrenoPlantaDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("Se ha editado las condiciones d eterreno de la planta correctamente."));
    }

    @Operation(description = "Operación encargada de editar la información de riego de una planta",
            method = "PUT")
    @PutMapping(value = "/{id}/riego")
    public ResponseEntity<BasicResponseDto> editarRiego(
            @PathVariable(name = "id", required = true) Long id,
            @Valid
            @RequestBody(required = true) RiegoPlantaDtoReq riegoPlantaDtoReq
    ) {

        plantaAdminService.editarRiego(id, riegoPlantaDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("Se ha editado con exito la información de riego"));
    }

    @Operation(description = "Operación encargada de actulizar la foto de una planta",
            method = "PUT")
    @PutMapping(value = "/{id}/foto-planta")
    public ResponseEntity<BasicResponseDto> editarFotoPlanta(
            @PathVariable(name = "id", required = true) Long id,
            @RequestPart(name = "fotoPlanta", required = true) MultipartFile fotoPlanta
    ) {

        plantaAdminService.ediatarFotoPlanta(id, fotoPlanta);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("Se ha ediatdo la foto de la planta con exito."));

    }

    @Operation(description = "Operación encarga de mostrar las plantas del sistema segun su filtro",
            method = "GET")
    @GetMapping()
    public ResponseEntity<PageResponse<PlantaDatosBasicAdminDtoResp>> getAll(
            @RequestParam(
                    name = "nombre",
                    required = false) String nombre,
            @RequestParam(
                    name = "active",
                    required = false) Boolean active,
            @RequestParam(required = false) Long id_especie,
            @RequestParam(required = false) Long id_tipo,
            @RequestParam(required = false) Long id_familia,
            @RequestParam(required = false) Long id_estacion_produccion,
            Pageable pageable
    ) {

        return ResponseEntity
                .ok()
                .body(plantaAdminService.getAll(nombre, active, id_especie, id_tipo, id_familia,
                        id_estacion_produccion, pageable));
    }

    @Operation(description = "Operación encargada de obtener una planta por su ID ",
            method = "GET")
    @GetMapping(value = "/{id}")
    public ResponseEntity<PlantaEditarAdminDtoResp> getPlantaById(
            @PathVariable(name = "id", required = true) Long id) {

        return ResponseEntity
                .ok()
                .body(plantaAdminService.getPlantaByID(id));

    }

    @Operation(description = "Operación encargada de de obtener datos basicos de las plantas del sistema",
            method = "GET")
    @GetMapping(value = "/basic")
    public ResponseEntity<PageResponse<PlantaDtoRespMenu>>getDatosBasic(Pageable pageable){
        
        return ResponseEntity
                .ok()
                .body(plantaAdminService.getAllForMenuBar(pageable));
        
    }

}
