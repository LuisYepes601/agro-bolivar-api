/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.SERVICES.PLANTAS;

import com.nexus.demo.DTOS.REQUEST.PLANTA.PlantaDtoReq;
import com.nexus.demo.ENTITIES.Planta;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author luis
 */
public interface IPlantaAdminService {

    public Planta create(PlantaDtoReq plantaDtoReq, MultipartFile fotoPlanta);
}
