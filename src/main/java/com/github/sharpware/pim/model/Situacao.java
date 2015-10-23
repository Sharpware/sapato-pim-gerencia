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
public enum Situacao {
    ATIVO("Ativo"),
    INATIVO("Inativo");

    private final String nome;
    
    private Situacao(String nome) {
        this.nome = nome;
    }
}
