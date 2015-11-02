package com.github.sharpware.pim.dao;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;

import com.github.sharpware.pim.model.Cliente;
import com.github.sharpware.pim.model.Fornecedor;

public class JPAForcecedorDao implements IDao<Fornecedor> {

    private EntityManager manager;

    @Inject
    public JPAForcecedorDao(EntityManager manager) {
        this.manager = manager;
    }

    public JPAForcecedorDao() {
        this(null);
    }
    
    @Override
    public void salvar(Fornecedor fornecedor) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.merge(requireNonNull(fornecedor));
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Optional<Fornecedor> buscarPorId(Long id) {
        try {
        	Fornecedor fornecedor = this.manager.find(Fornecedor.class, id);
            return Optional.ofNullable(fornecedor);
        } catch (EntityNotFoundException ex) {
            return Optional.empty();
        }
    }
    
    @Override
    public List<Fornecedor> buscarTodos() {
        return this.manager.createQuery("SELECT f FROM fornecedor f", Fornecedor.class)
                            .getResultList();
    }

}
