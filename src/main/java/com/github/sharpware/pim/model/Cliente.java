package com.github.sharpware.pim.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa<Cliente> {

    @OneToMany
    @Cascade({CascadeType.PERSIST})
    @JoinTable(name = "telefone_cliente",
            joinColumns = @JoinColumn(name = "id"))
    private final List<Telefone> telefones;

    public Cliente() {
        telefones = new ArrayList<>();
    }

    public List<Telefone> getTelefone() {
        return Collections.unmodifiableList(telefones);
    }
    public Cliente addTelefone(Telefone telefone) {
        this.telefones.add(telefone);
        return this;
    }
}
