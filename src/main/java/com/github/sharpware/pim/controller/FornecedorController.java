package com.github.sharpware.pim.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import com.github.sharpware.pim.dao.*;
import com.github.sharpware.pim.model.Fornecedor;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import com.github.sharpware.pim.model.Endereco;

@Controller
public class FornecedorController {

    private final IFornecedorDao dao;
    private final Result result;

    @Inject
    public FornecedorController(IFornecedorDao dao, Result result) {
        this.dao = dao;
        this.result = result;
    }
    
    public FornecedorController() {
        this(null, null);
    }
    
    @Path("fornecedor/formulario")
    public void formulario() { }
    
    public void salvar(Fornecedor fornecedor, Endereco endereco) {
        fornecedor.setEndereco(endereco);
        dao.salvar(fornecedor);
        result.redirectTo(this).pesquisar();
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
