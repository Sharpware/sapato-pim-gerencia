package com.github.sharpware.pim.controller;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import com.github.sharpware.pim.dao.*;
import com.github.sharpware.pim.model.Fornecedor;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

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
    
    @Path("funcionario/formulario")
    public void formulario() { }
    
    public void salvar(Fornecedor fornecedor) {
        dao.salvar(fornecedor);
        result.redirectTo(this).listar();
    }
    
    public void listar() {
        List<Fornecedor> fornecedores = dao.buscarTodos();
    	result.include("fornecedores", fornecedores);
    }
    
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
