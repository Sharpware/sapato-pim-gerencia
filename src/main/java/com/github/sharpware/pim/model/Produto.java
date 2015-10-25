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
@Table(name="produto")
@SecondaryTable(name="lista_preco", 
				pkJoinColumns = { @PrimaryKeyJoinColumn(name = "id") })
public class Produto {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    
    @Column(name="nome")
    private String nome;
    
    @Column(name="marca")
    private String marca;
    
    @Column(name="tamanho")
    private String tamanho;
    
    @Column(name="codigo_barras")
    private String codigoBarras;
    
    @Column(name="preco_custo")
    private double precoCusto;
    
    @Column(table="lista_preco", name="preco_venda")
    private double precoVenda;

    @Enumerated(EnumType.STRING)
    @Column(name="tipo_produto")
    private TipoProduto tipoProtudo;

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
    
    public TipoProduto getTipoProtudo() {
        return tipoProtudo;
    }
    public Produto setTipoProtudo(TipoProduto tipoProtudo) {
        this.tipoProtudo = tipoProtudo;
        return this;
    }
}
