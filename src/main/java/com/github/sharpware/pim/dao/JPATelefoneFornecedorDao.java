package com.github.sharpware.pim.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.github.sharpware.pim.model.Fornecedor;
import com.github.sharpware.pim.model.Telefone;
import java.util.ArrayList;

public class JPATelefoneFornecedorDao implements ITelefoneDao<Fornecedor> {

    private final JPATelefoneFornecedorDao that = this;
    private EntityManager manager;
    private List<Telefone> telefones;

    @Inject
    public JPATelefoneFornecedorDao(EntityManager manager) {
        this.manager = manager;
        this.telefones = new ArrayList<>();
    }

    public JPATelefoneFornecedorDao() {
        this(null);
    }

    @Override
    public void salvarTelefones(Fornecedor fornecedor, List<Telefone> telefones) {
        telefones
                .stream()
                .forEach((telefone) -> {
                    Telefone outroTelefone = that.manager.find(Telefone.class, telefone.getId());
                    if (that.manager.contains(outroTelefone)) {
                        that.manager.merge(telefone);
                    } else {
                        Telefone novoTelefone = that.manager.merge(telefone);
                        that.manager
                        .createNativeQuery("INSERT INTO telefone_fornecedor"
                                + "(fornecedor_id, telefone_id) "
                                + "VALUES (:fornecedor_id, :telefone_id)")
                        .setParameter("fornecedor_id", fornecedor.getId())
                        .setParameter("telefone_id", novoTelefone.getId())
                        .executeUpdate();
                    }
                });
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Telefone> buscarTelefones(Fornecedor fornecedor) throws Exception {
        try {
            List<Integer> telefonesId = that.manager
                    .createNativeQuery("SELECT telefone_id "
                            + "FROM telefone_fornecedor "
                            + "WHERE fornecedor_id = :fornecedor_id")
                    .setParameter("fornecedor_id", fornecedor.getId())
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
