/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONTROLLERS.TIPO_SUELO;

import com.nexus.demo.DTOS.GLOBAL.BasicResponseDto;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.TIPO_SUELO.TipoSueloAdminDtoReq;
import com.nexus.demo.DTOS.REQUEST.TIPO_SUELO.TipoSueloBasicDtoReq;
import com.nexus.demo.DTOS.RESPONSE.TIPO_SUELO.TipoSueloAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.TIPO_SUELO.TipoSueloDetailsDtoResp;
import com.nexus.demo.SERVICES.TIPO_SUELO.ITipoSueloAdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@Tag(name = "Administración de Tipos de Suelo",
        description = "Módulo encargado de gestionar las operaciones administrativas de los tipos"
        + "de suelos del sistema.")
@RequestMapping(value = "/api/v1/tipos-suelos/admin")
@RestController
public class TipoSueloAdminController {

    private ITipoSueloAdminService tipoSueloAdminService;

    @Autowired
    public TipoSueloAdminController(ITipoSueloAdminService tipoSueloAdminService) {
        this.tipoSueloAdminService = tipoSueloAdminService;
    }

    @Operation(description = "Operación encargada de crear un tipo de suelo en el sistema",
            method = "POST")
    @PostMapping()
    public ResponseEntity<BasicResponseDto> create(
            @Valid
            @RequestBody(required = true) TipoSueloAdminDtoReq tipoSueloAdminDtoReq
    ) {
        tipoSueloAdminService.create(tipoSueloAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("Tipo de suelo creado con exito"));

    }

    @Operation(description = "Operación enccaragada de editar los datos basicos de un tipo de suelo",
            method = "PUT")
    @PutMapping(value = "/{id}")
    public ResponseEntity<BasicResponseDto> updateDatosBasicosById(
            @PathVariable(
                    name = "id",
                    required = true) Long id,
            @Valid
            @RequestBody(required = true) TipoSueloBasicDtoReq tipoSueloBaicDtoReq
    ) {

        tipoSueloAdminService.editarDatosBasicos(id, tipoSueloBaicDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("Se han editado con exito lso dtaos basicos de el tipo de suelo"));

    }

    @Operation(description = "Operación encargada de mostrar los tipos de suelos que existen en el sistema.",
            method = "GET")
    @GetMapping()
    public ResponseEntity<PageResponse<TipoSueloAdminDtoResp>> getAll(
            @RequestParam(
                    name = "nombre",
                    required = false) String nombre,
            @RequestParam(
                    name = "color",
                    required = false) String color,
            @RequestParam(
                    name = "active",
                    required = false) Boolean active,
            Pageable pageable
    ) {

        return ResponseEntity
                .ok()
                .body(tipoSueloAdminService.getAll(nombre, color, active, pageable));

    }

    @Operation(description = "Operación encargada de mostrar los detalles de un tipo de suelo",
            method = "GET")
    @GetMapping(value = "/{id}/details")
    public ResponseEntity<TipoSueloDetailsDtoResp> getDetailsById(
            @PathVariable(
                    name = "id",
                    required = true) Long id) {

        return ResponseEntity
                .ok()
                .body(tipoSueloAdminService.getDetailsById(id));
    }

    @Operation(description = "Operación encargada de eliminar una textura asociada a un tipo de suelo",
            method = "DELETE")
    @DeleteMapping(value = "/textura-suelo")
    public ResponseEntity<BasicResponseDto> deleteTexturaDeTipoSueloAsociado(
            @RequestParam(
                    name = "id_tipo_suelo",
                    required = true) Long id_tipo_suelo,
            @RequestParam(
                    name = "id_textura",
                    required = true) Long id_textura
    ) {

        tipoSueloAdminService.eliminarTexturaDeTipoSuelo(id_textura, id_tipo_suelo);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("La textura ha sido eliminado"));
    }

}
