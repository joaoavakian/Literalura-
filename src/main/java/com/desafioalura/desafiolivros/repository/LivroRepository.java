package com.desafioalura.desafiolivros.repository;

import com.desafioalura.desafiolivros.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    // Método para buscar livros por título
    List<Livro> findByTituloContainingIgnoreCase(String titulo);

    // Método para buscar livros por idioma
    List<Livro> findByIdioma(String idioma);
}
