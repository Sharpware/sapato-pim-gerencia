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
import java.util.function.Function;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author George
 */
public class JPATelefoneDao implements ITelefoneDao {

    private EntityManager manager;

    @Inject
    public JPATelefoneDao(EntityManager manager) {
        this.manager = manager;
    }

    public JPATelefoneDao() {
        this(null);
    }

    @Override
    public void salvarClienteTelefone(Cliente cliente, long id) {
        cliente.getTelefone().stream().map(telefone -> {
            JPATelefoneDao.this.manager.merge(telefone);
            return telefone;
        }).forEach((_item) -> {
            this.manager.createNativeQuery("INSERT INTO telefone_cliente where "
                    + "id_cliente := id_cliente and id_telefone := id_telefone")
                    .setParameter("id_cliente", cliente.getId())
                    .setParameter("id_telefone", id);
        });
    }

    @Override
    public void salvarFuncionarioTelefone(Funcionario funcionario, long id) {

    }

    @Override
    public void salvarFornecedorTelefone(Fornecedor fornecedor, long id) {

    }
}
