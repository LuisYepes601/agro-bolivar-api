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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "barrio", nullable = false)
    private String barrio;

    @Column(name = "descripcion", nullable = true)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais")
    private Pais pais;

    @Column(name = "Compemento", nullable = true)
    private String compemento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_direccion")
    private TipoDireccion tipoDireccion;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "direccionOrigen")
    private List<DatosEnvio> enviosComoOrigen;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "direccionEnvio")
    private List<DatosEnvio> enviosComoDestino;

    public Direccion() {
    }

    public Direccion(Long id, String barrio, String descripcion, Pais pais, String compemento, TipoDireccion tipoDireccion, List<DatosEnvio> enviosComoOrigen, List<DatosEnvio> enviosComoDestino) {
        this.id = id;
        this.barrio = barrio;
        this.descripcion = descripcion;
        this.pais = pais;
        this.compemento = compemento;
        this.tipoDireccion = tipoDireccion;
        this.enviosComoOrigen = enviosComoOrigen;
        this.enviosComoDestino = enviosComoDestino;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getCompemento() {
        return compemento;
    }

    public void setCompemento(String compemento) {
        this.compemento = compemento;
    }

    public TipoDireccion getTipoDireccion() {
        return tipoDireccion;
    }

    public void setTipoDireccion(TipoDireccion tipoDireccion) {
        this.tipoDireccion = tipoDireccion;
    }

    public List<DatosEnvio> getEnviosComoOrigen() {
        return enviosComoOrigen;
    }

    public void setEnviosComoOrigen(List<DatosEnvio> enviosComoOrigen) {
        this.enviosComoOrigen = enviosComoOrigen;
    }

    public List<DatosEnvio> getEnviosComoDestino() {
        return enviosComoDestino;
    }

    public void setEnviosComoDestino(List<DatosEnvio> enviosComoDestino) {
        this.enviosComoDestino = enviosComoDestino;
    }
}
