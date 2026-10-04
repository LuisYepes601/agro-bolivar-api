/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.CONTROLLERS.DASHBOARD;

import com.nexus.demo.DTOS.RESPONSE.DASHBOARD.DashBoardUserBasicDtoResp;
import com.nexus.demo.SERVICES.DASHBOARD.IDashBoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author luis
 */
@Tag(name = "Dashboard")
@RequestMapping(value = "/api/v1/dashboard")
@RestController
public class DashBoardController {
    
    
    private IDashBoardService dashBoardService;

    @Autowired
    public DashBoardController(IDashBoardService dashBoardService) {
        this.dashBoardService = dashBoardService;
    }
    
    
    @Operation(description = "Operación encargada de cargar info basica de usuario paar el dashboard",
            method = "GET")
    @GetMapping(value = "/{id}/data-basic-user-home")
    public ResponseEntity<DashBoardUserBasicDtoResp>getDataBasicUserHome(
    
            @PathVariable(name = "id", required = true)Long id
    ){
        return ResponseEntity
                .ok()
                .body(dashBoardService.getDatosBasicosUsuarioHomeDashBoard(id));
        
    }
    
        
}
