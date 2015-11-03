/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.pim.dao;

import com.github.sharpware.pim.model.Cliente;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author kurosaki-x
 */
public interface IClienteDao {
    void salvar(Cliente entidade);
    Optional<Cliente> buscarPorId(Long id);
    List<Cliente> buscarTodos();
}
