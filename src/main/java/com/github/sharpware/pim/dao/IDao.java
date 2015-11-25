/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.pim.dao;

import com.github.sharpware.pim.model.Telefone;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author George
 * @param <T>
 */
public interface IDao<T> {
    void salvar(T entidade, List<Telefone> telefones);
    Optional<T> buscarPorId(Long id);
    List<T> buscarPorNome(String nome);
    List<T> buscarPorCPF(String cpf);
    List<T> buscarTodos();
}
