/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.TIPO_PLANTAS;

import com.nexus.biblioNepo.UTILS.PageResponseUtils;
import com.nexus.demo.AuditableUtils;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.TIPO_PLANTA.TipoPlantaAdminDtoReq;
import com.nexus.demo.DTOS.REQUEST.TIPO_PLANTA.TipoPlantaDetailsDtoResp;
import com.nexus.demo.DTOS.RESPONSE.TIPO_PLANTA.TipoPlantaAdminDtoResp;
import com.nexus.demo.DatoNoExistenteEcxeption;
import com.nexus.demo.DatoYaExistenteException;
import com.nexus.demo.ENTITIES.Planta;
import com.nexus.demo.ENTITIES.TipoPlanta;
import com.nexus.demo.NoDatosQueMostrarExecption;
import com.nexus.demo.REPOSITORY.TipoPlantaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author luis
 */
@Service
public class TipoPlantaAdminService implements ITipoPlantaAdminService {

    private TipoPlantaRepository tipoPlantaRepo;

    @Autowired
    public TipoPlantaAdminService(TipoPlantaRepository tipoPlantaRepo) {
        this.tipoPlantaRepo = tipoPlantaRepo;
    }

    @Caching(evict = {
        @CacheEvict(value = "tipo_plantas_admin", allEntries = true),
        @CacheEvict(value = "tipo_plantas", allEntries = true)

    })
    @Transactional(rollbackFor = Exception.class)
    @Override
    public TipoPlanta create(TipoPlantaAdminDtoReq tipoPlantaAdminDtoReq) {

        Optional<TipoPlanta> existeYEstaActivo = tipoPlantaRepo.
                existeYEstaActivo(tipoPlantaAdminDtoReq.getNombre().trim());

        if (existeYEstaActivo.isPresent()) {

            throw new DatoYaExistenteException("El tipo de planta ya se encuentra resgistrado en el sistema");
        }

        TipoPlanta tipoPlanta = new TipoPlanta();

        tipoPlanta.setNombre(tipoPlantaAdminDtoReq.getNombre().trim());

        AuditableUtils.create(tipoPlanta, "prueba", "prueba");

        return tipoPlantaRepo.save(tipoPlanta);

    }

    @Caching(evict = {
        @CacheEvict(value = "tipo_plantas_admin", allEntries = true),
        @CacheEvict(value = "tipo_plantas", allEntries = true),
        @CacheEvict(value = "tipo_planta-detail", key = "#id")

    })
    @Transactional(rollbackFor = Exception.class)
    @Override
    public TipoPlanta updateById(Long id, TipoPlantaAdminDtoReq tipoPlantaAdminDtoReq) {

        TipoPlanta tipoPlanta = tipoPlantaRepo.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El tipo de planta no existe en el sistema"));

        Optional<TipoPlanta> existe = tipoPlantaRepo.existeYEstaActivo(tipoPlantaAdminDtoReq.getNombre().trim());

        if (existe.isPresent()) {

            if (existe.get().getId() != tipoPlanta.getId()) {

                throw new DatoYaExistenteException("El tipo de planta ya existe en el sistema");

            }
        }

        tipoPlanta.setNombre(tipoPlantaAdminDtoReq.getNombre().trim());

        if (tipoPlantaAdminDtoReq.getDescripcion() != null) {

            tipoPlanta.setDescripcion(tipoPlantaAdminDtoReq.getDescripcion().trim());
        }

        return tipoPlantaRepo.save(tipoPlanta);
    }

    @Caching(
            cacheable = {
                @Cacheable(value = "tipo_plantas_admin"),
                @Cacheable(value = "tipo_plantas")

            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public PageResponse<TipoPlantaAdminDtoResp> getAllAdmin(String nombre, Boolean is_delete, Pageable pageable) {

        Page<TipoPlantaAdminDtoResp> page = tipoPlantaRepo.getAllAdmin(nombre, is_delete, pageable);

        if (page.isEmpty()) {
            throw new NoDatosQueMostrarExecption("No hay tipos de plantas que mostrar");
        }

        return PageResponseUtils.CreatePageReponse(page);

    }

    @Cacheable(value = "tipo_planta-detail", key = "#id")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public TipoPlantaDetailsDtoResp getDetailsById(Long id) {

        return tipoPlantaRepo.getDetailsByID(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El tipo de planta no existe en el sistema"));

    }

}
