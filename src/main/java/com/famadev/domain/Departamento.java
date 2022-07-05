package com.famadev.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamento extends AbstractEntity<Long>{
    @Column(name = "nome", nullable = false, unique = true, length = 60)
    private String nome;

    //Getters ee setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
