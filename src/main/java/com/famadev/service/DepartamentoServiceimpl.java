package com.famadev.service;

import com.famadev.dao.DepartamentoDao;
import com.famadev.domain.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class DepartamentoServiceimpl implements DepartamentoService{
    @Autowired
    private DepartamentoDao dao;

    // metodos
    @Override
    public void salvar(Departamento departamento) {
        dao.save(departamento);
    }

    @Override
    public void editar(Departamento departamento) {
        dao.update(departamento);
    }

    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Departamento buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Departamento> buscarTodos() {
        return dao.findAll();
    }

    @Override
    public boolean departamentosTemCargos(Long id) {
        if (buscarPorId(id).getCargos().isEmpty()) {
            return false;
        }
        return true;
    }
}
