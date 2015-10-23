/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sharpware.pim.model;

import java.time.LocalDate;
import javax.persistence.*;

/**
 *
 * @author RodrigoFelipe
 */
public class Venda {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @Column(name="data")
    private LocalDate data;
    
    @Column(name="valor_total")
    private double valorTotal;
    
    private Cliente cliente;
    
    private Funcionario funcionario;
}
