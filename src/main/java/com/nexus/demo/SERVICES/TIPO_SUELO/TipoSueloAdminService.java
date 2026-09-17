/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.TIPO_SUELO;

import com.nexus.demo.AuditableUtils;
import com.nexus.demo.DTOS.REQUEST.TIPO_SUELO.TexturaSueloBasicDtoReq;
import com.nexus.demo.DTOS.REQUEST.TIPO_SUELO.TipoSueloAdminDtoReq;
import com.nexus.demo.DatoNoExistenteEcxeption;
import com.nexus.demo.DatoYaExistenteException;
import com.nexus.demo.ENTITIES.TexturaSuelo;
import com.nexus.demo.ENTITIES.TexturaTipoSuelo;
import com.nexus.demo.ENTITIES.TipoSuelo;
import com.nexus.demo.GLOBALEXCEPTIONHANDLER.exceptions.DatoInvalidoEcxeption;
import com.nexus.demo.REPOSITORY.TexturaSueloRepository;
import com.nexus.demo.REPOSITORY.TexturaTipoSueloRepository;
import com.nexus.demo.REPOSITORY.TipoSueloRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author luis
 */
@Service
public class TipoSueloAdminService implements ITipoSueloAdminService {
    
    private TipoSueloRepository tipoSueloRepository;
    private TexturaTipoSueloRepository textTipoSueloRepo;
    private TexturaSueloRepository texturaSueloRepo;
    
    @Autowired
    public TipoSueloAdminService(TipoSueloRepository tipoSueloRepository, TexturaTipoSueloRepository textTipoSueloRepo, TexturaSueloRepository texturaSueloRepo) {
        this.tipoSueloRepository = tipoSueloRepository;
        this.textTipoSueloRepo = textTipoSueloRepo;
        this.texturaSueloRepo = texturaSueloRepo;
    }
    
    @Caching(
            evict = {
                @CacheEvict(value = "tipo_suelos_admin", allEntries = true),
                @CacheEvict(value = "tipo_suelos", allEntries = true)
            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public TipoSuelo create(TipoSueloAdminDtoReq tipoSueloAdminDtoReq) {
        
        Optional<TipoSuelo> existeYa = tipoSueloRepository.existeAndEstaActivo(
                tipoSueloAdminDtoReq.getNombre().trim());
        
        if (existeYa.isPresent()) {
            
            throw new DatoYaExistenteException("El tipo d esuelo ya existe en el sistema");
        }
        
        TipoSuelo tipoSuelo = new TipoSuelo();
        
        AuditableUtils.create(tipoSuelo, "prueba", "prueba");
        
        llenarAtributos(tipoSuelo, tipoSueloAdminDtoReq);
        
        TipoSuelo tipoSuelo1 = tipoSueloRepository.save(tipoSuelo);

        //entidad intermedia 
        asignartexturaATipoSuelos(tipoSueloAdminDtoReq.getTexturas(), tipoSuelo);
        
        return tipoSuelo1;
        
    }
    
    public void llenarAtributos(TipoSuelo tipoSuelo, TipoSueloAdminDtoReq tipoSueloAdminDtoReq) {
        
        tipoSuelo.setNombre(tipoSueloAdminDtoReq.getNombre().trim());
        
        if (tipoSueloAdminDtoReq.getDescripcion() != null) {
            
            tipoSuelo.setDescripcion(tipoSueloAdminDtoReq.getDescripcion().trim());
        }
        
        tipoSuelo.setColor(tipoSuelo.getColor().trim().toUpperCase());
        
        if (tipoSueloAdminDtoReq.getPhMaximo() < tipoSueloAdminDtoReq.getPhMinimo()) {
            
            throw new DatoInvalidoEcxeption("El ph minimo no puede ser mayor que el máximo");
        }
        
        tipoSuelo.setPhMinimo(tipoSueloAdminDtoReq.getPhMinimo());
        tipoSuelo.setPhMaximo(tipoSueloAdminDtoReq.getPhMaximo());
    }
    
    public void asignartexturaATipoSuelos(List<TexturaSueloBasicDtoReq> texturas, TipoSuelo tipoSuelo) {
        
        List<TexturaTipoSuelo> texturaSuelos = new ArrayList<>();
        
        texturas.stream()
                .forEach((t) -> {
                    TexturaSuelo texturaSuelo = texturaSueloRepo.findById(t.getId())
                            .orElseThrow(() -> new DatoNoExistenteEcxeption("La textura no existe en el sistema"));
                    
                    TexturaTipoSuelo texturaTipoSuelo = new TexturaTipoSuelo();
                    texturaTipoSuelo.setTexturaSuelo(texturaSuelo);
                    texturaTipoSuelo.setTipoSuelo(tipoSuelo);
                    
                    AuditableUtils.create(texturaTipoSuelo, "prueba", "prueba");
                    
                    texturaSuelos.add(texturaTipoSuelo);
                    
                });
        
        textTipoSueloRepo.saveAll(texturaSuelos);
        
    }
    
}
