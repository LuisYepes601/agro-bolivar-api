/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.ENTITIES;

import com.nexus.demo.Auditoria;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author luis
 */
@Table(name = "planta")
@Entity()
public class Planta extends Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name
            = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "nombre_cientifico", length = 150)
    private String nombreCientifico;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Column(name = "temperatura_minima")
    private Double temperaturaMinima;

    @Column(name = "temperatura_maxima")
    private Double temperaturaMaxima;

    @Column(name = "temperatura_ideal")
    private Double temperaturaIdeal;

    @Column(name = "humedad_minima")
    private Double humedadMinima;

    @Column(name = "humedad_maxima")
    private Double humedadMaxima;

    @Column(name = "humedad_ideal")
    private Double humedadIdeal;

    @Column(name = "horas_solares_minimas")
    private Double horasSolaresMinimas;

    @Column(name = "horas_solares_maximas")
    private Double horasSolaresMaximas;

    @Column(name = "horas_solares_ideales")
    private Double horasSolaresIdeales;

    @Column(name = "img_planta", length = 255)
    private String imgPlanta;

    @Column(name = "public_id_img_planta", length = 255)
    private String publicIdImgPlanta;

    @Column(name = "precipitacion_minima")
    private Double precipitacionMinima;

    @Column(name = "precipitacion_maxima")
    private Double precipitacionMaxima;

    @Column(name = "precipitacion_ideal")
    private Double precipitacionIdeal;

    @Column(name = "altitud_minima")
    private Double altitudMinima;

    @Column(name = "altitud_maxima")
    private Double altitudMaxima;

    @Column(name = "ph_suelo_minimo")
    private Double phSueloMinimo;

    @Column(name = "ph_suelo_maximo")
    private Double phSueloMaximo;

    @Column(name = "ph_suelo_ideal")
    private Double phSueloIdeal;

    @Column(name = "frecuencia_riego", length = 50)
    private String frecuenciaRiego;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_familia_botanica")
    private FamiliaBotanica familiaBotanica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_genero_planta")
    private GeneroPlanta generoPlanta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_especie")
    private Especie especie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_etapa")
    private Etapa etapa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_produccion")
    private CicloProduccion cicloProduccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_germinacion")
    private CicloGerminacion cicloGerminacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estacion_cultivo")
    private EstacionCultivo estacionCultivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_planta")
    private TipoPlanta tipoPlanta;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "planta")
    private List<Cultivo> cultivos;

    public Planta(Long id, String nombre, String nombreCientifico, String descripcion, Double temperaturaMinima, Double temperaturaMaxima, Double temperaturaIdeal, Double humedadMinima, Double humedadMaxima, Double humedadIdeal, Double horasSolaresMinimas, Double horasSolaresMaximas, Double horasSolaresIdeales, String imgPlanta, String publicIdImgPlanta, Double precipitacionMinima, Double precipitacionMaxima, Double precipitacionIdeal, Double altitudMinima, Double altitudMaxima, Double phSueloMinimo, Double phSueloMaximo, Double phSueloIdeal, String frecuenciaRiego, FamiliaBotanica familiaBotanica, GeneroPlanta generoPlanta, Especie especie, Etapa etapa, CicloProduccion cicloProduccion, CicloGerminacion cicloGerminacion, EstacionCultivo estacionCultivo, TipoPlanta tipoPlanta, List<Cultivo> cultivos, LocalDateTime createAt, LocalDateTime updateAt, LocalDateTime deleteAt, boolean isDelete, String createBy, String creatorName, String updateBy, String updateName, String deleteBy, String deleteName) {
        super(createAt, updateAt, deleteAt, isDelete, createBy, creatorName, updateBy, updateName, deleteBy, deleteName);
        this.id = id;
        this.nombre = nombre;
        this.nombreCientifico = nombreCientifico;
        this.descripcion = descripcion;
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
        this.temperaturaIdeal = temperaturaIdeal;
        this.humedadMinima = humedadMinima;
        this.humedadMaxima = humedadMaxima;
        this.humedadIdeal = humedadIdeal;
        this.horasSolaresMinimas = horasSolaresMinimas;
        this.horasSolaresMaximas = horasSolaresMaximas;
        this.horasSolaresIdeales = horasSolaresIdeales;
        this.imgPlanta = imgPlanta;
        this.publicIdImgPlanta = publicIdImgPlanta;
        this.precipitacionMinima = precipitacionMinima;
        this.precipitacionMaxima = precipitacionMaxima;
        this.precipitacionIdeal = precipitacionIdeal;
        this.altitudMinima = altitudMinima;
        this.altitudMaxima = altitudMaxima;
        this.phSueloMinimo = phSueloMinimo;
        this.phSueloMaximo = phSueloMaximo;
        this.phSueloIdeal = phSueloIdeal;
        this.frecuenciaRiego = frecuenciaRiego;
        this.familiaBotanica = familiaBotanica;
        this.generoPlanta = generoPlanta;
        this.especie = especie;
        this.etapa = etapa;
        this.cicloProduccion = cicloProduccion;
        this.cicloGerminacion = cicloGerminacion;
        this.estacionCultivo = estacionCultivo;
        this.tipoPlanta = tipoPlanta;
        this.cultivos = cultivos;
    }

    public Planta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FamiliaBotanica getFamiliaBotanica() {
        return familiaBotanica;
    }

    public void setFamiliaBotanica(FamiliaBotanica familiaBotanica) {
        this.familiaBotanica = familiaBotanica;
    }

    public GeneroPlanta getGeneroPlanta() {
        return generoPlanta;
    }

    public void setGeneroPlanta(GeneroPlanta generoPlanta) {
        this.generoPlanta = generoPlanta;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    public CicloProduccion getCicloProduccion() {
        return cicloProduccion;
    }

    public void setCicloProduccion(CicloProduccion cicloProduccion) {
        this.cicloProduccion = cicloProduccion;
    }

    public CicloGerminacion getCicloGerminacion() {
        return cicloGerminacion;
    }

    public void setCicloGerminacion(CicloGerminacion cicloGerminacion) {
        this.cicloGerminacion = cicloGerminacion;
    }

    public EstacionCultivo getEstacionCultivo() {
        return estacionCultivo;
    }

    public void setEstacionCultivo(EstacionCultivo estacionCultivo) {
        this.estacionCultivo = estacionCultivo;
    }

    public TipoPlanta getTipoPlanta() {
        return tipoPlanta;
    }

    public void setTipoPlanta(TipoPlanta tipoPlanta) {
        this.tipoPlanta = tipoPlanta;
    }

    public List<Cultivo> getCultivos() {
        return cultivos;
    }

    public void setCultivos(List<Cultivo> cultivos) {
        this.cultivos = cultivos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(Double temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public Double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(Double temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public Double getTemperaturaIdeal() {
        return temperaturaIdeal;
    }

    public void setTemperaturaIdeal(Double temperaturaIdeal) {
        this.temperaturaIdeal = temperaturaIdeal;
    }

    public Double getHumedadMinima() {
        return humedadMinima;
    }

    public void setHumedadMinima(Double humedadMinima) {
        this.humedadMinima = humedadMinima;
    }

    public Double getHumedadMaxima() {
        return humedadMaxima;
    }

    public void setHumedadMaxima(Double humedadMaxima) {
        this.humedadMaxima = humedadMaxima;
    }

    public Double getHumedadIdeal() {
        return humedadIdeal;
    }

    public void setHumedadIdeal(Double humedadIdeal) {
        this.humedadIdeal = humedadIdeal;
    }

    public Double getHorasSolaresMinimas() {
        return horasSolaresMinimas;
    }

    public void setHorasSolaresMinimas(Double horasSolaresMinimas) {
        this.horasSolaresMinimas = horasSolaresMinimas;
    }

    public Double getHorasSolaresMaximas() {
        return horasSolaresMaximas;
    }

    public void setHorasSolaresMaximas(Double horasSolaresMaximas) {
        this.horasSolaresMaximas = horasSolaresMaximas;
    }

    public Double getHorasSolaresIdeales() {
        return horasSolaresIdeales;
    }

    public void setHorasSolaresIdeales(Double horasSolaresIdeales) {
        this.horasSolaresIdeales = horasSolaresIdeales;
    }

    public String getImgPlanta() {
        return imgPlanta;
    }

    public void setImgPlanta(String imgPlanta) {
        this.imgPlanta = imgPlanta;
    }

    public String getPublicIdImgPlanta() {
        return publicIdImgPlanta;
    }

    public void setPublicIdImgPlanta(String publicIdImgPlanta) {
        this.publicIdImgPlanta = publicIdImgPlanta;
    }

    public Double getPrecipitacionMinima() {
        return precipitacionMinima;
    }

    public void setPrecipitacionMinima(Double precipitacionMinima) {
        this.precipitacionMinima = precipitacionMinima;
    }

    public Double getPrecipitacionMaxima() {
        return precipitacionMaxima;
    }

    public void setPrecipitacionMaxima(Double precipitacionMaxima) {
        this.precipitacionMaxima = precipitacionMaxima;
    }

    public Double getPrecipitacionIdeal() {
        return precipitacionIdeal;
    }

    public void setPrecipitacionIdeal(Double precipitacionIdeal) {
        this.precipitacionIdeal = precipitacionIdeal;
    }

    public Double getAltitudMinima() {
        return altitudMinima;
    }

    public void setAltitudMinima(Double altitudMinima) {
        this.altitudMinima = altitudMinima;
    }

    public Double getAltitudMaxima() {
        return altitudMaxima;
    }

    public void setAltitudMaxima(Double altitudMaxima) {
        this.altitudMaxima = altitudMaxima;
    }

    public Double getPhSueloMinimo() {
        return phSueloMinimo;
    }

    public void setPhSueloMinimo(Double phSueloMinimo) {
        this.phSueloMinimo = phSueloMinimo;
    }

    public Double getPhSueloMaximo() {
        return phSueloMaximo;
    }

    public void setPhSueloMaximo(Double phSueloMaximo) {
        this.phSueloMaximo = phSueloMaximo;
    }

    public Double getPhSueloIdeal() {
        return phSueloIdeal;
    }

    public void setPhSueloIdeal(Double phSueloIdeal) {
        this.phSueloIdeal = phSueloIdeal;
    }

    public String getFrecuenciaRiego() {
        return frecuenciaRiego;
    }

    public void setFrecuenciaRiego(String frecuenciaRiego) {
        this.frecuenciaRiego = frecuenciaRiego;
    }

}
