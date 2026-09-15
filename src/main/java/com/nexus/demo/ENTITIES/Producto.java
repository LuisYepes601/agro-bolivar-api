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
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = true)
    private String descripcion;

    @Column(name = "precio_unidad", nullable = false)
    private Double precioUnidad;

    @Column(name = "id_categoria_producto", nullable = false)
    private Long idCategoriaProducto;

    @Column(name = "img_prodcuto", nullable = true)
    private String imgProdcuto;

    @Column(name = "public_id_img_prodcuto", nullable = true)
    private String publicIdImgProdcuto;

    @Column(name = "id_unidad_medidad", nullable = false)
    private Long idUnidadMedidad;

    @Column(name = "id_info_seguridad", nullable = true)
    private Long idInfoSeguridad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_marca_producto")
    private MarcaProducto marcaProducto;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
    private List<DetallePedido>detallePedidos;

    public Producto() {
    }
}
