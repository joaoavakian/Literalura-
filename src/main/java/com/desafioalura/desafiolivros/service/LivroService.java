package com.desafioalura.desafiolivros.service;

import com.desafioalura.desafiolivros.model.DadosLivro;
import com.desafioalura.desafiolivros.model.Autor;
import com.desafioalura.desafiolivros.model.DadosAutor;
import com.desafioalura.desafiolivros.model.Livro;
import com.desafioalura.desafiolivros.repository.AutorRepository;
import com.desafioalura.desafiolivros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    // Método para buscar livros por título
    public List<Livro> buscarLivrosPorTitulo(String titulo) {
        return livroRepository.findByTituloContainingIgnoreCase(titulo);
    }
}