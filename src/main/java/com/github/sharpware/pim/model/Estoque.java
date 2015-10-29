package com.github.sharpware.pim.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @OneToMany
    @JoinColumn(name="id_produto")
    private List<Produto> produtos;

    @Column(name="quantidade")
    private int quantidade;

    @Temporal(TemporalType.DATE)
    @Column(name="data_entrada")
    private Calendar dataEntrada;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
    public Estoque addProduto(Produto produto) {
        produtos.add(produto);
        return this;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    public Estoque setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        return this;
    }
    
    public Calendar getDataEntrada() {
        return dataEntrada;
    }
    public Estoque setDataEntrada(Calendar dataEntrada) {
        this.dataEntrada = dataEntrada;
        return this;
    }
}
