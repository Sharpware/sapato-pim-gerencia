/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.pim.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Christopher
 */
@Entity
@Table(name="telefone")
public class Telefone implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="numero")
    private String numero;
    
    @Enumerated(EnumType.STRING)
    @Column(name="tipo_telefone")
    private TipoTelefone tipoTelefone;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }
    public Telefone setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }
    public Telefone setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
        return this;
    }
}
