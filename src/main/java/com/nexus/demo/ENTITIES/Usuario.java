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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "usuario",
        indexes = {
            @Index(name = "idx_usuario_primer_nombre", columnList = "primer_nombre"),
            @Index(name = "idx_usuario_email", columnList = "email")
        })
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "primer_nombre", nullable = false)
    private String primerNombre;

    @Column(name = "last_nombre", nullable = false)
    private String segundoNombre;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "apellido_paterno", nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", nullable = true)
    private String apellidoMaterno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol")
    private Rol rol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_documento")
    private TipoDocumento tipoDocumento;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<Pedido> pedidos;

    @Column(name = "contrasenia", nullable = false)
    private String contrasenia;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @Column(name = "img_user", nullable = true)
    private String imgUser;

    @Column(name = "public_id_img_user", nullable = true)
    private String publicIdImgUser;

    @Column(name = "num_documento", nullable = false)
    private String numDocumento;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<Cultivo> cultivos;

    public Usuario() {
    }

    public Usuario(Long id, String primerNombre, String segundoNombre, String email, String apellidoPaterno, String apellidoMaterno, Rol rol, TipoDocumento tipoDocumento, List<Pedido> pedidos, String contrasenia, Boolean estado, String imgUser, String publicIdImgUser, String numDocumento, List<Cultivo> cultivos) {
        this.id = id;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.email = email;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.rol = rol;
        this.tipoDocumento = tipoDocumento;
        this.pedidos = pedidos;
        this.contrasenia = contrasenia;
        this.estado = estado;
        this.imgUser = imgUser;
        this.publicIdImgUser = publicIdImgUser;
        this.numDocumento = numDocumento;
        this.cultivos = cultivos;
    }

  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public List<Cultivo> getCultivos() {
        return cultivos;
    }

    public void setCultivos(List<Cultivo> cultivos) {
        this.cultivos = cultivos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getImgUser() {
        return imgUser;
    }

    public void setImgUser(String imgUser) {
        this.imgUser = imgUser;
    }

    public String getPublicIdImgUser() {
        return publicIdImgUser;
    }

    public void setPublicIdImgUser(String publicIdImgUser) {
        this.publicIdImgUser = publicIdImgUser;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

}
