/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.pim.controller;

import javax.inject.Inject;

import com.github.sharpware.pim.model.Cliente;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import com.github.sharpware.pim.dao.ClienteDao;

/**
 *
 * @author Christopher
 */
@Controller
public class ClienteController {
	
    private final ClienteDao dao;
    private final Result result;

    @Inject
    public ClienteController(ClienteDao dao, Result result) {
        this.dao = dao;
        this.result = result;
    }

    public ClienteController() {
        this(null, null);
    }
    
    public void formulario() { }
    
    @Post("/cliente")
    public void salvar(Cliente cliente) {
    	dao.salvar(cliente);
        result.redirectTo(this).listar();
    }
    
    @Get("/cliente")
    public void listar() {
    	result.include("clientes", dao.buscarTodos());
    }
    
    @Get("/cliente/{id}")
    public void editar(Long id) {
    	
        dao.buscarPorId(id).ifPresent(cliente -> {
            result.notFound();
            result.include(cliente);
            result.of(this).formulario();
        });   
    }
}
