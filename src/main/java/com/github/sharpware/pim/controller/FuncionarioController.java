/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.pim.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import com.github.sharpware.pim.dao.IFuncionarioDao;
import com.github.sharpware.pim.dao.JPAFuncionarioDao;
import com.github.sharpware.pim.model.Endereco;
import com.github.sharpware.pim.model.Funcionario;
import com.github.sharpware.pim.model.Situacao;
import com.github.sharpware.pim.model.Telefone;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

/**
 *
 * @author George
 */
@Controller
public class FuncionarioController {
    
    private final IFuncionarioDao dao;
    private final Result result;
    private final List<Telefone> telefones;

    @Inject
    public FuncionarioController(IFuncionarioDao dao, Result result) {
        this.dao = new JPAFuncionarioDao();
        this.result = result;
        this.telefones = new ArrayList<>();
    }

    public FuncionarioController() {
        this(null, null);
    }
    
    @Path("/funcionario/formulario")
    public void formulario() { }
    
    @Post("/funcionario")
    public void salvar(Funcionario funcionario, Endereco endereco
    					,Telefone telefone1, Telefone telefone2, Telefone telefone3) {
    	
    	funcionario.setSituacao(Situacao.ATIVO);
    	funcionario.setEndereco(endereco);
    	
    	telefones.add(telefone1);
    	telefones.add(telefone2);
    	telefones.add(telefone3);
    	
        dao.salvar(funcionario, telefones);
        result.redirectTo(this).pesquisar();
    }
    
    @Get("/funcionario/pesquisar")
    public void pesquisar() {
        List<Funcionario> funcionarios = dao.buscarTodos();
    	result.include("funcionarios", funcionarios);
    }
    
    @Get("/funcionario/{id}")
    public void editar(Long id) {
    	Optional<Funcionario> optionalFuncionario = dao.buscarPorId(id);
        if (optionalFuncionario.isPresent()) {
            Funcionario funcionario= optionalFuncionario.get();
            result.include(funcionario);
            result.redirectTo(this).formulario();
        } else {
            result.notFound();
        }
    }
}
