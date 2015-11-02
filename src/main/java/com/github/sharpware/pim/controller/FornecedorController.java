package com.github.sharpware.pim.controller;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import com.github.sharpware.pim.dao.IDao;
import com.github.sharpware.pim.dao.JPAForcecedorDao;
import com.github.sharpware.pim.model.Fornecedor;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

public class FornecedorController {

	private final IDao<Fornecedor> dao;
    private final Result result;

    @Inject
    public FornecedorController(Result result) {
        this.dao = new JPAForcecedorDao();
        this.result = result;
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
