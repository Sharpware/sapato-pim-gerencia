package com.github.sharpware.pim.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="fornecedor")
public class Fornecedor implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="razao_social")
    private String razaoSocial;
    
    @Column(name="nome_fantasia")
    private String nomeFantasia;
    
    @Column(name="cnpj")
    private String cnpj;
    
    @Column(name="observacao", columnDefinition="text")
    private String observacao;
    
    @Column(name="email_primario")
    private String emailPrimario;
    
    @Column(name="email_secundario")
    private String emailSecundario;
    
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
    
        public Endereco getEndereco() {
        return endereco;
    }
    public Fornecedor setEndereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }
}
