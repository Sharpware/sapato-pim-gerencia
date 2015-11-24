package com.github.sharpware.pim.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.github.sharpware.pim.model.Funcionario;
import com.github.sharpware.pim.model.Telefone;
import java.util.ArrayList;

public class JPATelefoneFuncionarioDao implements ITelefoneDao<Funcionario> {

    private final JPATelefoneFuncionarioDao that = this;
    private EntityManager manager;
    private List<Telefone> telefones;

    @Inject
    public JPATelefoneFuncionarioDao(EntityManager manager) {
        this.manager = manager;
        this.telefones = new ArrayList<>();
    }

    public JPATelefoneFuncionarioDao() {
        this(null);
    }

    @Override
    public void salvarTelefones(Funcionario funcionario, List<Telefone> telefones) {
        telefones
                .stream()
                .forEach((telefone) -> {
                    Telefone outroTelefone = that.manager.find(Telefone.class, telefone.getId());
                    if (that.manager.contains(outroTelefone)) {
                        that.manager.merge(telefone);
                    } else {
                        Telefone novoTelefone = that.manager.merge(telefone);
                        that.manager
                        .createNativeQuery("INSERT INTO telefone_funcionario"
                                + "(funcionario_id, telefone_id) "
                                + "VALUES (:funcionario_id, :telefone_id)")
                        .setParameter("funcionario_id", funcionario.getId())
                        .setParameter("telefone_id", novoTelefone.getId())
                        .executeUpdate();
                    }
                });
    }

    @Override
    public List<Telefone> buscarTelefones(Funcionario funcionario) throws Exception {
        try {
            List<Integer> telefonesId = that.manager
                    .createNativeQuery("SELECT telefone_id "
                            + "FROM telefone_funcionario "
                            + "WHERE funcionario_id = :funcionario_id")
                    .setParameter("funcionario_id", funcionario.getId())
                    .getResultList();

            telefonesId.stream().forEach((id) -> {
                int idInt = id;
                long idCerto = (long) idInt;
                Telefone telefone = that.manager.find(Telefone.class, idCerto);
                this.telefones.add(telefone);
            });
        } catch (Exception ex) {
            throw new Exception(ex.getMessage() + " " + ex.toString());
        }
        return this.telefones;
    }
}
