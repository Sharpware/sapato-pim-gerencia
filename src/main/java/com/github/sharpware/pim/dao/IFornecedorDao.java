/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.pim.dao;

import com.github.sharpware.pim.model.Fornecedor;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author kurosaki-x
 */
public interface IFornecedorDao {
    void salvar(Fornecedor fornecedor);
    Optional<Fornecedor> buscarPorId(Long id);
    List<Fornecedor> buscarTodos();
}
