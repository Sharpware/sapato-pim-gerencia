package com.github.sharpware.pim.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.*;

@MappedSuperclass
public abstract class Pessoa<T> implements Serializable {
    
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
    
    @Column(name="observacao", columnDefinition = "text")
    private String observacao;
    
    @Column(name="email")
    private String email;
    
    @Enumerated(EnumType.STRING)
    @Column(name="situacao")
    private Situacao situacao;
    
    @Embedded
    private Endereco endereco;
    
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
    
    public String getObservacao() {
        return observacao;
    }
    public T setObservacao(String observacao) {
        this.observacao = observacao;
        return (T) this;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }
    public T setEndereco(Endereco endereco) {
        this.endereco = endereco;
        return (T) this;
    }
}
