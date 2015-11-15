/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.pim.dao;

import com.github.sharpware.pim.model.Telefone;
import java.util.List;


/**
 *
 * @author George
 * @param <T>
 */
public interface ITelefoneDao<T> {
    void salvarTelefone(T entidade, List<Telefone> telefones);
}
