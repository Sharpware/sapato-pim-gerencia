package com.github.sharpware.pim.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import com.github.sharpware.pim.dao.IFornecedorDao;
import com.github.sharpware.pim.model.Endereco;
import com.github.sharpware.pim.model.Fornecedor;
import com.github.sharpware.pim.model.Telefone;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

@Controller
public class FornecedorController {

    private final IFornecedorDao dao;
    private final Result result;
    private final List<Telefone> telefones;

    @Inject
    public FornecedorController(IFornecedorDao dao, Result result) {
        this.dao = dao;
        this.result = result;
        this.telefones = new ArrayList<>();
    }
    
    public FornecedorController() {
        this(null, null);
    }
    
    @Path("fornecedor/formulario")
    public void formulario() { }
    
    @Post("fornecedor/")
    public void salvar(Fornecedor fornecedor, Endereco endereco
    					,Telefone telefone1, Telefone telefone2, Telefone telefone3) {
        fornecedor.setEndereco(endereco);
        
        telefones.add(telefone1);
        telefones.add(telefone2);
        telefones.add(telefone3);
        
        dao.salvar(fornecedor, telefones);
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
