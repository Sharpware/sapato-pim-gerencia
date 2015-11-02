/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.pim.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import com.github.sharpware.pim.dao.IDao;
import com.github.sharpware.pim.dao.JPAFuncionarioDao;
import com.github.sharpware.pim.model.Funcionario;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author George
 */
@Controller
public class FuncionarioController {
    
    private final IDao<Funcionario> dao;
    private final Result result;

    @Inject
    public FuncionarioController(Result result) {
        this.dao = new JPAFuncionarioDao();
        this.result = result;
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
}
