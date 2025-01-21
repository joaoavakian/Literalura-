package com.desafioalura.desafiolivros.repository;

import com.desafioalura.desafiolivros.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    // Método para buscar autores vivos (sem ano de falecimento)
    List<Autor> findByAnoFalecimentoIsNull();
}
