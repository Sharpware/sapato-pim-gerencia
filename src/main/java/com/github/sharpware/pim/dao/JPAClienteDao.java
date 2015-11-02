package com.github.sharpware.pim.dao;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.github.sharpware.pim.model.Cliente;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;

public class JPAClienteDao implements ClienteDao {
	
	private EntityManager manager;
	
	@Inject
	public JPAClienteDao(EntityManager manager) {
            this.manager = manager;
	}
	
        @Deprecated
	public JPAClienteDao() {
            this(null);
	}
	
        @Override
	public void salvar(Cliente cliente) {
            EntityTransaction tx = manager.getTransaction();
            try {
                tx.begin();
                manager.merge(requireNonNull(cliente));
                tx.commit();
            } catch (Exception ex) {
                ex.printStackTrace();
                tx.rollback();
                throw new RuntimeException(ex);
            }
	}
	
        @Override
	public Optional<Cliente> buscarPorId(Long id) {
            try{
                Cliente cliente = this.manager.find(Cliente.class, id);
                return Optional.ofNullable(cliente);
            }
            catch (EntityNotFoundException ex) {
                return Optional.empty();
            }
	}
	
        @Override
	public List<Cliente> buscarTodos() {
            return this.manager.createQuery("SELECT c FROM Cliente c", Cliente.class)
                                .getResultList();
	}
}
