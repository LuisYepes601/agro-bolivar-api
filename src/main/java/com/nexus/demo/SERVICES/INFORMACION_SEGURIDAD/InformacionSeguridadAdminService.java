/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.INFORMACION_SEGURIDAD;

import com.nexus.demo.AuditableUtils;
import com.nexus.demo.DTOS.REQUEST.INFORMACION_SEGURIDAD.InformacionSeguridadDtoReq;
import com.nexus.demo.DTOS.RESPONSE.INFORMACION_SEGURIDAD.InformacionSeguridadDtoResp;
import com.nexus.demo.DatoNoExistenteEcxeption;
import com.nexus.demo.ENTITIES.InformacionSeguridad;
import com.nexus.demo.REPOSITORY.InformacionSeguridadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author luis
 */
@Service
public class InformacionSeguridadAdminService implements IInformacionSeguridadService {

    private InformacionSeguridadRepository informacionSeguridadRepository;

    @Autowired
    public InformacionSeguridadAdminService(InformacionSeguridadRepository informacionSeguridadRepository) {
        this.informacionSeguridadRepository = informacionSeguridadRepository;
    }

    @Caching(
            evict = {
                @CacheEvict(value = "info_seguridades_admin", allEntries = true)
            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public InformacionSeguridad create(InformacionSeguridadDtoReq informacionSeguridadDtoReq) {

        InformacionSeguridad informacionSeguridad = new InformacionSeguridad();

        llenarDatos(informacionSeguridad, informacionSeguridadDtoReq);

        AuditableUtils.create(informacionSeguridad, "prueba", "prueba");

        return informacionSeguridadRepository.save(informacionSeguridad);
    }

    public void llenarDatos(InformacionSeguridad informacionSeguridad, InformacionSeguridadDtoReq informacionSeguridadDtoReq) {

        informacionSeguridad.setAdvertencias(informacionSeguridadDtoReq.getAdvertencias().trim());

        if (informacionSeguridadDtoReq.getDescripcion() != null) {
            informacionSeguridad.setDescripcion(informacionSeguridadDtoReq.getDescripcion().trim());

        }

        informacionSeguridad.setEsCorrosivo(informacionSeguridadDtoReq.getEsCorrosivo());
        informacionSeguridad.setEsInflamable(informacionSeguridadDtoReq.getEsInflamable());
        informacionSeguridad.setEsPeligroso(informacionSeguridadDtoReq.getEsPeligroso());
        informacionSeguridad.setEsToxico(informacionSeguridadDtoReq.getEsToxico());
        informacionSeguridad.setInstruccionesAlmacenamiento(informacionSeguridadDtoReq.getInstruccionesAlmacenamiento().trim());
        informacionSeguridad.setPrecauciones(informacionSeguridadDtoReq.getPrecauciones().trim());
        informacionSeguridad.setRequiereEquipoProteccion(informacionSeguridadDtoReq.getRequiereEquipoProteccion());
        informacionSeguridad.setRequiereManejoEspecial(informacionSeguridadDtoReq.getRequiereManejoEspecial());
    }

    @Caching(
            evict = {
                @CacheEvict(value = "info_seguridades_admin", allEntries = true)
            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public InformacionSeguridad update(Long id, InformacionSeguridadDtoReq informacionSeguridadDtoReq) {

        InformacionSeguridad informacionSeguridad = informacionSeguridadRepository.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("La información de seguridad no existe en el sistema."));

        llenarDatos(informacionSeguridad, informacionSeguridadDtoReq);

        AuditableUtils.update(informacionSeguridad, "prueba", "prueba");

        return informacionSeguridadRepository.save(informacionSeguridad);

    }

    @Transactional(readOnly = true)
    @Override
    public InformacionSeguridadDtoResp getInfoSeguridadProducto(Long id_producto) {

        return informacionSeguridadRepository.obtenerByIdProducto(id_producto)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El producto no existe en el sistema"));
    }
    
    

}
