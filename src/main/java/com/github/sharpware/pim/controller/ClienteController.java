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

/**
 *
 * @author Christopher
 */
@Controller
public class ClienteController {
	
	private ClienteDao dao;

	@Inject
	public ClienteController(ClienteDao dao) {
		this.dao = dao;
	}
	
    public void formulario() {
        
    }
    
    public void salvar(Cliente cliente) {
    	dao.salvar(cliente);
    }
}
