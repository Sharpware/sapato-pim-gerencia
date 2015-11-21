/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.pim.model;

/**
 *
 * @author George
 */
public enum TipoFuncionario {
    
    CAIXA("Caixa"),
    VENDEDOR("Vendedor"),
    GERENTE("Gerente");
    
    private String nome;
    
    TipoFuncionario(String nome) {
        this.nome = nome;
    }
}
