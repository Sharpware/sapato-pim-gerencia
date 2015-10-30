/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.pim.controller;

import javax.inject.Inject;

import com.github.sharpware.pim.dao.ClienteDao;
import com.github.sharpware.pim.model.Cliente;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

/**
 *
 * @author Christopher
 */
@Controller
public class ClienteController {
	
	private ClienteDao dao;
	private Result result;
	
	@Inject
	public ClienteController(ClienteDao dao, Result result) {
		this.dao = dao;
		this.result = result;
	}
	
    public void formulario() { }
    
    @Post("/cliente")
    public void salvar(Cliente cliente) {
    	dao.salvar(cliente);
    }
    
    @Get("/cliente")
    public void lista() {
    	result.include("clientes", dao.buscarTodos());
    }
    
    @Post("/cliente")
    public void editar(Cliente cliente) {
    	
    }
}
