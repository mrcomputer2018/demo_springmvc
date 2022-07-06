package com.famadev.dao;

import com.famadev.domain.Departamento;

import java.util.List;

public interface DepartamentoDao {
    // Lista de metodos de impl
    void save(Departamento departamento);

    void update(Departamento departamento);

    void delete(Long id);

    Departamento findById(Long id);

    List<Departamento> findAll();
}
