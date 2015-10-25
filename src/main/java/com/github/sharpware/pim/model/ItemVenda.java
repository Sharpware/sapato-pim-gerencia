/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.pim.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

/**
 *
 * @author RodrigoFelipe
 */
@Entity
public class ItemVenda {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name="data")
    private LocalDate data;
    
    @Column(name="valor_total")
    private double valorTotal;

    @OneToOne
    @JoinColumn(name="produto_id")
    private Produto produto;
    
    @Column(name="quantidade")
    private int quantidade;
    
    public long getId() {
        return id;
    }
    public ItemVenda setId(long id) {
        this.id = id;
        return this;
    }
    
    public LocalDate getData() {
        return data;
    }
    public ItemVenda setData(LocalDate data) {
        this.data = data;
        return this;
    }

    public double getValorTotal() {
        return valorTotal;
    }
    public ItemVenda setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }
    
	public int getQuantidade() {
		return quantidade;
	}
	public ItemVenda setQuantidade(int quantidade) {
		this.quantidade = quantidade;
		return this;
	}
}
