/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.pim.model;

import javax.persistence.*;

/**
 *
 * @author Christopher
 */
@Entity
public class Telefone {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    
    @Column(name="numero")
    private String numero;
    
    @Enumerated
    @Column(name="tipo_telefone")
    private TipoTelefone tipoTelefone;
}
