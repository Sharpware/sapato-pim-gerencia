package com.github.sharpware.pim.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.github.sharpware.pim.model.Cliente;

public class JPAClienteDao implements ClienteDao {
	
	private EntityManager manager;
	
	@Inject
	public JPAClienteDao(EntityManager manager) {
            this.manager = manager;
	}
	
	public JPAClienteDao() {
            this(null);
	}
	
        @Override
	public void salvar(Cliente cliente) {
            if (cliente.getId() == null) {
                this.manager.persist(cliente);
            } else {
                this.manager.merge(cliente);
            }
	}
	
        @Override
	public Cliente buscarPorId(Long id) {
            return this.manager.createQuery("from Cliente where id=1", Cliente.class)
                            .getSingleResult();
	}
	
        @Override
	public List<Cliente> buscarTodos() {
            return this.manager.createQuery("from Cliente", Cliente.class)
                                .getResultList();
	}
}
