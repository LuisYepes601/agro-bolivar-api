/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.CICLO_PRODUCCION;

import com.nexus.biblioNepo.UTILS.PageResponseUtils;
import com.nexus.demo.AuditableUtils;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.CICLO_PRODUCCION.CicloProduccionAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.CICLO_PRODUCCION.CicloProduccionAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.CICLO_PRODUCCION.CicloProduccionDetailsDtoResp;
import com.nexus.demo.DatoNoExistenteEcxeption;
import com.nexus.demo.DatoYaExistenteException;
import com.nexus.demo.ENTITIES.CicloProduccion;
import com.nexus.demo.GLOBALEXCEPTIONHANDLER.exceptions.DatoInvalidoEcxeption;
import com.nexus.demo.NoDatosQueMostrarExecption;
import com.nexus.demo.REPOSITORY.CicloProduccionRepository;
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
public class CicloProdcuccionAdminService implements ICicloProduccionAdminService {

    private CicloProduccionRepository cicloProduccionRepository;

    @Autowired
    public CicloProdcuccionAdminService(CicloProduccionRepository cicloProduccionRepository) {
        this.cicloProduccionRepository = cicloProduccionRepository;
    }

    @Caching(
            evict = {
                @CacheEvict(value = "ciclos_produccion_admin", allEntries = true),
                @CacheEvict(value = "ciclos_produccion", allEntries = true)
            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public CicloProduccion create(CicloProduccionAdminDtoReq cicloProduccionAdminDtoReq) {

        Optional<CicloProduccion> existe = cicloProduccionRepository
                .existeAndEstaActivo(cicloProduccionAdminDtoReq.getNombre().trim());

        if (existe.isPresent()) {
            throw new DatoYaExistenteException("El ciclo de producción ya existe en el sistema.");
        }

        CicloProduccion cicloProduccion = new CicloProduccion();

        llenarDatosBasicos(cicloProduccion, cicloProduccionAdminDtoReq);

        AuditableUtils.create(cicloProduccion, "prueba", "prueba");

        return cicloProduccionRepository.save(cicloProduccion);

    }

    public void llenarDatosBasicos(CicloProduccion cicloProduccion, CicloProduccionAdminDtoReq cicloProduccionAdminDtoReq) {

        cicloProduccion.setNombre(cicloProduccionAdminDtoReq.getNombre().trim());

        if (cicloProduccionAdminDtoReq.getDiasMaximos() < cicloProduccionAdminDtoReq.getDiasMinimos()) {
            throw new DatoInvalidoEcxeption("Los dias maximos no pueden ser menor que los días minimos.");
        }

        cicloProduccion.setDiasMaximos(cicloProduccionAdminDtoReq.getDiasMaximos());
        cicloProduccion.setDiasMinimos(cicloProduccionAdminDtoReq.getDiasMinimos());

        if (cicloProduccionAdminDtoReq.getDescripcion() != null) {

            cicloProduccion.setDescripcion(cicloProduccionAdminDtoReq.getDescripcion());
        }

    }

    @Caching(
            evict = {
                @CacheEvict(value = "ciclos_produccion_admin", allEntries = true),
                @CacheEvict(value = "ciclos_produccion", allEntries = true),
                @CacheEvict(value = "ciclo_produccion", key = "#id")
            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public CicloProduccion update(Long id, CicloProduccionAdminDtoReq cicloProduccionAdminDtoReq) {

        CicloProduccion cicloProduccion = cicloProduccionRepository.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El ciclo de producción no existe en el sistema."));

        Optional<CicloProduccion> existe = cicloProduccionRepository
                .existeAndEstaActivo(cicloProduccionAdminDtoReq.getNombre().trim());

        if (existe.isPresent()) {
            if (existe.get().getId() != cicloProduccion.getId()) {
                throw new DatoYaExistenteException("El ciclo de producción ya existe en el sistema");

            }
        }

        llenarDatosBasicos(cicloProduccion, cicloProduccionAdminDtoReq);

        AuditableUtils.update(cicloProduccion, "prueba", "prueba");

        return cicloProduccionRepository.save(cicloProduccion);

    }

    @Cacheable(value = "ciclos_produccion_admin")
    @Transactional(readOnly = true)
    @Override
    public PageResponse<CicloProduccionAdminDtoResp> getAll(String nombre, Boolean active, Pageable pageable) {
        Page<CicloProduccionAdminDtoResp> page = cicloProduccionRepository.getAllAdmin(nombre, active, pageable);

        if (page.isEmpty()) {
            throw new NoDatosQueMostrarExecption("No hay ciclos de producción que mostrar");
        }

        return PageResponseUtils.CreatePageReponse(page);

    }

    @Cacheable(value = "ciclo_produccion", key = "#id")
    @Transactional(readOnly = true)
    @Override
    public CicloProduccionDetailsDtoResp getDetailsById(Long id) {

        return cicloProduccionRepository.getDetailsByID(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El ciclo de producción no existe en el sistema"));
    }

}
