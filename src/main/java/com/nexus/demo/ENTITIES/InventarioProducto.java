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
import jakarta.persistence.Table;

/**
 *
 * @author luis
 */
@Table(name = "inventario_producto")
@Entity()
public class InventarioProducto extends Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad_minima")
    private Double cantidadMinima;

    @Column(name = "cantidad_maxima")
    private Double cantidadMax;

    @Column(name = "cantidad_actual")
    private Double cantActual;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_inventario")
    private Inventario inventario;

    public InventarioProducto(Long id, Double cantidadMinima, Double cantidadMax, Double cantActual, Producto producto, Inventario inventario) {
        this.id = id;
        this.cantidadMinima = cantidadMinima;
        this.cantidadMax = cantidadMax;
        this.cantActual = cantActual;
        this.producto = producto;
        this.inventario = inventario;
    }

    public InventarioProducto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(Double cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public Double getCantidadMax() {
        return cantidadMax;
    }

    public void setCantidadMax(Double cantidadMax) {
        this.cantidadMax = cantidadMax;
    }

    public Double getCantActual() {
        return cantActual;
    }

    public void setCantActual(Double cantActual) {
        this.cantActual = cantActual;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

}
