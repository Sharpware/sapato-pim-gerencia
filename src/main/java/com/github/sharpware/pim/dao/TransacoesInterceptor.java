/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.pim.dao;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.github.sharpware.pim.annotation.Transacional;

/**
 *
 * @author George
 */

@Intercepts
@AcceptsWithAnnotations(Transacional.class)
public class TransacoesInterceptor {

    private final EntityManager manager;
    
    @Inject
    public TransacoesInterceptor(EntityManager manager) {
        this.manager = manager;
    }

    public TransacoesInterceptor() {
        this(null);
    }
    
    @AroundCall
    public void trataTransacao(SimpleInterceptorStack stack) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            stack.next();
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }
}
