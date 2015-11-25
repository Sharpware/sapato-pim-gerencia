package com.github.sharpware.pim.dao;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import com.github.sharpware.pim.model.Fornecedor;
import com.github.sharpware.pim.model.Telefone;

public class JPAFornecedorDao implements IDao<Fornecedor> {

    private EntityManager manager;
    private ITelefoneDao<Fornecedor> dao;

    @Inject
    public JPAFornecedorDao(EntityManager manager, ITelefoneDao<Fornecedor> dao) {
        this.manager = manager;
        this.dao = dao;
    }

    public JPAFornecedorDao() {
        this(null, null);
    }

    @Override
    public void salvar(Fornecedor fornecedor, List<Telefone> telefones) {
        try {
            Fornecedor novoFornecedor = this.manager.merge(requireNonNull(fornecedor));
            this.dao.salvarTelefones(novoFornecedor, telefones);
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

	@Override
	public List<Fornecedor> buscarPorNome(String nome) {
		return this.manager.createQuery("SELECT f FROM Fornecedor f "
										+ "WHERE f.nome = :nome", Fornecedor.class)
										.setParameter("nome", nome)
                						.getResultList();
	}

	@Override
	public List<Fornecedor> buscarPorCPF(String cpf) {
		return this.manager.createQuery("SELECT f FROM Fornecedor f "
										+ "WHERE f.cpf = :cpf", Fornecedor.class)
										.setParameter("cpf", cpf)
										.getResultList();
	}
}
