/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.pim.dao;

import com.github.sharpware.pim.model.Cliente;
import com.github.sharpware.pim.model.Telefone;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author George
 */
public class JPATelefoneClienteDao implements ITelefoneDao<Cliente> {

    private final JPATelefoneClienteDao that = this;
    private EntityManager manager; 
    
    @Inject
    public JPATelefoneClienteDao(EntityManager manager) {
        this.manager = manager;
    }

    public JPATelefoneClienteDao() {
        this(null);
    }

    @Override
    public void salvarTelefone(Cliente cliente, List<Telefone> telefones) {
        telefones
        .stream()
        .map((telefone) -> that.manager.merge(telefone))
        .forEach((telefone) -> {
            that.manager.createNativeQuery("INSERT INTO telefone_cliente"
                    + "(cliente_id, telefone_id) VALUES (:cliente_id, :telefone_id)")
                    .setParameter("cliente_id", cliente.getId())
                    .setParameter("telefone_id", telefone.getId())
                    .executeUpdate();
        });
    }
}
