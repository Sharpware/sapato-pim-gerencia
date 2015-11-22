/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.pim.dao;

import com.github.sharpware.pim.model.Funcionario;
import com.github.sharpware.pim.model.Telefone;
import java.util.List;
import static java.util.Objects.requireNonNull;
import java.util.Optional;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

/**
 *
 * @author George
 */
@Transactional
public class JPAFuncionarioDao implements IFuncionarioDao {

    private EntityManager manager;
	private ITelefoneDao<Funcionario> dao;

    @Inject
    public JPAFuncionarioDao(EntityManager manager, ITelefoneDao<Funcionario> dao) {
        this.manager = manager;
		this.dao = dao;
    }

    public JPAFuncionarioDao() {
        this(null, null);
    }

    @Override
    public void salvar(Funcionario funcionario, List<Telefone> telefones) {
        try {
            Funcionario novoFuncionario = manager.merge(requireNonNull(funcionario));
            this.dao.salvarTelefones(novoFuncionario, telefones);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Optional<Funcionario> buscarPorId(Long id) {
        try {
            Funcionario funcionario = this.manager.find(Funcionario.class, id);
            return Optional.ofNullable(funcionario);
        } catch (EntityNotFoundException ex) {
            return Optional.empty();
        }
    }

    @Override
    public List<Funcionario> buscarTodos() {
        return this.manager.createQuery("SELECT f FROM Funcionario f", Funcionario.class)
                .getResultList();
    }

}
