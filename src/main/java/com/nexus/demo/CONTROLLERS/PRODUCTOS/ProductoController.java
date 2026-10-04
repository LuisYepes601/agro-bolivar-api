/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONTROLLERS.PRODUCTOS;

import com.nexus.demo.DTOS.GLOBAL.BasicResponseDto;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.PRODUCTO.ProductoAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.PRODUCTO.ProductoAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.PRODUCTO.ProductoDtoResp;
import com.nexus.demo.SERVICES.PRODUCTO.IProductoAdminService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author luis
 */
@Tag(name = "Productos",
        description = "Módulo encargado de las operaciones basicas de los produstcos del sistema")
@RequestMapping(value = "/api/v1/productos")
@RestController
public class ProductoController {

    private IProductoAdminService iProductoAdminService;

    @Autowired
    public ProductoController(IProductoAdminService iProductoAdminService) {
        this.iProductoAdminService = iProductoAdminService;
    }

    @Operation(description = "Operación encargada de crear un producto",
            method = "POST")
    @PostMapping()
    public ResponseEntity<BasicResponseDto> create(
            @RequestPart(name = "body", required = true) ProductoAdminDtoReq productoAdminDtoReq,
            @RequestPart(name = "fotoProducto", required = true) MultipartFile fotoProducto
    ) {

        iProductoAdminService.create(productoAdminDtoReq, fotoProducto);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("El producto ha sisdo creado con exito en el sistema"));
    }

    @Operation(description = "Operacion encaragda de mostrar los productos segun filtros escogidos",
            method = "GET")
    @GetMapping()
    public ResponseEntity<PageResponse<ProductoDtoResp>> getAll(
            @RequestParam(name = "nombre", required = false) String nombre,
            @RequestParam(name = "id_cat", required = false) Long id_cat,
            @RequestParam(name = "id_user", required = false) Long id_user,
            @RequestParam(name = "id_marca", required = false) Long id_marca,
            @RequestParam(name = "precio_min", required = false) Double precio_min,
            @RequestParam(name = "precio_max", required = false) Double precio_max,
            Pageable pageable) {

        return ResponseEntity
                .ok()
                .body(iProductoAdminService.getAllBasic(nombre, id_cat, id_user, id_marca, precio_min, precio_max, pageable));
    }

    @Operation(description = "Operación encargada de mostrar un producto al vendedor o admin",
            method = "GET")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductoAdminDtoResp> getProductoByID(@PathVariable(name = "id", required = true) Long id) {

        return ResponseEntity
                .ok()
                .body(iProductoAdminService.getProductoById(id));
    }

    @Operation(description = "Operación encrgda de editar datos de un producto",
            method = "PUT")
    @PutMapping(value = "/{id_producto}")
    public ResponseEntity<BasicResponseDto> updateById(
            @PathVariable(name = "id_producto", required = true) Long id_producto,
            @RequestPart(name = "body", required = true) ProductoAdminDtoReq productoAdminDtoReq,
            @RequestPart(name = "fotoProducto", required = false) MultipartFile fotoProducto
    ) {

        iProductoAdminService.updateById(id_producto, productoAdminDtoReq, fotoProducto);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("Se ha editado con exito el producto"));

    }
}
