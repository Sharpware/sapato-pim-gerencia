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
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import com.github.sharpware.pim.dao.IClienteDao;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Christopher
 * @author George
 */
@Controller
public class ClienteController {
	
    private final IClienteDao dao;
    private final Result result;

	@Inject
    public ClienteController(IClienteDao dao, Result result) {
        this.dao = dao;
        this.result = result;
    }

    public ClienteController() {
        this(null, null);
    }
    
    @Path("cliente/formulario")
    public void formulario() { }
    
    @Post("/cliente")
    public void salvar(Cliente cliente) {
    	dao.salvar(cliente);
        result.redirectTo(this).listar();
    }
    
    @Get("/cliente")
    public void listar() {
        List<Cliente> clientes = dao.buscarTodos();
    	result.include("clientes", clientes);
    }
    
    @Get("/cliente/{id}")
    public void editar(Long id) {
        Optional<Cliente> optionalCliente = dao.buscarPorId(id);
        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            result.include(cliente);
            result.redirectTo(this).formulario();
        } else {
            result.notFound();
        }
    }
}
