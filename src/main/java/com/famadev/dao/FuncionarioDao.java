package com.famadev.dao;

import com.famadev.domain.Departamento;
import com.famadev.domain.Funcionario;

import java.util.List;

public interface FuncionarioDao {
    // Lista de metodos de impl
    void save(Funcionario funcionario);

    void update(Funcionario funcionario);

    void delete(Long id);

    Funcionario findById(Long id);

    List<Funcionario> findAll();

    List<Funcionario> findByNome(String nome);
}
