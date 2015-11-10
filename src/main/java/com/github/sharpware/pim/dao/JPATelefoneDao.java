/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.pim.dao;

import com.github.sharpware.pim.model.Telefone;
import java.util.List;
import static java.util.Objects.requireNonNull;
import java.util.Optional;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

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
    public void salvar(Telefone telefone) {
       try {
           this.manager.merge(requireNonNull(telefone));
       } catch (Exception ex) {
            throw new RuntimeException(ex);
       }
    }

    @Override
    public Optional<Telefone> buscarPorId(Long id) {
        try {
            Telefone telefone = this.manager.find(Telefone.class, id);
            return Optional.ofNullable(telefone);
        } catch (EntityNotFoundException ex) {
            return Optional.empty();
        }
    }

    @Override
    public List<Telefone> buscarTodos() {
        return this.manager.createQuery("SELECT t FROM Telefone t", Telefone.class)
                            .getResultList();
    }
    
}
