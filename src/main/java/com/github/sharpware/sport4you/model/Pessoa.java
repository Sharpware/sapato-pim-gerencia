package com.github.sharpware.sport4you.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Pessoa {
    
    private long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String observacao;
    private String email;
    private Endereco endereco;
    private List<Telefone> telefones;

    public Pessoa() {
        telefones = new ArrayList<>();
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
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public void addTelefone(Telefone telefone) {
        telefones.add(telefone);
    }
}
