package com.github.sharpware.pim.dao;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;

import com.github.sharpware.pim.model.Fornecedor;
import com.github.sharpware.pim.model.Telefone;

public class JPAForcecedorDao implements IFornecedorDao {

    private EntityManager manager;

    @Inject
    public JPAForcecedorDao(EntityManager manager) {
        this.manager = manager;
    }

    public JPAForcecedorDao() {
        this(null);
    }
    
    @Override
    public void salvar(Fornecedor fornecedor, List<Telefone> telefones) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            manager.merge(requireNonNull(fornecedor));
        } catch (Exception ex) {
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
        return this.manager.createQuery("SELECT f FROM Fornecedor f", Fornecedor.class)
                            .getResultList();
    }

}
//