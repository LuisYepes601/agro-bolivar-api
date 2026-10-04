/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.CICLO_GERMINACION;

import com.nexus.biblioNepo.UTILS.PageResponseUtils;
import com.nexus.demo.AuditableUtils;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.CICLO_GERMINACION.CicloGerminacionAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.CICLO_GERMINACION.CicloGerminacionAdminDetailsDtoResp;
import com.nexus.demo.DTOS.RESPONSE.CICLO_GERMINACION.CicloGerminacionAdminDtoResp;
import com.nexus.demo.DatoNoExistenteEcxeption;
import com.nexus.demo.DatoYaExistenteException;
import com.nexus.demo.ENTITIES.CicloGerminacion;
import com.nexus.demo.GLOBALEXCEPTIONHANDLER.exceptions.DatoInvalidoEcxeption;
import com.nexus.demo.NoDatosQueMostrarExecption;
import com.nexus.demo.REPOSITORY.CicloGerminacionRepository;
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
public class CicloGerminacionAdminService implements ICicloGerminacionAdminService {

    private CicloGerminacionRepository cicloGerminacionRepository;

    @Autowired
    public CicloGerminacionAdminService(CicloGerminacionRepository cicloGerminacionRepository) {
        this.cicloGerminacionRepository = cicloGerminacionRepository;
    }

    @Caching(
            evict = {
                @CacheEvict(value = "ciclo_germinaciones_admin", allEntries = true),
                @CacheEvict(value = "ciclo_germinaciones", allEntries = true)

            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public CicloGerminacion create(CicloGerminacionAdminDtoReq cicloGerminacionAdminDtoReq) {

        Optional<CicloGerminacion> existe = cicloGerminacionRepository
                .existeAndEstaActivo(cicloGerminacionAdminDtoReq.getNombre().trim());

        if (existe.isPresent()) {
            throw new DatoYaExistenteException("El ciclo de germinación ya existe en el sistema");
        }

        CicloGerminacion cicloGerminacion = new CicloGerminacion();

        llenarDatosBasicos(cicloGerminacion, cicloGerminacionAdminDtoReq);

        AuditableUtils.create(cicloGerminacion, "prueba", "prueba");

        return cicloGerminacionRepository.save(cicloGerminacion);

    }

    public void llenarDatosBasicos(CicloGerminacion cicloGerminacion, CicloGerminacionAdminDtoReq cicloGerminacionAdminDtoReq) {

        cicloGerminacion.setNombre(cicloGerminacionAdminDtoReq.getNombre().trim());

        if (cicloGerminacionAdminDtoReq.getDescripcion() != null) {

            cicloGerminacion.setDescripcion(cicloGerminacionAdminDtoReq.getDescripcion().trim());
        }

        if (cicloGerminacionAdminDtoReq.getDiasMaximos() < cicloGerminacionAdminDtoReq.getDiasMinimos()) {

            throw new DatoInvalidoEcxeption("El tiempo maximo no puede ser menor al tiempo minimo");
        }

        cicloGerminacion.setDiasMaximos(cicloGerminacionAdminDtoReq.getDiasMaximos());
        cicloGerminacion.setDiasMinimos(cicloGerminacionAdminDtoReq.getDiasMinimos());
    }

    @Caching(
            evict = {
                @CacheEvict(value = "ciclo_germinaciones_admin", allEntries = true),
                @CacheEvict(value = "ciclo_germinaciones", allEntries = true),
                @CacheEvict(value = "ciclo_germinacion_detail", key = "#id")

            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public CicloGerminacion updateByID(Long id, CicloGerminacionAdminDtoReq cicloGerminacionAdminDtoReq) {

        CicloGerminacion cicloGerminacion = cicloGerminacionRepository.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El ciclo de germinaciíon no existe en el sistema"));

        Optional<CicloGerminacion> existe = cicloGerminacionRepository.existeAndEstaActivo(
                cicloGerminacionAdminDtoReq.getNombre().trim());

        if (existe.isPresent()) {

            if (existe.get().getId() != cicloGerminacion.getId()) {

                throw new DatoYaExistenteException("El ciclo de germinación ya existe en el sistema");
            }

            llenarDatosBasicos(cicloGerminacion, cicloGerminacionAdminDtoReq);

            AuditableUtils.update(cicloGerminacion, "prueba", "prueba");

        }
        return cicloGerminacionRepository.save(cicloGerminacion);
    }

    @Cacheable(value = "ciclo_germinaciones_admin")
    @Transactional(readOnly = true)
    @Override
    public PageResponse<CicloGerminacionAdminDtoResp> getAll(String nombre, Boolean active, Pageable pageable) {
        Page<CicloGerminacionAdminDtoResp> page = cicloGerminacionRepository.getAll(nombre, active, pageable);

        if (page.isEmpty()) {
            throw new NoDatosQueMostrarExecption("No hay ciclos de germinación que mostrar");
        }

        return PageResponseUtils.CreatePageReponse(page);
    }

    @Cacheable(
            value = "ciclo_germinacion_detail"
    )
    @Transactional(readOnly = true)
    @Override
    public CicloGerminacionAdminDetailsDtoResp getDetailsByID(Long id) {

        return cicloGerminacionRepository.getDetailsById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El ciclo de germinación no existe en el sistema"));

    }

}
