/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.pim.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.github.sharpware.pim.model.Cliente;
import com.github.sharpware.pim.model.Telefone;

/**
 *
 * @author George
 */
public class JPATelefoneClienteDao implements ITelefoneDao<Cliente> {

	private final JPATelefoneClienteDao that = this;
	private EntityManager manager;
	private List<Telefone> telefones;

	@Inject
	public JPATelefoneClienteDao(EntityManager manager) {
		this.manager = manager;
	}

	public JPATelefoneClienteDao() {
		this(null);
	}

	@Override
	public void salvarTelefones(Cliente cliente, List<Telefone> telefones) {
		telefones.stream().map((telefone) -> that.manager.merge(telefone)).forEach((telefone) -> {
			that.manager
					.createNativeQuery("INSERT INTO telefone_cliente"
							+ "(cliente_id, telefone_id) VALUES (:cliente_id, :telefone_id)")
					.setParameter("cliente_id", cliente.getId()).setParameter("telefone_id", telefone.getId())
					.executeUpdate();
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Telefone> buscarTelefones(Cliente cliente) throws Exception {
		try {
			List<Integer> telefonesId = that.manager
					.createNativeQuery("SELECT telefone_id FROM telefone_cliente "
					+ "WHERE cliente_id = :cliente_id")
					.setParameter("cliente_id", cliente.getId())
					.getResultList();

			telefonesId.stream().forEach((id) -> {
			int idInt = id;
			long idCerto = (long) idInt;
			Telefone telefone = that.manager.find(Telefone.class, idCerto);
			this.telefones.add(telefone);
			});
		} catch(Exception ex) {
			throw new Exception(ex.getMessage() + " " + ex.toString());
		}
		
		return this.telefones;
	}
}
