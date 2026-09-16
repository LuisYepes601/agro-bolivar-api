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
import jakarta.persistence.OneToOne;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria_producto")
    private CategoriaProducto categoriaProducto;

    @Column(name = "img_prodcuto", nullable = true)
    private String imgProdcuto;

    @Column(name = "public_id_img_prodcuto", nullable = true)
    private String publicIdImgProdcuto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unidad_medida")
    private UnidadPeso unidadPeso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_informacion_seguridad")
    private InformacionSeguridad informacionSeguridad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_marca_producto")
    private MarcaProducto marcaProducto;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
    private List<DetallePedido> detallePedidos;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_inventario")
    private InventarioProducto inventarioProducto;

    public Producto() {
    }

    public Producto(Long id, String nombre, String descripcion, Double precioUnidad, CategoriaProducto categoriaProducto, String imgProdcuto, String publicIdImgProdcuto, UnidadPeso unidadPeso, InformacionSeguridad informacionSeguridad, MarcaProducto marcaProducto, List<DetallePedido> detallePedidos, InventarioProducto inventarioProducto) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioUnidad = precioUnidad;
        this.categoriaProducto = categoriaProducto;
        this.imgProdcuto = imgProdcuto;
        this.publicIdImgProdcuto = publicIdImgProdcuto;
        this.unidadPeso = unidadPeso;
        this.informacionSeguridad = informacionSeguridad;
        this.marcaProducto = marcaProducto;
        this.detallePedidos = detallePedidos;
        this.inventarioProducto = inventarioProducto;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(Double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public CategoriaProducto getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public String getImgProdcuto() {
        return imgProdcuto;
    }

    public void setImgProdcuto(String imgProdcuto) {
        this.imgProdcuto = imgProdcuto;
    }

    public String getPublicIdImgProdcuto() {
        return publicIdImgProdcuto;
    }

    public void setPublicIdImgProdcuto(String publicIdImgProdcuto) {
        this.publicIdImgProdcuto = publicIdImgProdcuto;
    }

    public UnidadPeso getUnidadPeso() {
        return unidadPeso;
    }

    public void setUnidadPeso(UnidadPeso unidadPeso) {
        this.unidadPeso = unidadPeso;
    }

    public InformacionSeguridad getInformacionSeguridad() {
        return informacionSeguridad;
    }

    public void setInformacionSeguridad(InformacionSeguridad informacionSeguridad) {
        this.informacionSeguridad = informacionSeguridad;
    }

    public MarcaProducto getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(MarcaProducto marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public List<DetallePedido> getDetallePedidos() {
        return detallePedidos;
    }

    public void setDetallePedidos(List<DetallePedido> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }

    public InventarioProducto getInventarioProducto() {
        return inventarioProducto;
    }

    public void setInventarioProducto(InventarioProducto inventarioProducto) {
        this.inventarioProducto = inventarioProducto;
    }

}
