/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.TEXTURA_SUELO;

import com.nexus.biblioNepo.UTILS.PageResponseUtils;
import com.nexus.demo.AuditableUtils;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.TEXTURA_SUELO.TexturaSueloAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.TEXTURA_SUELO.TexturaSueloAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.TEXTURA_SUELO.TexturaSueloDetailsDtoResp;
import com.nexus.demo.DatoNoExistenteEcxeption;
import com.nexus.demo.DatoYaExistenteException;
import com.nexus.demo.ENTITIES.TexturaSuelo;
import com.nexus.demo.NoDatosQueMostrarExecption;
import com.nexus.demo.REPOSITORY.TexturaSueloRepository;
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
public class TexturaSueloAdminService implements ITexturaSueloAdminService {
    
    private TexturaSueloRepository texturaSueloRepository;
    
    @Autowired
    public TexturaSueloAdminService(TexturaSueloRepository texturaSueloRepository) {
        this.texturaSueloRepository = texturaSueloRepository;
    }
    
    @Caching(
            evict = {
                @CacheEvict(value = "texturas_suelo_admin", allEntries = true),
                @CacheEvict(value = "texturas_suelo", allEntries = true)
            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public TexturaSuelo create(TexturaSueloAdminDtoReq texturaSueloAdminDtoReq) {
        
        Optional<TexturaSuelo> existe = texturaSueloRepository.
                existeAndEstaActivo(texturaSueloAdminDtoReq.getNombre().trim());
        
        if (existe.isPresent()) {
            
            throw new DatoYaExistenteException("La textura del suelo ya existe en el sistema y se encuentra activa actualmente");
        }
        
        TexturaSuelo texturaSuelo = new TexturaSuelo();
        
        llenarDatosBaicos(texturaSuelo, texturaSueloAdminDtoReq);
        
        AuditableUtils.create(texturaSuelo, "prueba", "prueba");
        
        return texturaSueloRepository.save(texturaSuelo);
        
    }
    
    public void llenarDatosBaicos(TexturaSuelo texturaSuelo, TexturaSueloAdminDtoReq texturaSueloAdminDtoReq) {
        
        texturaSuelo.setNombre(texturaSueloAdminDtoReq.getNombre().trim());
        
        if (texturaSueloAdminDtoReq.getDescripcion() != null) {
            
            texturaSuelo.setDescripcion(texturaSueloAdminDtoReq.getDescripcion().trim());
        }
        
        texturaSuelo.setForma(texturaSueloAdminDtoReq.getForma().trim());
        
    }
    
    @Caching(
            cacheable = {
                @Cacheable(value = "texturas_suelo_admin")
            }
    )
    @Transactional(readOnly = true)
    @Override
    public PageResponse<TexturaSueloAdminDtoResp> getAll(String nombre, String forma, Boolean active, Pageable pageable) {
        
        Page<TexturaSueloAdminDtoResp> page = texturaSueloRepository.getAllAdmin(nombre, forma, active, pageable);
        
        if (page.isEmpty()) {
            
            throw new NoDatosQueMostrarExecption("No hay texturas de suelo que mostrar");
        }
        
        return PageResponseUtils.CreatePageReponse(page);
        
    }
    
    @Caching(
            evict = {
                @CacheEvict(value = "texturas_suelo_admin", allEntries = true),
                @CacheEvict(value = "texturas_suelo", allEntries = true),
                @CacheEvict(value = "textura_suelo_detail", key = "#id")
            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public TexturaSuelo updateById(Long id, TexturaSueloAdminDtoReq texturaSueloAdminDtoReq) {
        
        TexturaSuelo texturaSuelo = texturaSueloRepository.findById(id)
                .orElseThrow(()
                        -> new DatoNoExistenteEcxeption("El tipo de textura no se encuentra activa en el sistema"));
        
        Optional<TexturaSuelo> existe = texturaSueloRepository
                .existeAndEstaActivo(texturaSueloAdminDtoReq.getNombre().trim());
        
        if (existe.isPresent()) {
            
            if (existe.get().getId() != texturaSuelo.getId()) {
                
                throw new DatoYaExistenteException("El tipo de textura ya se encuentra activo en el sistema.");
            }
        }
        
        llenarDatosBaicos(texturaSuelo, texturaSueloAdminDtoReq);
        
        AuditableUtils.update(texturaSuelo, "prueba", "prueba");
        
        return texturaSueloRepository.save(texturaSuelo);
    }
    
    @Cacheable(value = "textura_suelo_detail", key = "#id")
    @Transactional(readOnly = true)
    @Override
    public TexturaSueloDetailsDtoResp getDetailsById(Long id) {
        
        return texturaSueloRepository.getDetailsById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("La textura no existe en el sistema."));
    }
    
}
