/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONTROLLERS.MARCA_PRODUCTO;

import com.nexus.demo.DTOS.GLOBAL.BasicResponseDto;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.MARCA_PRODUCTO.MarcaProductoAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.MARCA_PRODUCTO.MarcaProductoAdminDtoResp;
import com.nexus.demo.SERVICES.MARCA_PRODUCTO.IMarcaProductoAdminService;
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
@Tag(name = "Administración de Marca de Productos",
        description = "Módulo encargado de gestionar las distintas operaciones administrativas respecto a las marcas.")
@RequestMapping(value = "/api/v1/marca-productos/admin")
@RestController
public class MarcaProductoAdminController {

    private IMarcaProductoAdminService marcaProductoAdminService;

    @Autowired
    public MarcaProductoAdminController(IMarcaProductoAdminService marcaProductoAdminService) {
        this.marcaProductoAdminService = marcaProductoAdminService;
    }

    @Operation(description = "Operación encargada de crear una marca de producto en el sistema.",
            method = "POST")
    @PostMapping
    public ResponseEntity<BasicResponseDto> create(
            @Valid
            @RequestBody(required = true) MarcaProductoAdminDtoReq marcaProductoAdminDtoReq
    ) {

        marcaProductoAdminService.create(marcaProductoAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("Se ha creado la marca con exito"));
    }

    @Operation(description = "Operación encargada de editar una marca de producto a traves de su ID",
            method = "PUT")
    @PutMapping(value = "/{id}")
    public ResponseEntity<BasicResponseDto> update(
            @PathVariable(name = "id", required = true) Long id,
            @Valid
            @RequestBody(required = true) MarcaProductoAdminDtoReq marcaProductoAdminDtoReq
    ) {

        marcaProductoAdminService.update(id, marcaProductoAdminDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("Se ha editado con exito la marca del producto."));

    }

    @Operation(description = "Operación encargada de obtner todad las marcas que se encuentran en el sistema segun el filtro",
            method = "GET")
    @GetMapping()
    public ResponseEntity<PageResponse<MarcaProductoAdminDtoResp>> getAll(
            @RequestParam(name = "nomnre", required = false) String nombre,
            @RequestParam(name = "delete", required = false) Boolean delete,
            Pageable pageable
    ) {

        return ResponseEntity
                .ok()
                .body(marcaProductoAdminService.getAll(nombre, delete, pageable));
    }

    @Operation(description = "Operación encargada de obtener una marca de producto por su id",
            method = "GET")
    @GetMapping(value = "/{id}")
    public ResponseEntity<MarcaProductoAdminDtoResp> getById(@PathVariable(name = "id", required = true) Long id) {

        return ResponseEntity
                .ok()
                .body(marcaProductoAdminService.getByID(id));
    }

}
