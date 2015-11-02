package com.github.sharpware.pim.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.github.sharpware.pim.model.Cliente;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;

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
        this.manager.getTransaction().begin();
        this.manager.merge(cliente);
        this.manager.getTransaction().commit();
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        try {
            Cliente cliente = this.manager.createQuery("SELECT c FROM Cliente c where c.id = :id", Cliente.class)
                            .setParameter("id", id)
                            .getSingleResult();
            return Optional.ofNullable(cliente);
        } catch (EntityNotFoundException ex) {
            return Optional.empty();
        }
    }

    @Override
    public List<Cliente> buscarTodos() {
        return this.manager.createQuery("FROM Cliente", Cliente.class)
                            .getResultList();
    }
}
