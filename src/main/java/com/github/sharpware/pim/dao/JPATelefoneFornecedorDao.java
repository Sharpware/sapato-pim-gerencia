package com.github.sharpware.pim.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.github.sharpware.pim.model.Fornecedor;
import com.github.sharpware.pim.model.Telefone;

public class JPATelefoneFornecedorDao implements ITelefoneDao<Fornecedor> {

	private final JPATelefoneFornecedorDao that = this;
	private EntityManager manager;

	@Inject
	public JPATelefoneFornecedorDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public JPATelefoneFornecedorDao() {
		this(null);
	}
	
	@Override
	public void salvarTelefones(Fornecedor fornecedor, List<Telefone> telefones) {
		telefones
        .stream()
        .map((telefone) -> that.manager.merge(telefone))
        .forEach((telefone) -> {
            that.manager.createNativeQuery("INSERT INTO telefone_fornecedor"
                    + "(fornecedor_id, telefone_id) VALUES (:fornecedor_id, :telefone_id)")
                    .setParameter("fornecedor_id", fornecedor.getId())
                    .setParameter("telefone_id", telefone.getId())
                    .executeUpdate();
        });
	}

	@Override
	public List<Telefone> buscarTelefones(Fornecedor fornecedor) {
		
		return null;
	}

}
