package com.desafioalura.desafiolivros.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Autor {

    @Id
    private Long id;
    private String nome;
    private Integer anoNascimento;
    private Integer anoFalecimento;

    // Construtor sem argumentos
    public Autor() {}

    // Construtor com parâmetros
    public Autor(String nome, Integer anoNascimento, Integer anoFalecimento) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.anoFalecimento = anoFalecimento;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Integer getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(Integer anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    @Override
    public String toString() {
        return nome + " (" + anoNascimento + " - " + (anoFalecimento != null ? anoFalecimento : "presente") + ")";
    }
}
