/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.pim.dao;

import com.github.sharpware.pim.model.Cliente;
import com.github.sharpware.pim.model.Fornecedor;
import com.github.sharpware.pim.model.Funcionario;


/**
 *
 * @author George
 */
public interface ITelefoneDao {
    void salvarClienteTelefone(Cliente cliente, long id);
    void salvarFuncionarioTelefone(Funcionario funcionario, long id);
    void salvarFornecedorTelefone(Fornecedor fornecedor, long id);
}
