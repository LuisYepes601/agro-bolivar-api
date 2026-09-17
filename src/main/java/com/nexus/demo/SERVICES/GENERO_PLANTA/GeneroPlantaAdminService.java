/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.GENERO_PLANTA;

import com.nexus.biblioNepo.UTILS.PageResponseUtils;
import com.nexus.demo.AuditableUtils;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.GENERO_PLANTA.GeneroPlantaAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.GENERO_PLANTA.GeneroPlantaAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.GENERO_PLANTA.GeneroPlantaDetailsDtoResp;
import com.nexus.demo.DatoNoExistenteEcxeption;
import com.nexus.demo.DatoYaExistenteException;
import com.nexus.demo.ENTITIES.GeneroPlanta;
import com.nexus.demo.NoDatosQueMostrarExecption;
import com.nexus.demo.REPOSITORY.GeneroPlantaRepository;
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
public class GeneroPlantaAdminService implements IGeneroPlantaAdminService {

    private GeneroPlantaRepository generoPlantaRepository;

    @Autowired
    public GeneroPlantaAdminService(GeneroPlantaRepository generoPlantaRepository) {
        this.generoPlantaRepository = generoPlantaRepository;
    }

    @Caching(evict = {
        @CacheEvict(value = "genero-plantas-admin", allEntries = true),
        @CacheEvict(value = "genero-plantas", allEntries = true)

    })
    @Transactional(rollbackFor = Exception.class)
    @Override
    public GeneroPlanta create(GeneroPlantaAdminDtoReq generoPlantaAdminDtoReq) {

        Optional<GeneroPlanta> existe = generoPlantaRepository.existeAndEstaActivo(generoPlantaAdminDtoReq
                .getNombre().trim());

        if (existe.isPresent()) {
            throw new DatoYaExistenteException("El genero de la planta ya existe en el sistema");
        }

        GeneroPlanta generoPlanta = new GeneroPlanta();
        generoPlanta.setNombre(generoPlantaAdminDtoReq.getNombre().trim());

        if (generoPlantaAdminDtoReq.getDescripcion() != null) {

            generoPlanta.setDescripcion(generoPlantaAdminDtoReq.getDescripcion().trim());

        }

        AuditableUtils.create(generoPlanta, "prueba", "prueba");

        return generoPlantaRepository.save(generoPlanta);

    }

    @Caching(evict = {
        @CacheEvict(value = "genero-plantas-admin", allEntries = true),
        @CacheEvict(value = "genero-plantas", allEntries = true),
        @CacheEvict(value = "genero-planta-detail", key = "#id")

    })
    @Transactional(rollbackFor = Exception.class)
    @Override
    public GeneroPlanta updateById(Long id, GeneroPlantaAdminDtoReq generoPlantaAdminDtoReq) {

        GeneroPlanta generoPlanta = generoPlantaRepository.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El genero de planta no existe en el sistema"));

        Optional<GeneroPlanta> existe = generoPlantaRepository.existeAndEstaActivo(generoPlantaAdminDtoReq
                .getNombre().trim());

        if (existe.isPresent()) {

            if (existe.get().getId() != generoPlanta.getId()) {

                throw new DatoNoExistenteEcxeption("El genero de la planta ya existe en el sistema y se encuetra"
                        + "activa");
            }
        }

        generoPlanta.setNombre(generoPlantaAdminDtoReq.getNombre().trim());

        if (generoPlantaAdminDtoReq.getDescripcion() != null) {

            generoPlanta.setDescripcion(generoPlantaAdminDtoReq.getDescripcion().trim());
        }

        AuditableUtils.update(generoPlanta, "prueba", "prueba");

        return generoPlantaRepository.save(generoPlanta);
    }

    @Caching(
            cacheable = {
                @Cacheable(value = "genero-plantas-admin")
            }
    )
    @Transactional(readOnly = true)
    @Override
    public PageResponse<GeneroPlantaAdminDtoResp> getAll(String nombre, Boolean active, Pageable pageable) {

        Page<GeneroPlantaAdminDtoResp> page = generoPlantaRepository.getAllAdmin(nombre, active, pageable);

        if (page.isEmpty()) {
            throw new NoDatosQueMostrarExecption("No hay generos de planata que mostrar");
        }

        return PageResponseUtils.CreatePageReponse(page);

    }

    @Cacheable(value = "genero-planta-detail", key = "#id")
    @Transactional(readOnly = true)
    @Override
    public GeneroPlantaDetailsDtoResp getDetailsById(Long id) {

        return generoPlantaRepository.getDetailsById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El genero de la planta no existe "
                + "en el sistema"));
    }

}
