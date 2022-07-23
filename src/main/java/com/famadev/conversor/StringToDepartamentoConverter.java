package com.famadev.conversor;

import com.famadev.domain.Departamento;
import com.famadev.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToDepartamentoConverter  implements Converter<String, Departamento> {
    @Autowired
    private DepartamentoService service;

    @Override
    public Departamento convert(String text) {
        // se estiver vazia nao sera convertida
        if (text.isEmpty()) {
            return null;
        }
        // id armazenado na variavel text
        // convertendo text para long
        Long id = Long.valueOf(text);
        return service.buscarPorId(id);
    }
}
