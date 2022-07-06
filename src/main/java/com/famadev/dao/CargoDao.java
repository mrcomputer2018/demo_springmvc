package com.famadev.dao;

import com.famadev.domain.Cargo;
import com.famadev.domain.Departamento;

import java.util.List;

public interface CargoDao {
    // Lista de metodos de impl
    void save(Cargo cargo);

    void update(Cargo cargo);

    void delete(Long id);

    Cargo findById(Long id);

    List<Cargo> findAll();
}
