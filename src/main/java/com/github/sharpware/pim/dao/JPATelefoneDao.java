/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.pim.dao;

import com.github.sharpware.pim.model.Cliente;
import com.github.sharpware.pim.model.Fornecedor;
import com.github.sharpware.pim.model.Funcionario;
import com.github.sharpware.pim.model.Telefone;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author George
 */
public class JPATelefoneDao implements ITelefoneDao {

    private final JPATelefoneDao that = this;
    private EntityManager manager; 
    
    @Inject
    public JPATelefoneDao(EntityManager manager) {
        this.manager = manager;
    }

    public JPATelefoneDao() {
        this(null);
    }

    @Override
    public void salvarClienteTelefone(Cliente cliente) {
        cliente.getTelefone()
        .stream()
        .map((telefone) -> that.manager.merge(telefone))
        .forEach((telefone) -> {
            that.manager.createNativeQuery("INSERT INTO telefone_cliente"
                    + "(cliente_id, telefones_id) VALUES (:cliente_id, :telefones_id)")
                    .setParameter("cliente_id", cliente.getId())
                    .setParameter("telefones_id", telefone.getId());
        });
    }

    @Override
    public void salvarFuncionarioTelefone(Funcionario funcionario) {

    }

    @Override
    public void salvarFornecedorTelefone(Fornecedor fornecedor) {

    }
}
