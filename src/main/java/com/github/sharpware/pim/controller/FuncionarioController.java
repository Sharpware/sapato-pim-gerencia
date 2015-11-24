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

//import com.github.sharpware.pim.dao.JPAFuncionarioDao;
import com.github.sharpware.pim.model.Endereco;
import com.github.sharpware.pim.model.Funcionario;
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
import com.github.sharpware.pim.dao.IDao;
import com.github.sharpware.pim.dao.ITelefoneDao;
import com.github.sharpware.pim.model.TipoFuncionario;

/**
 *
 * @author George
 */
@Controller
public class FuncionarioController {
    
    private final IDao<Funcionario> dao;
    private final Result result;
    private final List<Telefone> telefones;
    private final Validator validator;
    private final TelefoneValidator telefoneValidator;
    private final ITelefoneDao<Funcionario> daoTelefone;

    @Inject
    public FuncionarioController(IDao<Funcionario> dao, Result result, Validator validator, ITelefoneDao<Funcionario> daoTelefone) {
        this.validator = validator;
        this.dao = dao;
        this.daoTelefone = daoTelefone;
        this.result = result;
        this.telefones = new ArrayList<>();
        this.telefoneValidator = new TelefoneValidator();
    }

    public FuncionarioController() {
        this(null, null, null, null);
    }

    @Path("/funcionario/formulario")
    public void formulario() { }

    @Transacional
    @Post("/funcionarios")
    public void salvar(Funcionario funcionario
            ,Telefone telefone1, Telefone telefone2, Telefone telefone3) {

        this.validator.validate(funcionario);
        this.validator.onErrorUsePageOf(this).formulario();
        
        funcionario.setSituacao(Situacao.Ativo)
                    .setTipoFuncionario(TipoFuncionario.CAIXA);

        telefone1.setTipoTelefone(TipoTelefone.Residencial);
        telefone2.setTipoTelefone(TipoTelefone.Trabalho);
        telefone3.setTipoTelefone(TipoTelefone.Celular);

        this.telefoneValidator.validateTelefonesNulos(telefones);

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
    public void editar(Long id) throws Exception {
        try {
            Optional<Funcionario> optionalFuncionario = dao.buscarPorId(id);
            if (optionalFuncionario.isPresent()) {
                Funcionario funcionario = optionalFuncionario.get();
                List<Telefone> telefonesfornecedor = this.daoTelefone.buscarTelefones(funcionario);

                Telefone telefone1 = telefonesfornecedor.get(0);
                Telefone telefone2 = telefonesfornecedor.get(1);
                Telefone telefone3 = telefonesfornecedor.get(2);

                result.include(funcionario)
                        .include("telefone1", telefone1)
                        .include("telefone2", telefone2)
                        .include("telefone3", telefone3);
                result.redirectTo(this).formulario();
            } else {
                result.notFound();
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}