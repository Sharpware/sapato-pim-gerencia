/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.pim.dao;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author kurosaki-x
 */
public interface IDao<T> {
    void salvar(T entidade);
    Optional<T> buscarPorId(Long id);
    List<T> buscarTodos();
}
