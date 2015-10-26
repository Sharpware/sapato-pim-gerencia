package com.github.sharpware.pim.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Estoque {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@OneToMany
	@JoinColumn(name="produto_id")
	private List<Produto> produtos;
	
	@Column(name="quantidade")
	private int quantidade;
	
	@Column(name="data_entrada")
	private LocalDate dataEntrada;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	public Estoque setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
		return this;
	}

	public int getQuantidade() {
		return quantidade;
	}
	public Estoque setQuantidade(int quantidade) {
		this.quantidade = quantidade;
		return this;
	}


}
