package com.github.sharpware.pim.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa<Cliente> {
    
}
