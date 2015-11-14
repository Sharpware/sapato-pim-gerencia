/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.pim.dao;

import com.github.sharpware.pim.model.Cliente;
import com.github.sharpware.pim.model.Fornecedor;
import com.github.sharpware.pim.model.Funcionario;
import com.github.sharpware.pim.model.Telefone;
import java.util.List;


/**
 *
 * @author George
 */
public interface ITelefoneDao {
    void salvarClienteTelefone(Cliente cliente);
    void salvarFuncionarioTelefone(Funcionario funcionario);
    void salvarFornecedorTelefone(Fornecedor fornecedor);
}
