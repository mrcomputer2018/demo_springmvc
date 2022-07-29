package com.famadev.conversor;

import com.famadev.domain.Cargo;
import com.famadev.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StringToCargoConversor implements Converter<String, Cargo> {

    @Autowired
    private CargoService service;

    @Override
    public Cargo convert(String text) {
        if (text.isEmpty()){
            return null;
        }
        Long id = Long.valueOf(text);
        return service.buscarPorId(id);
    }
}
