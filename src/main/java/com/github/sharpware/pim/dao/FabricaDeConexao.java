package com.github.sharpware.pim.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaDeConexao {

    @Produces
    @ApplicationScoped
    public EntityManagerFactory criaEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("default");
    }
    
    @Produces
    @RequestScoped
    public EntityManager criaEntityManager(EntityManagerFactory factory) {
        return factory.createEntityManager();
    }
    
    public void fecharManager(@Disposes EntityManager manager) {
        manager.close();
    }
    
    public void fecharFactory(@Disposes EntityManagerFactory factory) {
        factory.close();
    }
}
