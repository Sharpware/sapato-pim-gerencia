package com.github.sharpware.pim.dao;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.github.sharpware.pim.model.Cliente;
import com.github.sharpware.pim.model.Telefone;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;

public class JPAClienteDao implements IDao<Cliente> {

    private EntityManager manager;
    private ITelefoneDao<Cliente> dao;

    @Inject
    public JPAClienteDao(EntityManager manager, ITelefoneDao<Cliente> dao) {
        this.manager = manager;
        this.dao = dao;
    }

    public JPAClienteDao() {
        this(null, null);
    }

    @Override
    public void salvar(Cliente cliente, List<Telefone> telefones) {
        try {
            Cliente novoCliente = this.manager.merge(requireNonNull(cliente));
            this.dao.salvarTelefones(novoCliente, telefones);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        try {
            Cliente cliente = this.manager.find(Cliente.class, id);
            return Optional.ofNullable(cliente);
        } catch (EntityNotFoundException ex) {
            return Optional.empty();
        }
    }

    @Override
    public List<Cliente> buscarTodos() {
        return this.manager.createQuery("SELECT c FROM Cliente c", Cliente.class)
                .getResultList();
    }

	@Override
	public List<Cliente> buscarPorNome(String nome) {
		return this.manager.createQuery("SELECT c FROM Cliente c "
										+ "WHERE c.nome = :nome", Cliente.class)
										.setParameter("nome", nome)
                						.getResultList();
	}

	@Override
	public List<Cliente> buscarPorCPF(String cpf) {
		return this.manager.createQuery("SELECT c FROM Cliente c "
				+ "WHERE c.cpf = :cpf", Cliente.class)
				.setParameter("cpf", cpf)
				.getResultList();
	}
}
