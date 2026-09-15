/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.ENTITIES;

/**
 *
 * @author luis
 */
import jakarta.persistence.*;

@Entity
@Table(name = "textura_tipo_suelo",
        indexes = {
            @Index(name = "idx_textura_tipo_suelo_id_tipo_suelo", columnList = "id_tipo_suelo"),
            @Index(name = "idx_textura_tipo_suelo_id_textura_suelo", columnList = "id_textura_suelo"),
            @Index(name = "idx_textura_tipo_suelo_id_tipo_suelo_id_textura_suelo",
                    columnList = "id_tipo_suelo,id_textura_suelo")

        })
public class TexturaTipoSuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_suelo")
    private TipoSuelo tipoSuelo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_textura_suelo")
    private TexturaSuelo texturaSuelo;

    public TexturaTipoSuelo(Long id, TipoSuelo tipoSuelo, TexturaSuelo texturaSuelo) {
        this.id = id;
        this.tipoSuelo = tipoSuelo;
        this.texturaSuelo = texturaSuelo;
    }

    // Constructor
    public TexturaTipoSuelo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoSuelo getTipoSuelo() {
        return tipoSuelo;
    }

    public void setTipoSuelo(TipoSuelo tipoSuelo) {
        this.tipoSuelo = tipoSuelo;
    }

    public TexturaSuelo getTexturaSuelo() {
        return texturaSuelo;
    }

    public void setTexturaSuelo(TexturaSuelo texturaSuelo) {
        this.texturaSuelo = texturaSuelo;
    }

}
