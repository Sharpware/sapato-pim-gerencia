package com.github.sharpware.pim.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.github.sharpware.pim.model.Funcionario;
import com.github.sharpware.pim.model.Telefone;

public class JPATelefoneFuncionarioDao implements ITelefoneDao<Funcionario> {

    private final JPATelefoneFuncionarioDao that = this;
    private EntityManager manager;

    @Inject
    public JPATelefoneFuncionarioDao(EntityManager manager) {
        this.manager = manager;
    }

    public JPATelefoneFuncionarioDao() {
        this(null);
    }

    @Override
    public void salvarTelefones(Funcionario funcionario, List<Telefone> telefones) {
        telefones
                .stream()
                .map((telefone) -> that.manager.merge(telefone))
                .forEach((telefone) -> {
                    that.manager.createNativeQuery("INSERT INTO telefone_funcionario"
                            + "(funcionario_id, telefone_id) VALUES (:funcionario_id, :telefone_id)")
                    .setParameter("funcionario_id", funcionario.getId())
                    .setParameter("telefone_id", telefone.getId())
                    .executeUpdate();
                });
    }

    @Override
    public List<Telefone> buscarTelefones(Funcionario funcionario) {
        // TODO Auto-generated method stub
        return null;
    }
}
