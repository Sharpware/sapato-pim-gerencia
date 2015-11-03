/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.pim.controller;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import com.github.sharpware.pim.dao.IFuncionarioDao;
import com.github.sharpware.pim.dao.JPAFuncionarioDao;
import com.github.sharpware.pim.model.Funcionario;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

/**
 *
 * @author George
 */
@Controller
public class FuncionarioController {
    
    private final IFuncionarioDao dao;
    private final Result result;

    @Inject
    public FuncionarioController(IFuncionarioDao dao, Result result) {
        this.dao = new JPAFuncionarioDao();
        this.result = result;
    }

    public FuncionarioController() {
        this(null, null);
    }
    
    @Path("funcionario/formulario")
    public void formulario() { }
    
    public void salvar(Funcionario funcionario) {
        dao.salvar(funcionario);
        result.redirectTo(this).listar();
    }
    
    public void listar() {
        List<Funcionario> funcionarios = dao.buscarTodos();
    	result.include("funcionarios", funcionarios);
    }
    
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
