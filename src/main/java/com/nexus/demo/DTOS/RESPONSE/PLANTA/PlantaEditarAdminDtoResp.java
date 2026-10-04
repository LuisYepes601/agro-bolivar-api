/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.RESPONSE.PLANTA;

/**
 *
 * @author luis
 */
public class PlantaEditarAdminDtoResp {

    private Long id;

    private String nombre;

    private String nombre_cientifico;

    private String descripcion;

    private Double temperaturaMinima;

    private Double temperaturaMaxima;

    private Double temperaturaIdeal;

    private Double humedadMinima;

    private Double humedadMaxima;

    private Double humedadIdeal;

    private Double horasSolaresMinimas;

    private Double horasSolaresMaximas;

    private Double horasSolaresIdeales;

    private Double precipitacionMinima;

    private Double precipitacionMaxima;

    private Double precipitacionIdeal;

    private Double altitudMinima;

    private Double altitudMaxima;

    private Double phSueloMinimo;

    private Double phSueloMaximo;

    private Double phSueloIdeal;

    private String frecuenciaRiego;

    private Long id_familia_botanica;

    private String nombre_familia_botanica;

    private Long id_genero_planta;

    private String nombre_genero;

    private Long id_especie;

    private String nombre_especie;

    private Long id_ciclo_produccion;

    private String nombre_ciclo_produccion;

    private Long id_ciclo_germinacion;

    private String nombre_ciclo_germinacion;

    private Long id_estacion_cultivo;

    private String nombre_estacion_cultivo;

    private Long id_tipo_planta;

    private String nombre_tipo_planta;

    public PlantaEditarAdminDtoResp(Long id, String nombre, String nombre_cientifico, String descripcion, Double temperaturaMinima, Double temperaturaMaxima, Double temperaturaIdeal, Double humedadMinima, Double humedadMaxima, Double humedadIdeal, Double horasSolaresMinimas, Double horasSolaresMaximas, Double horasSolaresIdeales, Double precipitacionMinima, Double precipitacionMaxima, Double precipitacionIdeal, Double altitudMinima, Double altitudMaxima, Double phSueloMinimo, Double phSueloMaximo, Double phSueloIdeal, String frecuenciaRiego, Long id_familia_botanica, String nombre_familia_botanica, Long id_genero_planta, String nombre_genero, Long id_especie, String nombre_especie, Long id_ciclo_produccion, String nombre_ciclo_produccion, Long id_ciclo_germinacion, String nombre_ciclo_germinacion, Long id_estacion_cultivo, String nombre_estacion_cultivo, Long id_tipo_planta, String nombre_tipo_planta) {
        this.id = id;
        this.nombre = nombre;
        this.nombre_cientifico = nombre_cientifico;
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
        this.precipitacionMinima = precipitacionMinima;
        this.precipitacionMaxima = precipitacionMaxima;
        this.precipitacionIdeal = precipitacionIdeal;
        this.altitudMinima = altitudMinima;
        this.altitudMaxima = altitudMaxima;
        this.phSueloMinimo = phSueloMinimo;
        this.phSueloMaximo = phSueloMaximo;
        this.phSueloIdeal = phSueloIdeal;
        this.frecuenciaRiego = frecuenciaRiego;
        this.id_familia_botanica = id_familia_botanica;
        this.nombre_familia_botanica = nombre_familia_botanica;
        this.id_genero_planta = id_genero_planta;
        this.nombre_genero = nombre_genero;
        this.id_especie = id_especie;
        this.nombre_especie = nombre_especie;
        this.id_ciclo_produccion = id_ciclo_produccion;
        this.nombre_ciclo_produccion = nombre_ciclo_produccion;
        this.id_ciclo_germinacion = id_ciclo_germinacion;
        this.nombre_ciclo_germinacion = nombre_ciclo_germinacion;
        this.id_estacion_cultivo = id_estacion_cultivo;
        this.nombre_estacion_cultivo = nombre_estacion_cultivo;
        this.id_tipo_planta = id_tipo_planta;
        this.nombre_tipo_planta = nombre_tipo_planta;
    }

    public PlantaEditarAdminDtoResp() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre_cientifico() {
        return nombre_cientifico;
    }

    public void setNombre_cientifico(String nombre_cientifico) {
        this.nombre_cientifico = nombre_cientifico;
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

    public Long getId_familia_botanica() {
        return id_familia_botanica;
    }

    public void setId_familia_botanica(Long id_familia_botanica) {
        this.id_familia_botanica = id_familia_botanica;
    }

    public String getNombre_familia_botanica() {
        return nombre_familia_botanica;
    }

    public void setNombre_familia_botanica(String nombre_familia_botanica) {
        this.nombre_familia_botanica = nombre_familia_botanica;
    }

    public Long getId_genero_planta() {
        return id_genero_planta;
    }

    public void setId_genero_planta(Long id_genero_planta) {
        this.id_genero_planta = id_genero_planta;
    }

    public String getNombre_genero() {
        return nombre_genero;
    }

    public void setNombre_genero(String nombre_genero) {
        this.nombre_genero = nombre_genero;
    }

    public Long getId_especie() {
        return id_especie;
    }

    public void setId_especie(Long id_especie) {
        this.id_especie = id_especie;
    }

    public String getNombre_especie() {
        return nombre_especie;
    }

    public void setNombre_especie(String nombre_especie) {
        this.nombre_especie = nombre_especie;
    }

    public Long getId_ciclo_produccion() {
        return id_ciclo_produccion;
    }

    public void setId_ciclo_produccion(Long id_ciclo_produccion) {
        this.id_ciclo_produccion = id_ciclo_produccion;
    }

    public String getNombre_ciclo_produccion() {
        return nombre_ciclo_produccion;
    }

    public void setNombre_ciclo_produccion(String nombre_ciclo_produccion) {
        this.nombre_ciclo_produccion = nombre_ciclo_produccion;
    }

    public Long getId_ciclo_germinacion() {
        return id_ciclo_germinacion;
    }

    public void setId_ciclo_germinacion(Long id_ciclo_germinacion) {
        this.id_ciclo_germinacion = id_ciclo_germinacion;
    }

    public String getNombre_ciclo_germinacion() {
        return nombre_ciclo_germinacion;
    }

    public void setNombre_ciclo_germinacion(String nombre_ciclo_germinacion) {
        this.nombre_ciclo_germinacion = nombre_ciclo_germinacion;
    }

    public Long getId_estacion_cultivo() {
        return id_estacion_cultivo;
    }

    public void setId_estacion_cultivo(Long id_estacion_cultivo) {
        this.id_estacion_cultivo = id_estacion_cultivo;
    }

    public String getNombre_estacion_cultivo() {
        return nombre_estacion_cultivo;
    }

    public void setNombre_estacion_cultivo(String nombre_estacion_cultivo) {
        this.nombre_estacion_cultivo = nombre_estacion_cultivo;
    }

    public Long getId_tipo_planta() {
        return id_tipo_planta;
    }

    public void setId_tipo_planta(Long id_tipo_planta) {
        this.id_tipo_planta = id_tipo_planta;
    }

    public String getNombre_tipo_planta() {
        return nombre_tipo_planta;
    }

    public void setNombre_tipo_planta(String nombre_tipo_planta) {
        this.nombre_tipo_planta = nombre_tipo_planta;
    }

}
