/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.SERVICES.CULTIVOS;

import com.nexus.biblioNepo.UTILS.PageResponseUtils;
import com.nexus.demo.AuditableUtils;
import com.nexus.demo.DTOS.GLOBAL.CloudinaryUploadResponse;
import com.nexus.demo.DTOS.GLOBAL.PageResponse;
import com.nexus.demo.DTOS.REQUEST.CULTIVO.CultivoAdminDtoReq;
import com.nexus.demo.DTOS.RESPONSE.CULTIVO.CultivoAdminDtoResp;
import com.nexus.demo.DTOS.RESPONSE.CULTIVO.CultivoDtoResp;
import com.nexus.demo.DatoNoExistenteEcxeption;
import com.nexus.demo.ENTITIES.Cultivo;
import com.nexus.demo.NoDatosQueMostrarExecption;
import com.nexus.demo.REPOSITORY.CultivoRepository;
import com.nexus.demo.REPOSITORY.EstadoCultivoRepository;
import com.nexus.demo.REPOSITORY.PlantaRepository;
import com.nexus.demo.REPOSITORY.UnidadAreaRepository;
import com.nexus.demo.REPOSITORY.UnidadPesoRepository;
import com.nexus.demo.REPOSITORY.UsuarioRepository;
import com.nexus.demo.SERVICES.CLOUDINARY.ICloudinaryService;
import com.nexus.demo.SERVICES.UNIDAD_PESO.IUnidadPesoAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author luis
 */
@Service
public class CultivoAdminService implements ICultivoAdminService {

    private CultivoRepository cultivoRepository;
    private UnidadAreaRepository unidadAreaRepo;
    private ICloudinaryService cdnService;
    private UnidadPesoRepository unPesoRepo;
    private EstadoCultivoRepository estadoCultRepo;
    private UsuarioRepository usuarioRepo;
    private PlantaRepository plantaRepo;

    @Autowired
    public CultivoAdminService(CultivoRepository cultivoRepository, UnidadAreaRepository unidadAreaRepo, ICloudinaryService cdnService, UnidadPesoRepository unPesoRepo, EstadoCultivoRepository estadoCultRepo, UsuarioRepository usuarioRepo, PlantaRepository plantaRepo) {
        this.cultivoRepository = cultivoRepository;
        this.unidadAreaRepo = unidadAreaRepo;
        this.cdnService = cdnService;
        this.unPesoRepo = unPesoRepo;
        this.estadoCultRepo = estadoCultRepo;
        this.usuarioRepo = usuarioRepo;
        this.plantaRepo = plantaRepo;
    }

