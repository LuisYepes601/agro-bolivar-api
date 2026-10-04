/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.ESTADO_CULTIVO;

import com.nexus.biblioNepo.UTILS.PageResponseUtils;
import com.nexus.demo.AuditableUtils;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.ESTADO_CULTIVO.EstadoCultivoAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.ESTACION_CULTIVO.EstacionCultivoAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.ESTACION_CULTIVO.EstadoCultivoAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.ESTADO_CULTIVO.EstadoCultivoDetailsDtoResp;
import com.nexus.demo.DatoNoExistenteEcxeption;
import com.nexus.demo.DatoYaExistenteException;
import com.nexus.demo.ENTITIES.EstacionCultivo;
import com.nexus.demo.ENTITIES.EstadoCultivo;
import com.nexus.demo.NoDatosQueMostrarExecption;
import com.nexus.demo.REPOSITORY.EstadoCultivoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author luis
 */
@Service
public class EstadoCultivoAdminService implements IEstadoCultivoAdminService {

    private EstadoCultivoRepository estadoCultivoRepository;

    @Autowired
    public EstadoCultivoAdminService(EstadoCultivoRepository estadoCultivoRepository) {
        this.estadoCultivoRepository = estadoCultivoRepository;
    }

    @Caching(
            evict = {
                @CacheEvict(value = "estados_cultivo_admin", allEntries = true),
                @CacheEvict(value = "estados_cultivos", allEntries = true)
            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public EstadoCultivo create(EstadoCultivoAdminDtoReq estadoCultivoAdminDtoReq) {

        Optional<EstadoCultivo> existe = estadoCultivoRepository
                .existeAndEstaActivo(estadoCultivoAdminDtoReq.getNombre().trim());

        if (existe.isPresent()) {

            throw new DatoYaExistenteException("El estado de cultivo ya existe en el sistema y se encuentra activo");
        }

        EstadoCultivo estadoCultivo = new EstadoCultivo();

        llenarDatos(estadoCultivo, estadoCultivoAdminDtoReq);

        AuditableUtils.create(estadoCultivo, "prueba", "prueba");

        return estadoCultivoRepository.save(estadoCultivo);

    }

    public void llenarDatos(EstadoCultivo estadoCultivo, EstadoCultivoAdminDtoReq estadoCultivoAdminDtoReq) {

        estadoCultivo.setNombre(estadoCultivoAdminDtoReq.getNombre().trim());

        if (estadoCultivoAdminDtoReq.getDescripcion() != null) {

            estadoCultivo.setDescripcion(estadoCultivoAdminDtoReq.getDescripcion().trim());
        }
    }

    @Caching(
            evict = {
                @CacheEvict(value = "estados_cultivo_admin", allEntries = true),
                @CacheEvict(value = "estados_cultivos", allEntries = true),
                @CacheEvict(value = "estado_cultivo_detail", key = "#id")
            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public EstadoCultivo update(Long id, EstadoCultivoAdminDtoReq estadoCultivoAdminDtoReq) {

        EstadoCultivo estadoCultivo = estadoCultivoRepository.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El estado del cultivo no existe en el sistema"));

        Optional<EstadoCultivo> existe = estadoCultivoRepository
                .existeAndEstaActivo(estadoCultivoAdminDtoReq.getNombre().trim());

        if (existe.isPresent()) {

            if (existe.get().getId() != estadoCultivo.getId()) {

                throw new DatoYaExistenteException("El estado del cultivo ya existe en el sistema");
            }
        }

        llenarDatos(estadoCultivo, estadoCultivoAdminDtoReq);

        AuditableUtils.update(estadoCultivo, "prueba", "prueba");

        return estadoCultivoRepository.save(estadoCultivo);
    }

    @Cacheable(value = "estados_cultivo_admin")
    @Transactional(readOnly = true)
    @Override
    public PageResponse<EstadoCultivoAdminDtoResp> getAll(String nombre, Boolean active, Pageable pageable) {

        Page<EstadoCultivoAdminDtoResp> page = estadoCultivoRepository.getAllAdmin(nombre, active, pageable);

        if (page.isEmpty()) {
            throw new NoDatosQueMostrarExecption("No hay estados de cultivo que mostrar");
        }

        return PageResponseUtils.CreatePageReponse(page);

    }

    @Cacheable(value = "estado_cultivo_detail", key = "#id")
    @Transactional(readOnly = true)
    @Override
    public EstadoCultivoDetailsDtoResp getDetailsById(Long id) {
        
        return estadoCultivoRepository.getDetailsByID(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El estado de cultvo no existe en el sistema"));

    }
    
    

}
