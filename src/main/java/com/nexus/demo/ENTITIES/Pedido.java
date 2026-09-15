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
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "subtotal", nullable = false)
    private Double subtotal;

    @Column(name = "precio_total", nullable = false)
    private Double precioTotal;

    @Column(name = "total_items", nullable = false)
    private Integer totalItems;

    @Column(name = "id_estado_pedido", nullable = false)
    private Long idEstadoPedido;

    @Column(name = "id_datos_envio", nullable = true)
    private Long idDatosEnvio;

    @Column(name = "aplicableFree", nullable = false)
    private Boolean aplicableFree;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido")
    private List<DetallePedido> detallePedidos;

    public Pedido() {
    }
}
