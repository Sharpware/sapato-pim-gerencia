package com.github.sharpware.pim.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@MappedSuperclass
public abstract class Pessoa<T> {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    
    @Column(name="nome")
    private String nome;
    
    @Column(name="cpf")
    private String cpf;
    
    @Column(name="data_nascimento")
    private LocalDate dataNascimento;
    
    @Column(name="observacao")
    private String observacao;
    
    @Column(name="email")
    private String email;
    
    @Enumerated(EnumType.STRING)
    @Column(name="situacao")
    private Situacao situacao;
    
    @Embedded
    private Endereco endereco;
    
    @OneToMany
    @JoinColumn(name="telefone")
    private List<Telefone> telefones;

    public Pessoa() {
        this.telefones = new ArrayList<>();
    }
    
    public long getId() {
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public T setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return (T) this;
    }

    public String getObservacao() {
        return observacao;
    }
    public T setObservacao(String observacao) {
        this.observacao = observacao;
        return (T) this;
    }

    public String getEmail() {
        return email;
    }
    public T setEmail(String email) {
        this.email = email;
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