    @Caching(
            evict = {
                @CacheEvict(value = "cultivos_admin", allEntries = true),
                @CacheEvict(value = "cultivos", allEntries = true)

            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Cultivo create(CultivoAdminDtoReq cultivoAdminDtoReq, MultipartFile fotoCultivo) {

        Cultivo cultivo = new Cultivo();

        llenarDatosBasicos(cultivo, cultivoAdminDtoReq);

        AuditableUtils.create(cultivo, "prueba", "prueba");

        return cultivoRepository.save(cultivo);

    }

    public void subirFotoCultivo(String nameCultivo, MultipartFile file) {

        CloudinaryUploadResponse response = cdnService.uploadFotoCultivo(
                file,
                file.getOriginalFilename(),
                nameCultivo);

    }

    @Caching(
            evict = {
                @CacheEvict(value = "cultivos_admin", allEntries = true),
                @CacheEvict(value = "cultivos", allEntries = true)

            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Cultivo updateById(Long id, CultivoAdminDtoReq cultivoAdminDtoReq) {

        Cultivo cultivo = cultivoRepository.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El cultivo no existe en el sistema"));

        llenarDatosBasicos(cultivo, cultivoAdminDtoReq);

        AuditableUtils.update(cultivo, "prueba", "prueba");

        return cultivoRepository.save(cultivo);

    }

    public void llenarDatosBasicos(Cultivo cultivo, CultivoAdminDtoReq cultivoAdminDtoReq) {

        cultivo.setUsuario(usuarioRepo.findById(cultivoAdminDtoReq.getId_user())
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El usuario no existe en el sistema")));

        cultivo.setPlanta(plantaRepo.findById(cultivoAdminDtoReq.getId_planta())
                .orElseThrow(() -> new DatoNoExistenteEcxeption("La planta no existe en el sistema")));

        cultivo.setPrecioPorKg(cultivoAdminDtoReq.getPrecioPorKg());

        if (cultivoAdminDtoReq.getFechaInicio().isAfter(cultivoAdminDtoReq.getFechaEstimadaFin())) {

            throw new DatoNoExistenteEcxeption("La fecha de inicio no puede ser mayor a la fecha estimada de fin del cultivo");
        }

        cultivo.setFechaInicio(cultivoAdminDtoReq.getFechaInicio());
        cultivo.setFechaEstimadaFin(cultivoAdminDtoReq.getFechaEstimadaFin());

        //area
        if (cultivo.getUnidadArea() != null) {

            cultivo.setUnidadArea(unidadAreaRepo.findById(cultivoAdminDtoReq.getId_unidad_area())
                    .orElseThrow(() -> new DatoNoExistenteEcxeption("La unidad de area no existe en el sistema")));

            cultivo.setAreaSembrada(cultivoAdminDtoReq.getAreaSembrada());

        }

        //peso
        if (cultivoAdminDtoReq.getId_unidad_peso() != null) {

            cultivo.setUnidadPeso(unPesoRepo.findById(cultivoAdminDtoReq.getId_unidad_peso())
                    .orElseThrow(() -> new DatoNoExistenteEcxeption("La unidad de peso no existe en el sistema.")));

            cultivo.setCantidadSembrada(cultivoAdminDtoReq.getCantidadSembrada());
        }

        //estado
        if (cultivoAdminDtoReq.getId_estado_cultivo() != null) {

            cultivo.setEstadoCultivo(estadoCultRepo.findById(cultivoAdminDtoReq.getId_estado_cultivo())
                    .orElseThrow(() -> new DatoNoExistenteEcxeption("El estado de cultivo no existe en el sistema")));

        }

        cultivo.setCantidadDisponible(cultivoAdminDtoReq.getCantidadDisponible());
        cultivo.setCantidadDisponibleParaVenta(cultivoAdminDtoReq.getCantidadDisponibleParaVenta());

        cultivo.setPrecioPorKg(cultivoAdminDtoReq.getPrecioPorKg());

    }

    @Caching(
            evict = {
                @CacheEvict(value = "cultivos_admin", allEntries = true),
                @CacheEvict(value = "cultivos", allEntries = true)

            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Cultivo editarFotoCultivo(Long id, MultipartFile foto) {

        Cultivo cultivo = cultivoRepository.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El cultivo no existe en el sistema"));

        if (cultivo.getImgCultivoPublicId() != null) {

            cdnService.deleteFile(cultivo.getImgCultivoPublicId());
        }

        CloudinaryUploadResponse resp = cdnService.uploadFotoCultivo(foto, foto.getOriginalFilename(), cultivo.getPlanta().getNombre());

        cultivo.setImgCultivo(resp.getSecureUrl());
        cultivo.setImgCultivoPublicId(resp.getPublicId());

        AuditableUtils.update(cultivo, "prueba", "prueba");

        return cultivoRepository.save(cultivo);

    }

    @Cacheable(value = "cultivos_admin")
    @Transactional(readOnly = true)
    @Override
    public PageResponse<CultivoAdminDtoResp> getAll(String nombre, Boolean estado, Boolean active, Pageable pageable) {
        Page<CultivoAdminDtoResp> page = cultivoRepository.getAllAdmin(nombre, estado, active, pageable);

        if (page.isEmpty()) {
            throw new NoDatosQueMostrarExecption("No hay cultivos que mostar");
        }

        return PageResponseUtils.CreatePageReponse(page);

    }

    @Transactional(readOnly = true)
    @Override
    public CultivoDtoResp getCultivoPorId(Long id) {

        return cultivoRepository.ObtenerById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("Cultivo no existenete"));
    }

}
