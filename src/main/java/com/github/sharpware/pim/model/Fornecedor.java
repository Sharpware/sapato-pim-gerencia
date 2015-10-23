package com.github.sharpware.pim.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Fornecedor {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    
    @Column(name="razao_social")
    private String razaoSocial;
    
    @Column(name="nome_fantasia")
    private String nomeFantasia;
    
    @Column(name="cnpj")
    private String cnpj;
    
    @Column(name="observacao")
    private String observacoes;
    
    @Column(name="email_primario")
    private String emailPrimario;
    
    @Column(name="email_secundario")
    private String emailSecundario;

    
    private List<Telefone> telefones;
    
    public Fornecedor() {
        this.telefones = new ArrayList<>();
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    public String getRazaoSocial() {
        return razaoSocial;
    }
    public Fornecedor setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
        return this;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }
    public Fornecedor setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
        return this;
    }

    public String getCnpj() {
        return cnpj;
    }
    public Fornecedor setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public String getObservacoes() {
        return observacoes;
    }
    public Fornecedor setObservacoes(String observacoes) {
        this.observacoes = observacoes;
        return this;
    }

    public String getEmailPrimario() {
        return emailPrimario;
    }
    public Fornecedor setEmailPrimario(String emailPrimario) {
        this.emailPrimario = emailPrimario;
        return this;
    }

    public String getEmailSecundario() {
        return emailSecundario;
    }
    public Fornecedor setEmailSecundario(String emailSecundario) {
        this.emailSecundario = emailSecundario;
        return this;
    }
    
    public Fornecedor addTelefone(Telefone telefone) {
        this.telefones.add(telefone);
        return this;
    }
}
