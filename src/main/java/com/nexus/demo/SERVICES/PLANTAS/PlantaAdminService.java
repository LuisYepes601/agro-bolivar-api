/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nexus.demo.SERVICES.PLANTAS;

import com.nexus.demo.AuditableUtils;
import com.nexus.demo.DTOS.GLOBAL.CloudinaryUploadResponse;
import com.nexus.demo.DTOS.REQUEST.PLANTA.PlantaDtoReq;
import com.nexus.demo.DatoNoExistenteEcxeption;
import com.nexus.demo.DatoYaExistenteException;
import com.nexus.demo.ENTITIES.Planta;
import com.nexus.demo.GLOBALEXCEPTIONHANDLER.exceptions.DatoInvalidoEcxeption;
import com.nexus.demo.REPOSITORY.CicloGerminacionRepository;
import com.nexus.demo.REPOSITORY.CicloProduccionRepository;
import com.nexus.demo.REPOSITORY.EspecieRepository;
import com.nexus.demo.REPOSITORY.EstacionCultivoRepository;
import com.nexus.demo.REPOSITORY.FamiliaBotanicaRepository;
import com.nexus.demo.REPOSITORY.GeneroPlantaRepository;
import com.nexus.demo.REPOSITORY.PlantaRepository;
import com.nexus.demo.REPOSITORY.TipoPlantaRepository;
import com.nexus.demo.SERVICES.CLOUDINARY.ICloudinaryService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author luis
 */
@Service
public class PlantaAdminService implements IPlantaAdminService {

    private PlantaRepository plantaRepo;

    private EspecieRepository especieRepo;

    private GeneroPlantaRepository genPlantaRepo;

    private TipoPlantaRepository tipoPlantaRepo;

    private CicloGerminacionRepository cicloGerRepo;

    private CicloProduccionRepository cicloProdRepo;

    private EstacionCultivoRepository estacionCultRepo;

    private FamiliaBotanicaRepository famBotRepo;

    private ICloudinaryService cloudinaryService;

    @Autowired
    public PlantaAdminService(PlantaRepository plantaRepo, EspecieRepository especieRepo, GeneroPlantaRepository genPlantaRepo, TipoPlantaRepository tipoPlantaRepo, CicloGerminacionRepository cicloGerRepo, CicloProduccionRepository cicloProdRepo, EstacionCultivoRepository estacionCultRepo, FamiliaBotanicaRepository famBotRepo, ICloudinaryService cloudinaryService) {
        this.plantaRepo = plantaRepo;
        this.especieRepo = especieRepo;
        this.genPlantaRepo = genPlantaRepo;
        this.tipoPlantaRepo = tipoPlantaRepo;
        this.cicloGerRepo = cicloGerRepo;
        this.cicloProdRepo = cicloProdRepo;
        this.estacionCultRepo = estacionCultRepo;
        this.famBotRepo = famBotRepo;
        this.cloudinaryService = cloudinaryService;
    }

