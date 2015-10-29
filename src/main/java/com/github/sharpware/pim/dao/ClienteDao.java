package com.github.sharpware.pim.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.github.sharpware.pim.model.Cliente;

@Transactional
public class ClienteDao {
	
	private EntityManager manager;
	
	@Inject
	public ClienteDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public ClienteDao() {
		this(null);
	}
	
	public void salvar(Cliente cliente) {
		if (cliente.getId() == null) {
			this.manager.persist(cliente);
		} else {
			this.manager.merge(cliente);
		}
	}
	
	public Cliente buscarPorId(Cliente cliente) {
		return this.manager.createQuery("from Cliente where id=1", Cliente.class)
					.getSingleResult();
	}
	
	public List<Cliente> buscarTodos() {
		return this.manager.createQuery("from Cliente", Cliente.class)
							.getResultList();
	}
}
