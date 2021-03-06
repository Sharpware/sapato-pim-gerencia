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

import com.github.sharpware.pim.annotation.Transacional;
import com.github.sharpware.pim.dao.ITelefoneDao;
import com.github.sharpware.pim.model.Cliente;
import com.github.sharpware.pim.model.Endereco;
import com.github.sharpware.pim.model.Situacao;
import com.github.sharpware.pim.model.Telefone;
import com.github.sharpware.pim.model.TipoTelefone;
import com.github.sharpware.pim.validator.TelefoneValidator;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import com.github.sharpware.pim.dao.IDao;

/**
 *
 * @author George
 */
@Controller
public class ClienteController {

	private final IDao<Cliente> dao;
	private final Result result;
	private List<Telefone> telefones;
	private Validator validator;
	private TelefoneValidator telefoneValidator;
	private ITelefoneDao<Cliente> daoTelefone;

	@Inject
	public ClienteController(IDao<Cliente> dao, ITelefoneDao<Cliente> daoTelefone 
								,Result result, Validator validator) {
		this.dao = dao;
		this.daoTelefone = daoTelefone;
		this.result = result;
		this.validator = validator;
		this.telefones = new ArrayList<>();
		this.telefoneValidator = new TelefoneValidator();
	}

	@Deprecated
	public ClienteController() {
		this(null, null, null, null);
	}
	
	public void formulario() { }
	
	public void pesquisa() { }

	@Transacional
	@Post("/clientes")
	public void salvar(Cliente cliente, Endereco endereco 
						,Telefone telefone1, Telefone telefone2, Telefone telefone3) {

		this.validator.validate(cliente);
		this.validator.onErrorUsePageOf(this).formulario();

		cliente.setSituacao(Situacao.Ativo)
				.setEndereco(endereco);

		telefone1.setTipoTelefone(TipoTelefone.Residencial);
		telefone2.setTipoTelefone(TipoTelefone.Trabalho);
		telefone3.setTipoTelefone(TipoTelefone.Celular);

		this.telefones.add(telefone1);
		this.telefones.add(telefone2);
		this.telefones.add(telefone3);

		telefoneValidator.validateTelefonesNulos(telefones);

		this.dao.salvar(cliente, telefones);
		result.redirectTo(this).pesquisa();
	}

	@Get
	public void pesquisarTodos() {
		List<Cliente> clientes = this.dao.buscarTodos();
		result.include("clientes", clientes);
		result.redirectTo(this).pesquisa();
	}

	@Get
	public void pesquisarPorId(Long id) {
		Optional<Cliente> optionalCliente = this.dao.buscarPorId(id);
		Cliente cliente = optionalCliente.get();
		result.include(cliente);
		result.redirectTo(this).pesquisa();
	}
	
	@Get
	public void pesquisarPorNome(String nome) {
		List<Cliente> clientes = this.dao.buscarPorNome(nome);
		result.include("clientes", clientes);
		result.redirectTo(this).pesquisa();
	}
	
	@Get
	public void pesuisarPorCPF(String cpf) {
		List<Cliente> clientes = this.dao.buscarPorCPF(cpf);
		result.include("clientes", clientes);
		result.redirectTo(this).pesquisa();
	}
	
	@Get("/cliente/{id}")
	public void editar(Long id) throws Exception {
		try {
			Optional<Cliente> optionalCliente = this.dao.buscarPorId(id);

			if (optionalCliente.isPresent()) {
				Cliente cliente = optionalCliente.get();
				List<Telefone> telefonesCliente = this.daoTelefone.buscarTelefones(cliente);

				Telefone telefone1 = telefonesCliente.get(0);
				Telefone telefone2 = telefonesCliente.get(1);
				Telefone telefone3 = telefonesCliente.get(2);

				result.include(cliente).include("telefone1", telefone1).include("telefone2", telefone2)
						.include("telefone3", telefone3);
				result.redirectTo(this).formulario();
			}
		} catch (Exception ex) {
			throw new Exception(ex.getMessage() + " " + ex.toString());
		}
	}
}
