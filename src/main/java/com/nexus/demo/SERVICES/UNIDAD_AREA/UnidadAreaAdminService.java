/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.UNIDAD_AREA;

import com.nexus.biblioNepo.UTILS.PageResponseUtils;
import com.nexus.demo.AuditableUtils;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.UNIDAD_AREA.UnidadAreaAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.UNIDAD_AREA.UnidadAreaAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.UNIDAD_AREA.UnidadAreaDetailsDtoResp;
import com.nexus.demo.DatoNoExistenteEcxeption;
import com.nexus.demo.DatoYaExistenteException;
import com.nexus.demo.ENTITIES.UnidadArea;
import com.nexus.demo.NoDatosQueMostrarExecption;
import com.nexus.demo.REPOSITORY.UnidadAreaRepository;
import io.swagger.v3.oas.annotations.Operation;
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
public class UnidadAreaAdminService implements IUnidadAreaAdminService {

    private UnidadAreaRepository unidadAreaRepository;

    @Autowired
    public UnidadAreaAdminService(UnidadAreaRepository unidadAreaRepository) {
        this.unidadAreaRepository = unidadAreaRepository;
    }

    @Caching(
            evict = {
                @CacheEvict(value = "unidades_area_admin", allEntries = true),
                @CacheEvict(value = "unidades_area", allEntries = true)

            })
    @Transactional(rollbackFor = Exception.class)
    @Override
    public UnidadArea create(UnidadAreaAdminDtoReq unidadAreaAdminDtoReq) {

        Optional<UnidadArea> existe
                = unidadAreaRepository.existeAndEstaActivo(unidadAreaAdminDtoReq.getNombre().trim());

        if (existe.isPresent()) {

            throw new DatoYaExistenteException("La unidad de medida ya existe en el sistema.");
        }
        UnidadArea unidadArea = new UnidadArea();

        llenarDatos(unidadArea, unidadAreaAdminDtoReq);

        AuditableUtils.create(unidadArea, "prueba", "prueba");

        return unidadAreaRepository.save(unidadArea);

    }

    public void llenarDatos(UnidadArea unidadArea, UnidadAreaAdminDtoReq unidadAreaAdminDtoReq) {

        unidadArea.setNombre(unidadAreaAdminDtoReq.getNombre().trim());

        if (unidadAreaAdminDtoReq.getDescripcion() != null) {

            unidadArea.setDescripcion(unidadAreaAdminDtoReq.getDescripcion().trim());
        }
    }

    @Caching(
            evict = {
                @CacheEvict(value = "unidades_area_admin", allEntries = true),
                @CacheEvict(value = "unidades_area", allEntries = true),
                @CacheEvict(value = "unidad_area_detail", key = "#id")

            })
    @Transactional(rollbackFor = Exception.class)
    @Override
    public UnidadArea update(Long id, UnidadAreaAdminDtoReq unidadAreaAdminDtoReq) {

        UnidadArea unidadArea = unidadAreaRepository.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("La unidad de area no existe en el sistema"));

        Optional<UnidadArea> existe = unidadAreaRepository.
                existeAndEstaActivo(unidadAreaAdminDtoReq.getNombre().trim());

        if (existe.isPresent()) {

            if (existe.get().getId() != unidadArea.getId()) {

                throw new DatoYaExistenteException("La unidad de area ya existe en el sistema");
            }
        }

        llenarDatos(unidadArea, unidadAreaAdminDtoReq);

        AuditableUtils.update(unidadArea, "prueba", "prueba");

        return unidadAreaRepository.save(unidadArea);

    }

    @Cacheable(value = "unidades_area_admin")
    @Transactional(readOnly = true)
    @Override
    public PageResponse<UnidadAreaAdminDtoResp> getAll(String nombre, Boolean active, Pageable pageable) {

        Page<UnidadAreaAdminDtoResp> page = unidadAreaRepository.getAllAdmin(nombre, active, pageable);

        if (page.isEmpty()) {

            throw new NoDatosQueMostrarExecption("No hay unidades de area que mostrar.");
        }

        return PageResponseUtils.CreatePageReponse(page);
    }

    @Cacheable(value = "unidad_area_detail", key = "#id")
    @Transactional(readOnly = true)
    @Override
    public UnidadAreaDetailsDtoResp getDetailsById(Long id) {

        return unidadAreaRepository.getDetailByID(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("La unidad de area no existe en el sistema"));
    }

}
