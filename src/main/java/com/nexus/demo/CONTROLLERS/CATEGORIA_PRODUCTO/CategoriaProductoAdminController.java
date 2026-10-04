/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONTROLLERS.CATEGORIA_PRODUCTO;

import com.nexus.demo.DTOS.GLOBAL.BasicResponseDto;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.CATEGORIA_PRODUCTO.CategoriaAdminProdDtoReq;
import com.nexus.demo.DTOS.RESPONSE.CATEGORIA_PRODUCTO.CategoriaProductoAdminDtoResp;
import com.nexus.demo.SERVICES.CATEGORIA_PRODUCTO.ICategoriaProductoAdminService;
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
@Tag(name = "Administración de categorías de prodcutos",
        description = "Módulo encargado de gestionar las distintas operaciones sobre las categorias de productos")
@RequestMapping(value = "/api/v1/categoria-producto/admin")
@RestController
public class CategoriaProductoAdminController {

    private ICategoriaProductoAdminService categoriaProductoAdminService;

    @Autowired
    public CategoriaProductoAdminController(ICategoriaProductoAdminService categoriaProductoAdminService) {
        this.categoriaProductoAdminService = categoriaProductoAdminService;
    }

    @Operation(description = "Operación encargada de crear una categoria de producto al sistema",
            method = "POST")
    @PostMapping()
    public ResponseEntity<BasicResponseDto> create(
            @Valid
            @RequestBody(required = true) CategoriaAdminProdDtoReq categoriaAdminProdDtoReq
    ) {

        categoriaProductoAdminService.create(categoriaAdminProdDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("La categoria de producto se ha creado con exito al sistema"));
    }

    @Operation(description = "Operación encargada de editar una categoria existente en el sistema.",
            method = "PUT")
    @PutMapping(value = "/{id}")
    public ResponseEntity<BasicResponseDto> updateById(
            @PathVariable(name = "id", required = true) Long id,
            @Valid
            @RequestBody(required = true) CategoriaAdminProdDtoReq categoriaAdminProdDtoReq
    ) {

        categoriaProductoAdminService.updateById(id, categoriaAdminProdDtoReq);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("La categoria se ha editado con exito.."));

    }

    @Operation(description = "Operación encargada de obtener las categorias de productos segun su filtro",
            method = "GET")
    @GetMapping
    public ResponseEntity<PageResponse<CategoriaProductoAdminDtoResp>> getAll(
            @RequestParam(name = "nombre", required = false) String nombre,
            @RequestParam(name = "delete", required = false) Boolean delete,
            Pageable pageable
    ) {

        return ResponseEntity
                .ok()
                .body(categoriaProductoAdminService.getAll(nombre, delete, pageable));
    }

    @Operation(description = "Operación encgarda de traer una categoria por su id",
            method = "GET")
    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaProductoAdminDtoResp> getCategoriaById(
            @PathVariable(name = "id", required = true) Long id
    ) {

        return ResponseEntity
                .ok()
                .body(categoriaProductoAdminService.getCategoriaById(id));
    }

}
