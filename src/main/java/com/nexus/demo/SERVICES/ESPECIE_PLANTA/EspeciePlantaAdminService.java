/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.ESPECIE_PLANTA;

import com.nexus.biblioNepo.UTILS.PageResponseUtils;
import com.nexus.demo.AuditableUtils;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.ESPECIE_PLANTA.EspeciePlantaAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.ESPECIE_PLANTA.EspeciePlantaAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.ESPECIE_PLANTA.EspeciePlantaDetailsDtoResp;
import com.nexus.demo.DatoNoExistenteEcxeption;
import com.nexus.demo.DatoYaExistenteException;
import com.nexus.demo.ENTITIES.Especie;
import com.nexus.demo.NoDatosQueMostrarExecption;
import com.nexus.demo.REPOSITORY.EspecieRepository;
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
public class EspeciePlantaAdminService implements IEspeciePlantaAdminService {

    private EspecieRepository especieRepository;

    @Autowired
    public EspeciePlantaAdminService(EspecieRepository especieRepository) {
        this.especieRepository = especieRepository;
    }

    @Caching(evict = {
        @CacheEvict(value = "especies_plantas_admin", allEntries = true),
        @CacheEvict(value = "especies_plantas", allEntries = true)
    })
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Especie create(EspeciePlantaAdminDtoReq especiePlantaAdminDtoReq) {

        Optional<Especie> existe = especieRepository.existeAndEstaActivo(especiePlantaAdminDtoReq.getNombre().trim());

        if (existe.isPresent()) {

            throw new DatoYaExistenteException("La especie de la planta ya existe en el sistema");
        }

        Especie especie = new Especie();

        especie.setNombre(especiePlantaAdminDtoReq.getNombre().trim());

        if (especiePlantaAdminDtoReq.getDescripcion() != null) {

            especie.setDescripcion(especiePlantaAdminDtoReq.getDescripcion().trim());
        }
        AuditableUtils.create(especie, "prueba", "prueba");

        return especieRepository.save(especie);
    }

    @Caching(evict = {
        @CacheEvict(value = "especies_plantas_admin", allEntries = true),
        @CacheEvict(value = "especies_plantas", allEntries = true),
        @CacheEvict(value = "especie_planta_detail", key = "#id")
    })
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Especie updateById(Long id, EspeciePlantaAdminDtoReq especiePlantaAdminDtoReq) {

        Especie especie = especieRepository.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("La especie no existe en el sistema"));
        Optional<Especie> existeYa = especieRepository.existeAndEstaActivo(especiePlantaAdminDtoReq.getNombre().trim());

        if (existeYa.isPresent()) {

            if (existeYa.get().getId() != especie.getId()) {
                throw new DatoYaExistenteException("La escpecie ya se encuentra en el sistema");
            }
        }
        especie.setNombre(especiePlantaAdminDtoReq.getNombre().trim());

        if (especiePlantaAdminDtoReq.getDescripcion() != null) {

            especie.setDescripcion(especiePlantaAdminDtoReq.getDescripcion().trim());
        }
        AuditableUtils.update(especie, "prueba", "prueba");

        return especieRepository.save(especie);
    }

    @Caching(
            cacheable = {
                @Cacheable(value = "especies_plantas_admin")
            }
    )
    @Transactional(readOnly = true)
    @Override
    public PageResponse<EspeciePlantaAdminDtoResp> getAll(String nombre, Boolean active, Pageable pageable) {
        Page<EspeciePlantaAdminDtoResp> page = especieRepository.getAllAdmin(nombre, active, pageable);

        if (page.isEmpty()) {
            throw new NoDatosQueMostrarExecption("No hay especies de planta que mostrar");
        }

        return PageResponseUtils.CreatePageReponse(page);

    }

    @Cacheable(value = "especie_planta_detail", key = "#id")
    @Transactional(readOnly = true)
    @Override
    public EspeciePlantaDetailsDtoResp getDetailsByID(Long id) {

        return especieRepository.getDetailsByID(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("La especie no existe ene el sistema"));
    }

}
