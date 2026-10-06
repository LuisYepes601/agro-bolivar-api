/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.SERVICES.PLANTAS;

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
import com.nexus.demo.ENTITIES.GeneroPlanta;
import com.nexus.demo.ENTITIES.Planta;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author luis
 */
public interface IPlantaAdminService {

    public Planta create(PlantaDtoReq plantaDtoReq, MultipartFile fotoPlanta);

    public Planta editarDatosBasicos(Long id, PlantaBasicDtoReq plantaBasicDtoReq);

    public Planta editarClasificacion(Long id, ClasificacionPlantaDtoReq clasificacionPlantaDtoReq);

    public Planta editarCiclo(Long id, CicloPlantaDtoReq cicloPlantaDtoReq);

    public Planta editarCondicionClimatica(Long id, CondicionClimaticaPlantaDtoReq condicionClimaticaPlantaDtoReq);

    public Planta editarCondicionesTerreno(Long id, CondicionesTerrenoPlantaDtoReq condicionesTerrenoPlantaDtoReq);

    public Planta editarRiego(Long id, RiegoPlantaDtoReq riegoPlantaDtoReq);

    public Planta ediatarFotoPlanta(Long id, MultipartFile foto);

    public PageResponse<PlantaDatosBasicAdminDtoResp> getAll(String nombre, Boolean active, Long id_especie,
            Long id_tipo, Long id_familia, Long id_estacion_produccion, Pageable pageable);
    
    public PlantaEditarAdminDtoResp getPlantaByID(Long id);
    
    public PageResponse<PlantaDtoRespMenu>getAllForMenuBar(Pageable pageable);
}
