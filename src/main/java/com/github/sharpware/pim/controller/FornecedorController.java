package com.github.sharpware.pim.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import com.github.sharpware.pim.annotation.Transacional;
import com.github.sharpware.pim.model.Endereco;
import com.github.sharpware.pim.model.Fornecedor;
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
import com.github.sharpware.pim.dao.ITelefoneDao;


@Controller
public class FornecedorController {


    private final IDao<Fornecedor> dao;
    private final ITelefoneDao<Fornecedor> daoTelefone;
    private final Result result;
    private final List<Telefone> telefones;
    private final TelefoneValidator telefoneValidator;
    private final Validator validator;

    @Inject
    public FornecedorController(IDao<Fornecedor> dao, ITelefoneDao<Fornecedor> daoTelefone
                                    ,Result result, Validator validator) {
        this.dao = dao;
        this.daoTelefone = daoTelefone;
        this.result = result;
        this.validator = validator;
        this.telefones = new ArrayList<>();
        this.telefoneValidator = new TelefoneValidator();
    }
    
    @Deprecated
    public FornecedorController() {
        this(null, null, null, null);
    }
    
    public void formulario() { }
    
    public void pesquisa() { }
    
    @Transacional
    @Post("/fornecedores")
    public void salvar(Fornecedor fornecedor, Endereco endereco
                        ,Telefone telefone1, Telefone telefone2, Telefone telefone3) {
    	
        this.validator.validate(fornecedor);
        this.validator.onErrorUsePageOf(this).formulario();

        fornecedor.setSituacao(Situacao.Ativo)
                .setEndereco(endereco);

        telefone1.setTipoTelefone(TipoTelefone.Residencial);
        telefone2.setTipoTelefone(TipoTelefone.Trabalho);
        telefone3.setTipoTelefone(TipoTelefone.Celular);

        this.telefones.add(telefone1);
        this.telefones.add(telefone2);
        this.telefones.add(telefone3);

        telefoneValidator.validateTelefonesNulos(telefones);
        
        this.dao.salvar(fornecedor, telefones);
        result.redirectTo(this).pesquisa();
    }
    
    @Get
    public void pesquisarTodos() {
    	List<Fornecedor> fornecedores = dao.buscarTodos();
        this.result.include("fornecedores", fornecedores);
        this.result.redirectTo(this).pesquisa();
    }
    
    @Get
    public void pesquisarPorId(Long id) {
		Optional<Fornecedor> optionalFornecedor = this.dao.buscarPorId(id);
		Fornecedor fornecedor = optionalFornecedor.get();
		this.result.include(fornecedor);
		this.result.redirectTo(this).pesquisa();
	}
	
    @Get
	public void pesquisarPorNome(String nome) {
		List<Fornecedor> fornecedores = this.dao.buscarPorNome(nome);
		this.result.include("fornecedores", fornecedores);
		this.result.redirectTo(this).pesquisa();
	}
	
    @Get
	public void pesuisarPorCPF(String cpf) {
		List<Fornecedor> fornecedores = this.dao.buscarPorCPF(cpf);
		this.result.include("fornecedores", fornecedores);
		this.result.redirectTo(this).pesquisa();
	}
    
    @Get("/fornecedor/{id}")
    public void editar(Long id) throws Exception {
        try {
            Optional<Fornecedor> optionalFornecedor = this.dao.buscarPorId(id);

            if (optionalFornecedor.isPresent()) {
                Fornecedor fornecedor = optionalFornecedor.get();
                List<Telefone> telefonesfornecedor = this.daoTelefone.buscarTelefones(fornecedor);

                Telefone telefone1 = telefonesfornecedor.get(0);
                Telefone telefone2 = telefonesfornecedor.get(1);
                Telefone telefone3 = telefonesfornecedor.get(2);

                this.result.include(fornecedor)
                        .include("telefone1", telefone1)
                        .include("telefone2", telefone2)
                        .include("telefone3", telefone3);
                this.result.redirectTo(this).formulario();
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage() + " " + ex.toString());
        }
    }
}
