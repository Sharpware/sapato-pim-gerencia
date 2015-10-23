/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.sport4you.model;

/**
 *
 * @author Christopher
 */
public class Produto {
    
    private long id;
    private String nome;
    private String marca;
    private int quantidade;
    private String tamanho;
    private String codigoBarras;
    private double precoCusto;
    private double precoVenda;

    public long getId() {
        return id;
    }
    public Produto setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }
    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getMarca() {
        return marca;
    }
    public Produto setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public Produto setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public String getTamanho() {
        return tamanho;
    }
    public Produto setTamanho(String tamanho) {
        this.tamanho = tamanho;
        return this;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }
    public Produto setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
        return this;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }
    public Produto setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
        return this;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }
    public Produto setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
        return this;
    }
}
