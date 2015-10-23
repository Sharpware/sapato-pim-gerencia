package com.github.sharpware.pim.model;

import javax.persistence.*;

@Embeddable
public class Endereco {
    
    @Column(name="logradouro")
    private String logradouro;
    
    @Column(name="numero")
    private int numero;
    
    @Column(name="cep")
    private String cep;
    
    @Column(name="complemento")
    private String complemento;
    
    @Column(name="bairro")
    private String bairro;
    
    @Column(name="cidade")
    private String cidade;
    
    @Column(name="uf")
    private String uf;

    public String getLogradouro() {
        return logradouro;
    }
    public Endereco setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public int getNumero() {
        return numero;
    }
    public Endereco setNumero(int numero) {
        this.numero = numero;
        return this;
    }

    public String getCep() {
        return cep;
    }
    public Endereco setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String getComplemento() {
        return complemento;
    }
    public Endereco setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public String getBairro() {
        return bairro;
    }
    public Endereco setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getCidade() {
        return cidade;
    }
    public Endereco setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String getUf() {
        return uf;
    }
    public Endereco setUf(String uf) {
        this.uf = uf;
        return this;
    }
}
