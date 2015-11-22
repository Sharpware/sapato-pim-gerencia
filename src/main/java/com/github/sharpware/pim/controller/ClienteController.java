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
import javax.validation.Valid;

import com.github.sharpware.pim.annotation.Transacional;
import com.github.sharpware.pim.dao.IClienteDao;
import com.github.sharpware.pim.dao.ITelefoneDao;
import com.github.sharpware.pim.model.Cliente;
import com.github.sharpware.pim.model.Endereco;
import com.github.sharpware.pim.model.Situacao;
import com.github.sharpware.pim.model.Telefone;
import com.github.sharpware.pim.model.TipoTelefone;
import com.github.sharpware.pim.validator.TelefoneValidator;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

/**
 *
 * @author George
 */
@Controller
public class ClienteController {

	private final IClienteDao dao;
	private final Result result;
	private List<Telefone> telefones;
	private TelefoneValidator telefoneValidator;
	private Validator validator;
	private ITelefoneDao<Cliente> daoTelefone;

	@Inject
	public ClienteController(IClienteDao dao, ITelefoneDao<Cliente> daoTelefone 
									,Result result, Validator validator) {
		this.dao = dao;
		this.daoTelefone = daoTelefone;
		this.result = result;
		this.validator = validator;
		this.telefones = new ArrayList<>();
		this.telefoneValidator = new TelefoneValidator();
	}
	
	public ClienteController() {
		this(null, null, null, null);
	}

	@Path("cliente/formulario")
	public void formulario() { }

	@Transacional
	@Post("/clientes")
	public void salvar(@Valid Cliente cliente, Endereco endereco 
			,Telefone telefone1, Telefone telefone2, Telefone telefone3) {

		this.validator.onErrorRedirectTo(this).formulario();

		cliente.setSituacao(Situacao.Ativo)
				.setEndereco(endereco);

		telefone1.setTipoTelefone(TipoTelefone.Residencial);
		telefone2.setTipoTelefone(TipoTelefone.Trabalho);
		telefone3.setTipoTelefone(TipoTelefone.Celular);

		this.telefones.add(telefone1);
		this.telefones.add(telefone2);
		this.telefones.add(telefone3);

		telefoneValidator.validateTelefonesNulo(telefones);

		this.dao.salvar(cliente, telefones);
		result.redirectTo(this).pesquisar();
	}

	@Get("/cliente/pesquisar")
	public void pesquisar() {
		List<Cliente> clientes = dao.buscarTodos();
		result.include("clientes", clientes);
	}

	@Get("/cliente/{id}")
	public void editar(Long id) throws Exception {
		try {
			Optional<Cliente> optionalCliente = this.dao.buscarPorId(id);
			
			if (optionalCliente.isPresent()) {
				Cliente cliente = optionalCliente.get();
				List<Telefone> telefones = this.daoTelefone.buscarTelefones(cliente);
				
				Telefone telefone1 = telefones.get(0);
				Telefone telefone2 = telefones.get(1);
				Telefone telefone3 = telefones.get(2);
				
				result.include(cliente)
					.include(telefone1)
					.include(telefone2)
					.include(telefone3);
				result.redirectTo(this).formulario();
			}
		} catch (Exception ex) {
			throw new Exception(ex.getMessage() + " " + ex.toString());
		}
	}
}
