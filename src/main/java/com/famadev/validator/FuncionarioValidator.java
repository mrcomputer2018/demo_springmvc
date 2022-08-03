package com.famadev.validator;

import com.famadev.domain.Funcionario;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class FuncionarioValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Funcionario.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Funcionario f = (Funcionario) object;

        LocalDate entrada = f.getDataEntrada();

        if (f.getDataSaida() != null) {
            if (f.getDataSaida().isBefore(entrada)) {
                // field - campo que estou validando
                errors.rejectValue("dataSaida", "PosteriorDataEntrada.funcionario.dataSaida");
            }
        }
    }
}
