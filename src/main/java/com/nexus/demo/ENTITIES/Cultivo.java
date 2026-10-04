/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.ENTITIES;

/**
 *
 * @author luis
 */
import com.nexus.demo.Auditoria;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "cultivo")
public class Cultivo extends Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuariio")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_planta")
    private Planta planta;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_estimada_fin", nullable = true)
    private LocalDate fechaEstimadaFin;

    @Column(name = "cantidad_sembrada", nullable = false)
    private Double cantidadSembrada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unidad_peso")
    private UnidadPeso unidadPeso;

    @Column(name = "area_sembrada", nullable = true)
    private Double areaSembrada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unidad_area")
    private UnidadArea unidadArea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_cultivo")
    private EstadoCultivo estadoCultivo;

    @Column(name = "cantidad_disponible", nullable = true)
    private Double cantidadDisponible;

    @Column(name = "precio_por_kg", nullable = true)
    private Double precioPorKg;

    @Column(name = "cantidad_disponible_para_venta", nullable = true)
    private Double cantidadDisponibleParaVenta;

    @Column(name = "img_cultivo")
    private String imgCultivo;

    @Column(name = "img_cultivo_public_id")
    private String imgCultivoPublicId;

    public Cultivo(Long id, Usuario usuario, Planta planta, LocalDate fechaInicio, LocalDate fechaEstimadaFin, Double cantidadSembrada, UnidadPeso unidadPeso, Double areaSembrada, UnidadArea unidadArea, EstadoCultivo estadoCultivo, Double cantidadDisponible, Double precioPorKg, Double cantidadDisponibleParaVenta, String imgCultivo, String imgCultivoPublicId) {
        this.id = id;
        this.usuario = usuario;
        this.planta = planta;
        this.fechaInicio = fechaInicio;
        this.fechaEstimadaFin = fechaEstimadaFin;
        this.cantidadSembrada = cantidadSembrada;
        this.unidadPeso = unidadPeso;
        this.areaSembrada = areaSembrada;
        this.unidadArea = unidadArea;
        this.estadoCultivo = estadoCultivo;
        this.cantidadDisponible = cantidadDisponible;
        this.precioPorKg = precioPorKg;
        this.cantidadDisponibleParaVenta = cantidadDisponibleParaVenta;
        this.imgCultivo = imgCultivo;
        this.imgCultivoPublicId = imgCultivoPublicId;
    }

    public Cultivo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Planta getPlanta() {
        return planta;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaEstimadaFin() {
        return fechaEstimadaFin;
    }

    public void setFechaEstimadaFin(LocalDate fechaEstimadaFin) {
        this.fechaEstimadaFin = fechaEstimadaFin;
    }

    public Double getCantidadSembrada() {
        return cantidadSembrada;
    }

    public void setCantidadSembrada(Double cantidadSembrada) {
        this.cantidadSembrada = cantidadSembrada;
    }

    public UnidadPeso getUnidadPeso() {
        return unidadPeso;
    }

    public void setUnidadPeso(UnidadPeso unidadPeso) {
        this.unidadPeso = unidadPeso;
    }

    public Double getAreaSembrada() {
        return areaSembrada;
    }

    public void setAreaSembrada(Double areaSembrada) {
        this.areaSembrada = areaSembrada;
    }

    public UnidadArea getUnidadArea() {
        return unidadArea;
    }

    public void setUnidadArea(UnidadArea unidadArea) {
        this.unidadArea = unidadArea;
    }

    public EstadoCultivo getEstadoCultivo() {
        return estadoCultivo;
    }

    public void setEstadoCultivo(EstadoCultivo estadoCultivo) {
        this.estadoCultivo = estadoCultivo;
    }

    public Double getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(Double cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public Double getPrecioPorKg() {
        return precioPorKg;
    }

    public void setPrecioPorKg(Double precioPorKg) {
        this.precioPorKg = precioPorKg;
    }

    public Double getCantidadDisponibleParaVenta() {
        return cantidadDisponibleParaVenta;
    }

    public void setCantidadDisponibleParaVenta(Double cantidadDisponibleParaVenta) {
        this.cantidadDisponibleParaVenta = cantidadDisponibleParaVenta;
    }

    public String getImgCultivo() {
        return imgCultivo;
    }

    public void setImgCultivo(String imgCultivo) {
        this.imgCultivo = imgCultivo;
    }

    public String getImgCultivoPublicId() {
        return imgCultivoPublicId;
    }

    public void setImgCultivoPublicId(String imgCultivoPublicId) {
        this.imgCultivoPublicId = imgCultivoPublicId;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }
}
