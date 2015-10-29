package com.github.sharpware.pim.dao;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class FabricaDeConexao {

	@PersistenceContext
	private EntityManager manager;
	
	@Produces
	public EntityManager getManager() {
		return manager;
	}
}
