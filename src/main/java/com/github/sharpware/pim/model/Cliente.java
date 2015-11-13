package com.github.sharpware.pim.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="cliente")
public class Cliente extends Pessoa<Cliente> {

    @OneToMany
    @JoinTable(name="telefone_cliente")
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
