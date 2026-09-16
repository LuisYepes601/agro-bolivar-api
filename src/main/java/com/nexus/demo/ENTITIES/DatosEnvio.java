/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.ENTITIES;

/**
 *
 * @author luis
 */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "datos_envio")
public class DatosEnvio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipoEnvio")
    private TipoEnvio tipoEnvio;

    @Column(name = "mas_detalles", nullable = true)
    private String masDetalles;

    @Column(name = "calle", nullable = true)
    private String calle;

    @Column(name = "costo_envio_aproximado", nullable = true)
    private Double costoEnvioAproximado;

    @Column(name = "empresa_transporte", nullable = true)
    private String empresaTransporte;

    @Column(name = "costo_envio_final", nullable = true)
    private Double costoEnvioFinal;

    @Column(name = "peso_total", nullable = true)
    private Double pesoTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unidad_peso")
    private UnidadPeso unidadPeso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_direccion_origen")
    private Direccion direccionOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_direccion_envio")
    private Direccion direccionEnvio;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "datosEnvio")
    private Pedido pedido;

    public DatosEnvio(Long id, TipoEnvio tipoEnvio, String masDetalles, String calle, Double costoEnvioAproximado, String empresaTransporte, Double costoEnvioFinal, Double pesoTotal, UnidadPeso unidadPeso, Direccion direccionOrigen, Direccion direccionEnvio, Pedido pedido) {
        this.id = id;
        this.tipoEnvio = tipoEnvio;
        this.masDetalles = masDetalles;
        this.calle = calle;
        this.costoEnvioAproximado = costoEnvioAproximado;
        this.empresaTransporte = empresaTransporte;
        this.costoEnvioFinal = costoEnvioFinal;
        this.pesoTotal = pesoTotal;
        this.unidadPeso = unidadPeso;
        this.direccionOrigen = direccionOrigen;
        this.direccionEnvio = direccionEnvio;
        this.pedido = pedido;
    }

    public DatosEnvio() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoEnvio getTipoEnvio() {
        return tipoEnvio;
    }

    public void setTipoEnvio(TipoEnvio tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }

    public String getMasDetalles() {
        return masDetalles;
    }

    public void setMasDetalles(String masDetalles) {
        this.masDetalles = masDetalles;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Double getCostoEnvioAproximado() {
        return costoEnvioAproximado;
    }

    public void setCostoEnvioAproximado(Double costoEnvioAproximado) {
        this.costoEnvioAproximado = costoEnvioAproximado;
    }

    public String getEmpresaTransporte() {
        return empresaTransporte;
    }

    public void setEmpresaTransporte(String empresaTransporte) {
        this.empresaTransporte = empresaTransporte;
    }

    public Double getCostoEnvioFinal() {
        return costoEnvioFinal;
    }

    public void setCostoEnvioFinal(Double costoEnvioFinal) {
        this.costoEnvioFinal = costoEnvioFinal;
    }

    public Double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(Double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public UnidadPeso getUnidadPeso() {
        return unidadPeso;
    }

    public void setUnidadPeso(UnidadPeso unidadPeso) {
        this.unidadPeso = unidadPeso;
    }

    public Direccion getDireccionOrigen() {
        return direccionOrigen;
    }

    public void setDireccionOrigen(Direccion direccionOrigen) {
        this.direccionOrigen = direccionOrigen;
    }

    public Direccion getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(Direccion direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

}
