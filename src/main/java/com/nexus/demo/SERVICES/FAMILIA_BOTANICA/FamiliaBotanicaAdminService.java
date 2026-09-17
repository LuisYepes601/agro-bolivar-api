/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.FAMILIA_BOTANICA;

import com.nexus.biblioNepo.UTILS.PageResponseUtils;
import com.nexus.demo.AuditableUtils;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.FAMILIA_BOTANICA.FamiliaBotanicaDtoReq;
import com.nexus.demo.DTOS.RESPONSE.FAMILIA_BOTANICA.FamiliaBotanicaAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.FAMILIA_BOTANICA.FamiliaBotanicaDetailsDtoResp;
import com.nexus.demo.DatoNoExistenteEcxeption;
import com.nexus.demo.DatoYaExistenteException;
import com.nexus.demo.ENTITIES.FamiliaBotanica;
import com.nexus.demo.NoDatosQueMostrarExecption;
import com.nexus.demo.REPOSITORY.FamiliaBotanicaRepository;
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
public class FamiliaBotanicaAdminService implements IFamiliaBotanicaAdminService {

    private FamiliaBotanicaRepository familiaBotanicaRepository;

    @Autowired
    public FamiliaBotanicaAdminService(FamiliaBotanicaRepository familiaBotanicaRepository) {
        this.familiaBotanicaRepository = familiaBotanicaRepository;
    }

    @Caching(evict = {
        @CacheEvict(value = "familias-botanicas-admin", allEntries = true),
        @CacheEvict(value = "familias-botanicas", allEntries = true)
    })
    @Transactional(rollbackFor = Exception.class)
    @Override
    public FamiliaBotanica create(FamiliaBotanicaDtoReq familiaBotanicaDtoReq) {

        Optional<FamiliaBotanica> existe = familiaBotanicaRepository
                .existeAndEstaActivo(familiaBotanicaDtoReq.getNombre().trim());

        if (existe.isPresent()) {

            throw new DatoYaExistenteException("La familia botanica ya existe en el sistema");
        }

        FamiliaBotanica familiaBotanica = new FamiliaBotanica();

        familiaBotanica.setNombre(familiaBotanicaDtoReq.getNombre().trim());

        if (familiaBotanicaDtoReq.getDescripcion() != null) {
            familiaBotanica.setDescripcion(familiaBotanicaDtoReq.getDescripcion().trim());

        }

        AuditableUtils.create(familiaBotanica, "prueba", "prueba");

        return familiaBotanicaRepository.save(familiaBotanica);
    }

    @Caching(evict = {
        @CacheEvict(value = "familias-botanicas-admin", allEntries = true),
        @CacheEvict(value = "familias-botanicas", allEntries = true),
        @CacheEvict(value = "familia-botanica-detail", key = "#id")
    })
    @Transactional(rollbackFor = Exception.class)
    @Override
    public FamiliaBotanica updateById(Long id, FamiliaBotanicaDtoReq familiaBotanicaDtoReq) {

        FamiliaBotanica familiaBotanica = familiaBotanicaRepository.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("La familia botanica no existe en el sistema"));

        Optional<FamiliaBotanica> existe
                = familiaBotanicaRepository.existeAndEstaActivo(familiaBotanicaDtoReq.getNombre().trim());

        if (existe.isPresent()) {

            if (existe.get().getId() != familiaBotanica.getId()) {

                throw new DatoYaExistenteException("La familia botanica ya existe en el sistema y se encuentra activa.");
            }
        }
        familiaBotanica.setNombre(familiaBotanicaDtoReq.getNombre().trim());

        if (familiaBotanicaDtoReq.getDescripcion() != null) {

            familiaBotanica.setDescripcion(familiaBotanicaDtoReq.getDescripcion().trim());
        }

        return familiaBotanicaRepository.save(familiaBotanica);

    }

    @Caching(
            cacheable = {
                @Cacheable(value = "familias-botanicas-admin")

            })
    @Transactional(readOnly = true)
    @Override
    public PageResponse<FamiliaBotanicaAdminDtoResp> getAll(String nombre, Boolean active, Pageable pageable) {

        Page<FamiliaBotanicaAdminDtoResp> page = familiaBotanicaRepository.getAllAdmin(nombre, active, pageable);

        if (page.isEmpty()) {
            throw new NoDatosQueMostrarExecption("No hay familias botanicas que mostrar");
        }

        return PageResponseUtils.CreatePageReponse(page);
    }

    @Cacheable(value = "familia-botanica-detail", key = "#id")
    @Transactional(readOnly = true)
    @Override
    public FamiliaBotanicaDetailsDtoResp getDetailsById(Long id) {

        return familiaBotanicaRepository.getDetailsByID(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("La famiilia botanica no existe en el sistema"));

    }

}
