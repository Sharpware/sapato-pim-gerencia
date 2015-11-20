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
import com.github.sharpware.pim.dao.IFuncionarioDao;
import com.github.sharpware.pim.dao.JPAFuncionarioDao;
import com.github.sharpware.pim.model.Endereco;
import com.github.sharpware.pim.model.Funcionario;
import com.github.sharpware.pim.model.Situacao;
import com.github.sharpware.pim.model.Telefone;
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
public class FuncionarioController {

	private final IFuncionarioDao dao;
	private final Result result;
	private final List<Telefone> telefones;
	private final Validator validator;
	private final TelefoneValidator telefoneValidator;

	@Inject
	public FuncionarioController(IFuncionarioDao dao, Result result, Validator validator) {
		this.validator = validator;
		this.dao = new JPAFuncionarioDao();
		this.result = result;
		this.telefones = new ArrayList<>();
		this.telefoneValidator = new TelefoneValidator();
	}

	public FuncionarioController() {
		this(null, null, null);
	}

	@Path("/funcionario/formulario")
	public void formulario() {
	}

	@Transacional
	@Post("/funcionario")
	public void salvar(@Valid Funcionario funcionario, Endereco endereco 
			,Telefone telefone1, Telefone telefone2, Telefone telefone3) {

		funcionario.setSituacao(Situacao.ATIVO);
		funcionario.setEndereco(endereco);

		this.telefoneValidator.validateTelefonesNulo(telefones);
		
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
			Funcionario funcionario = optionalFuncionario.get();
			result.include(funcionario);
			result.redirectTo(this).formulario();
		} else {
			result.notFound();
		}
	}
}
