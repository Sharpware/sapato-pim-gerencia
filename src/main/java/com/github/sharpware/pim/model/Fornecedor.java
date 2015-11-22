package com.github.sharpware.pim.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
@Table(name="fornecedor")
public class Fornecedor implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @NotNull(message = "Razão social deve ser preenchida")
    @Column(name="razao_social")
    private String razaoSocial;
    
    @NotNull(message = "Nome fantasia deve ser preenchida")
    @Column(name="nome_fantasia")
    private String nomeFantasia;
    
    @NotNull(message = "CNPJ deve ser preenchida")
    @Column(name="cnpj")
    private String cnpj;
    
    @Column(name="observacao", columnDefinition="text")
    private String observacao;
    
    @Column(name="email_primario")
    private String emailPrimario;
    
    @Column(name="email_secundario")
    private String emailSecundario;
    
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

    public String getObservacao() {
        return observacao;
    }
    public Fornecedor setObservacao(String observacao) {
        this.observacao = observacao;
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
    
    public Situacao getSituacao() {
		return situacao;
	}
	public Fornecedor setSituacao(Situacao situacao) {
		this.situacao = situacao;
		return this;
	}
    
    public Endereco getEndereco() {
        return endereco;
    }
    public Fornecedor setEndereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }
}
