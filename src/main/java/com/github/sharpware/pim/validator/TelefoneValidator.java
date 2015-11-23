package com.github.sharpware.pim.validator;

import java.util.List;

import com.github.sharpware.pim.model.Telefone;

public class TelefoneValidator {

    public void validateTelefonesNulos(List<Telefone> telefones) {
        for (Telefone telefone : telefones) {
                if (telefone.getNumero() == null) {
                        telefone.setNumero("");
                }
        }
    }
}
