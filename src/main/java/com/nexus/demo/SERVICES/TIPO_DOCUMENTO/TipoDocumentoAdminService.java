/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.TIPO_DOCUMENTO;

import com.nexus.biblioNepo.UTILS.PageResponseUtils;
import com.nexus.demo.AuditableUtils;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.TIPO_SUELO.TipoDocumentoAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.TIPO_DOCUMENTO.TipoDocumentoAdminDtoResp;
import com.nexus.demo.DatoNoExistenteEcxeption;
import com.nexus.demo.DatoYaExistenteException;
import com.nexus.demo.ENTITIES.TipoDocumento;
import com.nexus.demo.NoDatosQueMostrarExecption;
import com.nexus.demo.REPOSITORY.TipoDocumentoRepository;
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
public class TipoDocumentoAdminService implements ITipoDocumentoAdminService {

    private TipoDocumentoRepository tipoDocumentoRepository;

    @Autowired
    public TipoDocumentoAdminService(TipoDocumentoRepository tipoDocumentoRepository) {
        this.tipoDocumentoRepository = tipoDocumentoRepository;
    }

    @Caching(evict = {
        @CacheEvict(value = "tipo_documentos_admin", allEntries = true),
        @CacheEvict(value = "tipo_documento", allEntries = true)

    })
    @Transactional(rollbackFor = Exception.class)
    @Override
    public TipoDocumento create(TipoDocumentoAdminDtoReq tipoDocumentoAdminDtoReq) {

        Optional<TipoDocumento> existe = tipoDocumentoRepository
                .existeAndEstaActivo(tipoDocumentoAdminDtoReq.getNombre().trim());

        if (existe.isPresent()) {

            throw new DatoYaExistenteException("El tipo de documento ya existe en el sistema");
        }

        TipoDocumento tipoDocumento = new TipoDocumento();

        tipoDocumento.setNombre(tipoDocumentoAdminDtoReq.getNombre().trim());

        if (tipoDocumentoAdminDtoReq.getDescripcion() != null) {

            tipoDocumento.setDescripcion(tipoDocumentoAdminDtoReq.getDescripcion().trim());
        }

        AuditableUtils.create(tipoDocumento, "prueba", "prueba");

        return tipoDocumentoRepository.save(tipoDocumento);

    }

    @Caching(evict = {
        @CacheEvict(value = "tipo_documentos_admin", allEntries = true),
        @CacheEvict(value = "tipo_documento", allEntries = true)

    })
    @Transactional(rollbackFor = Exception.class)
    @Override
    public TipoDocumento update(Long id, TipoDocumentoAdminDtoReq tipoDocumentoAdminDtoReq) {

        TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El tipo de documento no existe en el sistema"));

        Optional<TipoDocumento> estaEnUso = tipoDocumentoRepository
                .existeAndEstaActivo(tipoDocumentoAdminDtoReq.getNombre().trim());

        if (estaEnUso.isPresent()) {

            if (estaEnUso.get().getId() != tipoDocumento.getId()) {

                throw new DatoYaExistenteException("El tipo de documento ya existe en el sitema.");
            }
        }

        tipoDocumento.setNombre(tipoDocumentoAdminDtoReq.getNombre().trim());

        if (tipoDocumentoAdminDtoReq.getDescripcion() != null) {

            tipoDocumento.setDescripcion(tipoDocumentoAdminDtoReq.getDescripcion().trim());
        }

        AuditableUtils.update(tipoDocumento, "prueba", "prueba");

        return tipoDocumentoRepository.save(tipoDocumento);
    }

    @Cacheable(value = "tipo_documentos_admin")
    @Transactional(readOnly = true)
    @Override
    public PageResponse<TipoDocumentoAdminDtoResp> getAll(String nombre, Boolean active, Pageable pageable) {

        Page<TipoDocumentoAdminDtoResp> page = tipoDocumentoRepository.getAllAdmin(nombre, active, pageable);

        if (page.isEmpty()) {

            throw new NoDatosQueMostrarExecption("No hay datos que mostrar");
        }

        return PageResponseUtils.CreatePageReponse(page);

    }

    @Transactional(readOnly = true)
    @Override
    public TipoDocumentoAdminDtoResp getById(Long id) {

        return tipoDocumentoRepository.obtenerById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El tipo de documento no existe en el sistema"));

    }

}
