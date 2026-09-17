/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.ESTACION_CULTIVO;

import com.nexus.biblioNepo.UTILS.PageResponseUtils;
import com.nexus.demo.AuditableUtils;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.ESTACION_CULTIVO.EstacionCultivoAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.ESTACION_CULTIVO.EstacionCultivoAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.ESTACION_CULTIVO.EstacionCultivoDetailsDtoResp;
import com.nexus.demo.DatoNoExistenteEcxeption;
import com.nexus.demo.DatoYaExistenteException;
import com.nexus.demo.ENTITIES.EstacionCultivo;
import com.nexus.demo.GLOBALEXCEPTIONHANDLER.exceptions.DatoInvalidoEcxeption;
import com.nexus.demo.NoDatosQueMostrarExecption;
import com.nexus.demo.REPOSITORY.EstacionCultivoRepository;
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
public class EstacionCultivoService implements IEstacionCultivoAdminService {

    private EstacionCultivoRepository estacionCultivoRepository;

    @Autowired
    public EstacionCultivoService(EstacionCultivoRepository estacionCultivoRepository) {
        this.estacionCultivoRepository = estacionCultivoRepository;
    }

    @Caching(evict = {
        @CacheEvict(value = "estacion_cultivos_admin", allEntries = true),
        @CacheEvict(value = "estacion_cultivos", allEntries = true)
    })
    @Transactional(rollbackFor = Exception.class)
    @Override
    public EstacionCultivo create(EstacionCultivoAdminDtoReq estacionCultivoAdminDtoReq) {

        Optional<EstacionCultivo> existe = estacionCultivoRepository.existeYEstaActivo(estacionCultivoAdminDtoReq.getNombre().trim());

        if (existe.isPresent()) {

            throw new DatoYaExistenteException("La estación de cultivo ya existe en el sistema");
        }

        EstacionCultivo estacionCultivo = new EstacionCultivo();

        estacionCultivo.setNombre(estacionCultivoAdminDtoReq.getNombre().trim());

        if (estacionCultivoAdminDtoReq.getDescripcion() != null) {

            estacionCultivo.setDescripcion(estacionCultivoAdminDtoReq.getDescripcion().trim());
        }

        if (estacionCultivoAdminDtoReq.getFechaInicio().isAfter(estacionCultivoAdminDtoReq.getFechaFin())
                || estacionCultivoAdminDtoReq.getFechaInicio().isEqual(estacionCultivoAdminDtoReq.getFechaFin())) {

            throw new DatoInvalidoEcxeption("La fecha de inicio no puede ser mayor o igual que la fecha de fin");
        }

        estacionCultivo.setFechaInicio(estacionCultivoAdminDtoReq.getFechaInicio());
        estacionCultivo.setFechaFin(estacionCultivoAdminDtoReq.getFechaFin());

        AuditableUtils.create(estacionCultivo, "prueba", "prueba");

        return estacionCultivoRepository.save(estacionCultivo);

    }

    @Caching(evict = {
        @CacheEvict(value = "estacion_cultivos_admin", allEntries = true),
        @CacheEvict(value = "estacion_cultivos", allEntries = true),
        @CacheEvict(value = "estacion_cultivo_detail", key = "#id")
    })
    @Transactional(rollbackFor = Exception.class)
    @Override
    public EstacionCultivo updateByID(Long id, EstacionCultivoAdminDtoReq estacionCultivoAdminDtoReq) {

        EstacionCultivo estacionCultivo = estacionCultivoRepository.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("La estación no existe en el sistema"));

        Optional<EstacionCultivo> existe = estacionCultivoRepository.existeYEstaActivo(estacionCultivoAdminDtoReq.getNombre().trim());

        if (existe.isPresent()) {

            if (existe.get().getId() != estacionCultivo.getId()) {

                throw new DatoYaExistenteException("La estación ya existe en el sistema");
            }
        }

        estacionCultivo.setNombre(estacionCultivoAdminDtoReq.getNombre().trim());

        if (estacionCultivoAdminDtoReq.getDescripcion() != null) {

            estacionCultivo.setDescripcion(estacionCultivoAdminDtoReq.getDescripcion().trim());
        }

        if (estacionCultivoAdminDtoReq.getFechaInicio().isAfter(estacionCultivoAdminDtoReq.getFechaFin())
                || estacionCultivoAdminDtoReq.getFechaInicio().isEqual(estacionCultivoAdminDtoReq.getFechaFin())) {

            throw new DatoInvalidoEcxeption("La fecha de inicio no puede ser mayor o igual que la fecha de fin");
        }

        estacionCultivo.setFechaInicio(estacionCultivoAdminDtoReq.getFechaInicio());
        estacionCultivo.setFechaFin(estacionCultivoAdminDtoReq.getFechaFin());

        AuditableUtils.update(estacionCultivo, "prueba", "prueba");

        return estacionCultivoRepository.save(estacionCultivo);

    }

    @Caching(
            cacheable = {
                @Cacheable(value = "estacion_cultivos_admin"),
                @Cacheable(value = "estacion_cultivos")
            }
    )
    @Transactional(readOnly = true)
    @Override
    public PageResponse<EstacionCultivoAdminDtoResp> getAllAdmin(String nombre, Boolean active, Pageable pageable) {

        Page<EstacionCultivoAdminDtoResp> page = estacionCultivoRepository.getAllAdmin(nombre, active, pageable);

        if (page.isEmpty()) {
            throw new NoDatosQueMostrarExecption("No hay estaiones que mostrar");
        }

        return PageResponseUtils.CreatePageReponse(page);
    }

    @Cacheable(value = "estacion_cultivo_detail", key = "#id")
    @Transactional(readOnly = true)
    @Override
    public EstacionCultivoDetailsDtoResp getDetailsByID(Long id) {

        return estacionCultivoRepository.getDetailsById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("La estación  de cultivo no existe en el sistema"));

    }

}
