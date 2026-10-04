/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.TIPO_SUELO;

import com.nexus.biblioNepo.UTILS.PageResponseUtils;
import com.nexus.demo.AuditableUtils;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.TIPO_SUELO.TexturaSueloBasicDtoReq;
import com.nexus.demo.DTOS.REQUEST.TIPO_SUELO.TipoSueloAdminDtoReq;
import com.nexus.demo.DTOS.REQUEST.TIPO_SUELO.TipoSueloBasicDtoReq;
import com.nexus.demo.DTOS.RESPONSE.TIPO_SUELO.TipoSueloAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.TIPO_SUELO.TipoSueloDetailsDtoResp;
import com.nexus.demo.DatoNoExistenteEcxeption;
import com.nexus.demo.DatoYaExistenteException;
import com.nexus.demo.ENTITIES.TexturaSuelo;
import com.nexus.demo.ENTITIES.TexturaTipoSuelo;
import com.nexus.demo.ENTITIES.TipoSuelo;
import com.nexus.demo.GLOBALEXCEPTIONHANDLER.exceptions.DatoInvalidoEcxeption;
import com.nexus.demo.NoDatosQueMostrarExecption;
import com.nexus.demo.REPOSITORY.TexturaSueloRepository;
import com.nexus.demo.REPOSITORY.TexturaTipoSueloRepository;
import com.nexus.demo.REPOSITORY.TipoSueloRepository;
import java.util.ArrayList;
import java.util.List;
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

    @Caching(
            evict = {
                @CacheEvict(value = "tipo_suelos_admin", allEntries = true),
                @CacheEvict(value = "tipo_suelos", allEntries = true),
                @CacheEvict(value = "tipo_suelo_detail", key = "#id")
            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public TipoSuelo editarDatosBasicos(Long id_tipo_suelo, TipoSueloBasicDtoReq tipoSueloBaicDtoReq) {

        TipoSuelo tipoSuelo = tipoSueloRepository.findById(id_tipo_suelo)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El tipo de suelo no existe en el sistema."));
        ;

        Optional<TipoSuelo> existe = tipoSueloRepository.existeAndEstaActivo(tipoSueloBaicDtoReq.getNombre().trim());

        if (existe.isPresent()) {

            if (existe.get().getId() != tipoSuelo.getId()) {

                throw new DatoYaExistenteException("El tipo de sueleo ya existe en el sistema y se encuentra activo actualmente");
            }
        }

        tipoSuelo.setNombre(tipoSueloBaicDtoReq.getNombre().trim());

        if (tipoSueloBaicDtoReq.getDescripcion() != null) {

            tipoSuelo.setDescripcion(tipoSueloBaicDtoReq.getDescripcion().trim());

        }

        if (tipoSueloBaicDtoReq.getPhMaximo() > tipoSueloBaicDtoReq.getPhMinimo()) {

            throw new DatoInvalidoEcxeption("El PH minmo no puede ser mayor que el PH máximo");
        }

        tipoSuelo.setPhMaximo(tipoSueloBaicDtoReq.getPhMaximo());
        tipoSuelo.setPhMinimo(tipoSueloBaicDtoReq.getPhMinimo());
        tipoSuelo.setColor(tipoSueloBaicDtoReq.getColor().trim());

        AuditableUtils.update(tipoSuelo, "prueba", "prueba");

        return tipoSuelo;

    }

    @Caching(
            cacheable = {
                @Cacheable(value = "tipo_suelos_admin"),
                @Cacheable(value = "tipo_suelos")
            }
    )
    @Transactional(readOnly = true)
    @Override
    public PageResponse<TipoSueloAdminDtoResp> getAll(String nombre, String color, Boolean active, Pageable pageable) {

        Page<TipoSueloAdminDtoResp> page = tipoSueloRepository.getAllAdmin(nombre, color, active, pageable);

        if (page.isEmpty()) {

            throw new NoDatosQueMostrarExecption("No hay tipos de suelo que mostrar");
        }

        return PageResponseUtils.CreatePageReponse(page);

    }

    @Caching(
            cacheable = {
                @Cacheable(value = "tipo_suelo_detail", key = "#id")
            }
    )
    @Transactional(readOnly = true)
    @Override
    public TipoSueloDetailsDtoResp getDetailsById(Long id) {

        return tipoSueloRepository.getDetailsById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El tipo de suelo no existe en el sistema."));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void eliminarTexturaDeTipoSuelo(Long id_textura, Long id_tipo_suelo) {

        TipoSuelo tipoSuelo = tipoSueloRepository.findById(id_tipo_suelo)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El tipo de suelo no existe en el sistema."));

        TexturaSuelo texturaSuelo = texturaSueloRepo.findById(id_textura)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("La textura no existe en el sistema."));

        TexturaTipoSuelo texturaTipoSuelo = textTipoSueloRepo.existeAndEstaActivo(id_tipo_suelo, id_textura)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El tipo de suelo no tiene esa textura relacionada"));

        AuditableUtils.delete(texturaTipoSuelo, "prueba", "prueba");

    }

}
