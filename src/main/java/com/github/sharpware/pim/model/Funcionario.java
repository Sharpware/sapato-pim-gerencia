/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.pim.model;

import javax.persistence.*;

@SuppressWarnings("serial")
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
}
