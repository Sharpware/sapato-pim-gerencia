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
import com.github.sharpware.pim.annotations.Transacional;
import com.github.sharpware.pim.dao.IClienteDao;
import com.github.sharpware.pim.model.Endereco;
import com.github.sharpware.pim.model.Situacao;
import com.github.sharpware.pim.model.Telefone;
import com.github.sharpware.pim.model.TipoTelefone;
import java.util.ArrayList;
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
    private final List<Telefone> telefones;
    
    @Inject
    public ClienteController(IClienteDao dao, Result result) {
        this.dao = dao;
        this.result = result;
        this.telefones = new ArrayList<>();
    }

    public ClienteController() {
        this(null, null);
    }
    
    @Path("cliente/formulario")
    public void formulario() { }
    
    @Transacional
    @Post("/cliente")
    public void salvar(Cliente cliente, Endereco endereco
            ,Telefone telefone1, Telefone telefone2, Telefone telefone3) {
        cliente.setSituacao(Situacao.ATIVO);
        cliente.setEndereco(endereco);
        
        telefone1.setTipoTelefone(TipoTelefone.RESIDENCIAL);
        telefone2.setTipoTelefone(TipoTelefone.TRABALHO);
        telefone3.setTipoTelefone(TipoTelefone.CELULAR);
        
        telefones.add(telefone1);
        telefones.add(telefone2);
        telefones.add(telefone3);
        
        this.dao.salvar(cliente, telefones);
        result.redirectTo(this).pesquisar();
    }
    
    @Get("/cliente/pesquisar")
    public void pesquisar() {
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
