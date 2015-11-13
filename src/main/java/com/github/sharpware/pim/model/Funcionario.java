/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.pim.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa<Funcionario> {

    @Column(name = "login")
    private String login;

    @Column(name = "senha")
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_funcionario")
    private TipoFuncionario tipoFuncionario;

    @OneToMany
    @JoinTable(name="telefone_funcionario")
    private final List<Telefone> telefones;

    public Funcionario() {
        telefones = new ArrayList<>();
    }

    public String getLogin() {
        return login;
    }
    public Funcionario setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getSenha() {
        return senha;
    }
    public Funcionario setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }
    public Funcionario setTipoFuncionario(TipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
        return this;
    }

    public List<Telefone> getTelefone() {
        return Collections.unmodifiableList(telefones);
    }
    public Funcionario addTelefone(Telefone telefone) {
        this.telefones.add(telefone);
        return this;
    }
}