    @Caching(evict = {
        @CacheEvict(value = "plantas-admin", allEntries = true),
        @CacheEvict(value = "plantas", allEntries = true)

    })
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Planta create(PlantaDtoReq plantaDtoReq, MultipartFile fotoPlanta) {

        Planta planta = new Planta();

        planta.setCicloGerminacion(cicloGerRepo.findById(plantaDtoReq.getIdCicloGerminacion())
                .orElseThrow(()
                        -> new DatoNoExistenteEcxeption("El ciclo de germinacion no existe en el sistema")));

        planta.setCicloProduccion(cicloProdRepo.findById(plantaDtoReq.getIdCicloProduccion())
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El ciclo de producción no existe en el sistema")));

        planta.setEspecie(especieRepo.findById(plantaDtoReq.getIdEspecie())
                .orElseThrow(() -> new DatoNoExistenteEcxeption("La especie de planta no existe en el sistema")));

        planta.setEstacionCultivo(estacionCultRepo.findById(plantaDtoReq.getIdEstacionCultivo())
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El tipo de estación de cultivo no existe en el sistema")));

        planta.setFamiliaBotanica(famBotRepo.findById(plantaDtoReq.getIdFamiliaBotanica())
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El tipo de familia botanica no existe en el sistema")));

        planta.setGeneroPlanta(genPlantaRepo.findById(plantaDtoReq.getIdGeneroPlanta())
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El genero de planta no existe en el sistema")));

        planta.setTipoPlanta(tipoPlantaRepo.findById(plantaDtoReq.getIdTipoPlanta())
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El tipo de planta no existe en el sistema")));

        Optional<Planta> existe = plantaRepo.existeAndEstaActivo(plantaDtoReq.getNombre().trim());

        if (existe.isPresent()) {

            throw new DatoYaExistenteException("La planta ya existe en el sistema y se encuentra activa actualmente");
        }

        planta.setNombre(plantaDtoReq.getNombre().trim());

        planta.setNombreCientifico(plantaDtoReq.getNombreCientifico().trim());

        if (plantaDtoReq.getDescripcion() != null) {

            plantaDtoReq.setDescripcion(plantaDtoReq.getDescripcion().trim());
        }

        //TEMPERATURA
        if (plantaDtoReq.getTemperaturaMinima() > plantaDtoReq.getTemperaturaMaxima()) {

            throw new DatoInvalidoEcxeption("La temperatura minima no debe de ser mayor a la temperatura maxima");
        }
        planta.setTemperaturaMinima(plantaDtoReq.getTemperaturaMinima());

        if (plantaDtoReq.getTemperaturaMaxima() > plantaDtoReq.getTemperaturaIdeal()) {

            throw new DatoInvalidoEcxeption("La temperatura ideal no puede ser mayor que la temperatura maxima");
        }

        planta.setTemperaturaMaxima(plantaDtoReq.getTemperaturaMaxima());
        planta.setTemperaturaIdeal(plantaDtoReq.getTemperaturaIdeal());

        //HUMEDAD
        if (plantaDtoReq.getHumedadMinima() > plantaDtoReq.getHumedadMaxima()) {

            throw new DatoInvalidoEcxeption("La humenadad minima no puede ser mayor a la unidad maxima");

        }

        if (plantaDtoReq.getHumedadIdeal() > plantaDtoReq.getHumedadMaxima()) {

            throw new DatoInvalidoEcxeption("La humedad ideal no puede ser mayor a la unidad maxima");
        }

        if (plantaDtoReq.getHumedadIdeal() < plantaDtoReq.getHumedadMinima()) {
            throw new DatoInvalidoEcxeption("La humedad ideal no puede ser menor a la humedad minima");
        }
        planta.setHumedadMinima(plantaDtoReq.getHumedadMinima());

        planta.setHumedadIdeal(plantaDtoReq.getHumedadIdeal());
        planta.setHumedadMaxima(plantaDtoReq.getHumedadMaxima());

        //HORAS SOLARES
        if (plantaDtoReq.getHorasSolaresMinimas() > plantaDtoReq.getHorasSolaresMaximas()) {

            throw new DatoInvalidoEcxeption("Las horas solares minimas no pueden ser mayor las horas solares "
                    + "máximas");
        }

        if (plantaDtoReq.getHorasSolaresMaximas() < plantaDtoReq.getHorasSolaresIdeales()) {

            throw new DatoInvalidoEcxeption("Las horas solares maxima sno pueden ser mayor a las ideales");
        }

        if (plantaDtoReq.getHorasSolaresIdeales() < plantaDtoReq.getHorasSolaresMinimas()) {
            throw new DatoInvalidoEcxeption("La horas solares idelaes tienen que ser iguales o mayores a las minimas");
        }

        planta.setHorasSolaresIdeales(plantaDtoReq.getHorasSolaresIdeales());
        planta.setHorasSolaresMaximas(plantaDtoReq.getHorasSolaresMaximas());
        planta.setHorasSolaresMinimas(plantaDtoReq.getHorasSolaresMinimas());

        //PRECIPITACIÓN
        if (plantaDtoReq.getPrecipitacionMinima() < plantaDtoReq.getPrecipitacionMaxima()) {

            throw new DatoInvalidoEcxeption("La precipitación minima no puede ser mayor a la máxima");
        }

        if (plantaDtoReq.getPrecipitacionIdeal() > plantaDtoReq.getPrecipitacionMaxima()) {
            throw new DatoInvalidoEcxeption("La precipitación ideal no puede ser mayor que la máxima");
        }

        if (plantaDtoReq.getPrecipitacionIdeal() < plantaDtoReq.getPrecipitacionMinima()) {

            throw new DatoInvalidoEcxeption("La precipitación ideal no puede ser menor que la minima");
        }

        planta.setPrecipitacionIdeal(plantaDtoReq.getPrecipitacionIdeal());
        planta.setPrecipitacionMaxima(plantaDtoReq.getPrecipitacionMaxima());
        planta.setPrecipitacionMinima(plantaDtoReq.getPrecipitacionMinima());

        //ALTITUD
        if (plantaDtoReq.getAltitudMinima() > plantaDtoReq.getAltitudMaxima()) {

            throw new DatoInvalidoEcxeption("La altitud minima no puede ser mayor a la máxima");
        }

        planta.setAltitudMinima(plantaDtoReq.getAltitudMinima());
        planta.setAltitudMaxima(plantaDtoReq.getAltitudMaxima());

        //PH SUELO
        if (plantaDtoReq.getPhSueloMinimo() > plantaDtoReq.getPhSueloMaximo()) {

            throw new DatoInvalidoEcxeption("El PH de suelo minimo no puede ser mayor que el máximo");

        }

        if (plantaDtoReq.getPhSueloIdeal() > plantaDtoReq.getPhSueloMaximo()) {

            throw new DatoInvalidoEcxeption("El PH ideal no puede ser mayor que el máximo");
        }

        if (plantaDtoReq.getPhSueloIdeal() < plantaDtoReq.getPhSueloMinimo()) {
            throw new DatoInvalidoEcxeption("El PH del suelo ideal no puede ser menor que el minimo.");
        }

        planta.setPhSueloIdeal(plantaDtoReq.getPhSueloIdeal());
        planta.setPhSueloMaximo(plantaDtoReq.getPhSueloMaximo());
        planta.setPhSueloMinimo(plantaDtoReq.getPhSueloMinimo());

        planta.setFrecuenciaRiego(plantaDtoReq.getFrecuenciaRiego().trim());

        AuditableUtils.create(planta, "prueba", "prueba");

        if (fotoPlanta != null) {

            CloudinaryUploadResponse response = cloudinaryService.uploadPrymaryFotoPlant(fotoPlanta, plantaDtoReq.getNombre().trim(),
                    fotoPlanta.getOriginalFilename());

            planta.setImgPlanta(response.getSecureUrl());
            planta.setPublicIdImgPlanta(response.getPublicId());
        }

        return plantaRepo.save(planta);

    }

}
