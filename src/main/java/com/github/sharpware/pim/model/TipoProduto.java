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
	CorridaCaminhada("CorridaCaminhada"),
	CorridaPerformace("CorridaPerformace"),
	Skate("Skate"),
	Surf("Surf"),
	ChuteiraSalao("ChuteiraSalao"),
	ChuteiraCampo("ChuteiraCampo"),
	Volei("Volei"),
	Fitness("Fitness"),
	Basquete("Basquete");
    
    private String nome;
    
    TipoProduto(String nome) {
        this.nome = nome;
    }
}
