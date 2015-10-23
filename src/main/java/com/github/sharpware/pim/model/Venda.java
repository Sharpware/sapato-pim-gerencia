/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.pim.model;

import java.time.LocalDate;
import javax.persistence.*;

/**
 *
 * @author RodrigoFelipe
 */
@Entity
public class Venda {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    
    @Column(name="data")
    private LocalDate data;
    
    @Column(name="valor_total")
    private double valorTotal;
    
    @OneToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
    
    @OneToOne
    @JoinColumn(name="funcionario_id")
    private Funcionario funcionario;
    
    @OneToMany
    @JoinColumn(name="item_venda")
    private ItemVenda itemVenda;
    
    @Enumerated(EnumType.STRING)
    @Column(name="tipo_venda")
    private TipoVenda tipoVenda;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }
    public Venda setData(LocalDate data) {
        this.data = data;
        return this;
    }

    public double getValorTotal() {
        return valorTotal;
    }
    public Venda setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public Venda setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
    public Venda setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
        return this;
    }

    public ItemVenda getItemVenda() {
        return itemVenda;
    }
    public Venda setItemVenda(ItemVenda itemVenda) {
        this.itemVenda = itemVenda;
        return this;
    }

    public TipoVenda getTipoVenda() {
        return tipoVenda;
    }
    public Venda setTipoVenda(TipoVenda tipoVenda) {
        this.tipoVenda = tipoVenda;
        return this;
    }
}
