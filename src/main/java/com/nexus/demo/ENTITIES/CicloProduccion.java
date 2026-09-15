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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "ciclo_produccion")
public class CicloProduccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private Integer diasMinimos;

    @Column(nullable = true)
    private Integer diasMaximos;

    @Column(nullable = true, length = 200)
    private String descripcion;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cicloProduccion")
    private List<Planta> plantas;

    public CicloProduccion(Long id, Integer diasMinimos, Integer diasMaximos, String descripcion, List<Planta> plantas) {
        this.id = id;
        this.diasMinimos = diasMinimos;
        this.diasMaximos = diasMaximos;
        this.descripcion = descripcion;
        this.plantas = plantas;
    }

    public CicloProduccion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDiasMinimos() {
        return diasMinimos;
    }

    public void setDiasMinimos(Integer diasMinimos) {
        this.diasMinimos = diasMinimos;
    }

    public Integer getDiasMaximos() {
        return diasMaximos;
    }

    public void setDiasMaximos(Integer diasMaximos) {
        this.diasMaximos = diasMaximos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Planta> getPlantas() {
        return plantas;
    }

    public void setPlantas(List<Planta> plantas) {
        this.plantas = plantas;
    }
}
