/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.UNIDAD_PESO;

import com.nexus.biblioNepo.UTILS.PageResponseUtils;
import com.nexus.demo.AuditableUtils;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.UNIDAD_PESO.UnidadPesoAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.UNIDAD_PESO.UnidadPesoAdminDetailsDtoResp;
import com.nexus.demo.DTOS.RESPONSE.UNIDAD_PESO.UnidadPesoAdminDtoResp;
import com.nexus.demo.DatoNoExistenteEcxeption;
import com.nexus.demo.DatoYaExistenteException;
import com.nexus.demo.ENTITIES.UnidadPeso;
import com.nexus.demo.NoDatosQueMostrarExecption;
import com.nexus.demo.REPOSITORY.UnidadPesoRepository;
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
public class UnidadPesoAdminService implements IUnidadPesoAdminService {

    private UnidadPesoRepository unidadPesoRepository;

    @Autowired
    public UnidadPesoAdminService(UnidadPesoRepository unidadPesoRepository) {
        this.unidadPesoRepository = unidadPesoRepository;
    }

    @Caching(evict = {
        @CacheEvict(value = "unidades_peso_admin", allEntries = true),
        @CacheEvict(value = "unidades_peso", allEntries = true)

    })
    @Transactional(rollbackFor = Exception.class)
    @Override
    public UnidadPeso create(UnidadPesoAdminDtoReq unidadPesoAdminDtoReq) {

        Optional<UnidadPeso> existe = unidadPesoRepository
                .existeAndEstaActivo(unidadPesoAdminDtoReq.getNombre().trim());

        if (existe.isPresent()) {
            throw new DatoYaExistenteException("La unidad de peso ya existe en el sistema");
        }

        UnidadPeso unidadPeso = new UnidadPeso();

        llenarDatos(unidadPeso, unidadPesoAdminDtoReq);

        AuditableUtils.create(unidadPeso, "prueba", "prueba");

        return unidadPesoRepository.save(unidadPeso);
    }

    public void llenarDatos(UnidadPeso unidadPeso, UnidadPesoAdminDtoReq unidadPesoAdminDtoReq) {

        unidadPeso.setNombre(unidadPesoAdminDtoReq.getNombre().trim());

        if (unidadPesoAdminDtoReq.getDescripcion() != null) {

            unidadPeso.setDescripcion(unidadPesoAdminDtoReq.getDescripcion().trim());
        }
    }

    @Caching(evict = {
        @CacheEvict(value = "unidades_peso_admin", allEntries = true),
        @CacheEvict(value = "unidades_peso", allEntries = true),
        @CacheEvict(value = "unidad_peso_detail", key = "#id")

    })
    @Transactional(rollbackFor = Exception.class)
    @Override
    public UnidadPeso update(Long id, UnidadPesoAdminDtoReq unidadPesoAdminDtoReq) {

        UnidadPeso unidadPeso = unidadPesoRepository.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("La unidad de peso no existe en el sistema"));

        Optional<UnidadPeso> existe = unidadPesoRepository
                .existeAndEstaActivo(unidadPesoAdminDtoReq.getNombre().trim());

        if (existe.isPresent()) {

            if (existe.get().getId() != unidadPeso.getId()) {

                throw new DatoYaExistenteException("La unidad de peso ya existe en el sistema.");

            }
        }

        llenarDatos(unidadPeso, unidadPesoAdminDtoReq);

        AuditableUtils.update(unidadPeso, "prueba", "prueba");

        return unidadPesoRepository.save(unidadPeso);
    }

    @Cacheable(value = "unidades_peso_admin")
    @Transactional(readOnly = true)
    @Override
    public PageResponse<UnidadPesoAdminDtoResp> getAll(String nombre, Boolean active, Pageable pageable) {

        Page<UnidadPesoAdminDtoResp> page = unidadPesoRepository.getAllAdmin(nombre, active, pageable);

        if (page.isEmpty()) {
            throw new NoDatosQueMostrarExecption("No hay unidades de peso que mostrar");
        }

        return PageResponseUtils.CreatePageReponse(page);
    }

    @Cacheable(value = "unidad_peso_detail", key = "#id")
    @Transactional(readOnly = true)
    @Override
    public UnidadPesoAdminDetailsDtoResp getDetailsById(Long id) {

        return unidadPesoRepository.getDetailByID(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("La unidad de peso no existe en el sistema"));

    }

}
