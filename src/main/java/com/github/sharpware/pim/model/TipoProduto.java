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
public enum TipoProduto {
    CORRIDA_CAMINHADA("CorridaCaminhada"),
    CORRIDA_PERFORMACE("CorridaPerformace"),
    SKATE("Skate"),
    SURF("Surf"),
    CHUTEIRA_SALAO("ChuteiraSalao"),
    CHUTEIRA_CAMPO("ChuteiraCampo"),
    VOLEI("Volei"),
    FITNESS("Fitness"),
    BASQUETE("Basquete");
    
    private String nome;
    
    TipoProduto(String nome) {
        this.nome = nome;
    }
}
