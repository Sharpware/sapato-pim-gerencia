package com.github.sharpware.pim.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;

import com.github.sharpware.pim.annotation.Transacional;
import com.github.sharpware.pim.dao.IFornecedorDao;
import com.github.sharpware.pim.model.Endereco;
import com.github.sharpware.pim.model.Fornecedor;
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

@Controller
public class FornecedorController {

    private final IFornecedorDao dao;
    private final Result result;
    private final List<Telefone> telefones;
    private final TelefoneValidator telefoneValidator;
	private final Validator validator;

    @Inject
    public FornecedorController(IFornecedorDao dao, Result result, Validator validator) {
        this.dao = dao;
        this.result = result;
		this.validator = validator;
        this.telefones = new ArrayList<>();
        this.telefoneValidator = new TelefoneValidator();
    }
    
    public FornecedorController() {
        this(null, null, null);
    }
    
    @Path("fornecedor/formulario")
    public void formulario() { }
    
    @Transacional
    @Post("/fornecedores")
    public void salvar(@Valid Fornecedor fornecedor, Endereco endereco
    					,Telefone telefone1, Telefone telefone2, Telefone telefone3) {
    	
    	this.validator.onErrorRedirectTo(this).formulario();
    	
    	fornecedor.setSituacao(Situacao.Ativo)
    				.setEndereco(endereco);
        
    	telefone1.setTipoTelefone(TipoTelefone.Trabalho);
		telefone2.setTipoTelefone(TipoTelefone.Trabalho);
		telefone3.setTipoTelefone(TipoTelefone.Celular);
        
		telefoneValidator.validateTelefonesNulo(telefones);
		
        telefones.add(telefone1);
        telefones.add(telefone2);
        telefones.add(telefone3);
        
        this.dao.salvar(fornecedor, telefones);
        this.result.redirectTo(this).pesquisar();
    }
    
    @Get("fornecedor/pesquisar")
    public void pesquisar() {
        List<Fornecedor> fornecedores = dao.buscarTodos();
    	result.include("fornecedores", fornecedores);
    }
    
    @Get("/fornecedor/{id}")
    public void editar(Long id) {
    	Optional<Fornecedor> optionalFornecedor = dao.buscarPorId(id);
        if (optionalFornecedor.isPresent()) {
        	Fornecedor funcionario= optionalFornecedor.get();
            result.include(funcionario);
            result.redirectTo(this).formulario();
        } else {
            result.notFound();
        }
    }
	
}
