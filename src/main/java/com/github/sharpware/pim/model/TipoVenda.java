/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.pim.model;

/**
 *
 * @author RodrigoFelipe
 */
public enum TipoVenda {
    
    DINHEIRO("Dinheiro"),
    CARTAO("Cartao");
    
    private String nome;
    
    TipoVenda(String nome) {
        this.nome = nome;
    }
}
