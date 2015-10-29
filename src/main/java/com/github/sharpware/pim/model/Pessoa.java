package com.github.sharpware.pim.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

@MappedSuperclass
public abstract class Pessoa<T> {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="nome")
    private String nome;
    
    @Column(name="cpf")
    private String cpf;
    
    @Temporal(TemporalType.DATE)
    @Column(name="data_nascimento")
    private Calendar dataNascimento;
    
    @Column(name="descricao")
    private String descricao;
    
    @Column(name="email")
    private String email;
    
    @Enumerated(EnumType.STRING)
    @Column(name="situacao")
    private Situacao situacao;
    
    @Embedded
    private Endereco endereco;
    
    @OneToMany
    @JoinColumn(name="id_telefone")
    private List<Telefone> telefones;

    public Pessoa() {
        this.telefones = new ArrayList<>();
    }
    
    public Long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public T setNome(String nome) {
        this.nome = nome;
        return (T) this;
    }

    public String getCpf() {
        return cpf;
    }
    
	public T setCpf(String cpf) {
        this.cpf = cpf;
        return (T) this;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }
    public T setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
        return (T) this;
    }

    public String getDescricao() {
        return descricao;
    }
    public T setDescricao(String descricao) {
        this.descricao = descricao;
        return (T) this;
    }

    public String getEmail() {
        return email;
    }
    public T setEmail(String email) {
        this.email = email;
        return (T) this;
    }
    
    public Situacao getSituacao() {
		return situacao;
	}
	public T setSituacao(Situacao situacao) {
		this.situacao = situacao;
		return (T) this;
	}
    
    public Endereco getEndereco() {
        return endereco;
    }
    public T setEndereco(Endereco endereco) {
        this.endereco = endereco;
        return (T) this;
    }
    
    public T addTelefone(Telefone telefone) {
        this.telefones.add(telefone);
        return (T) this;
    }
}
