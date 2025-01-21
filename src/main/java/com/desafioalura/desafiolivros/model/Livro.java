package com.desafioalura.desafiolivros.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id")  // Relacionamento com a chave primária da tabela Autor
    private Autor autor;

    private Double numeroDownloads;

    private String idioma;

    @Column(name = "autor_nome")
    private String autorNome;

    public Livro() {}

    // Construtor que recebe um objeto DadosLivro para criar um Livro
    public Livro(DadosLivro dadosLivro) {
        this.titulo = dadosLivro.titulo();
        if (dadosLivro.autores() != null && !dadosLivro.autores().isEmpty()) {
            DadosAutor dadosAutor = dadosLivro.autores().get(0); // Pega o primeiro autor
            // Verifica se o autor existe e cria o objeto Autor
            this.autor = new Autor(dadosAutor.autor(),
                    (dadosAutor.anoNascimento() != null ? dadosAutor.anoNascimento().intValue() : null),
                    (dadosAutor.anoFalecimento() != null ? dadosAutor.anoFalecimento().intValue() : null));
            this.autorNome = dadosAutor.autor();
        } else {
            // Caso não haja autor, cria um autor padrão
            this.autor = new Autor("Autor não informado", null, null);
            this.autorNome = "Autor não informado";
        }
        this.idioma = (dadosLivro.idioma() != null && !dadosLivro.idioma().isEmpty()) ? dadosLivro.idioma().get(0) : "Idioma não informado";
        this.numeroDownloads = dadosLivro.numeroDownloads() != null ? dadosLivro.numeroDownloads() : 0.0;
    }

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Double getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(Double numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    public String getAutorNome() {
        return autorNome;
    }

    public void setAutorNome(String autorNome) {
        this.autorNome = autorNome;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + "\n" +
                "Autor: " + autor + "\n" +
                "Idioma: " + idioma + "\n" +
                "Downloads: " + numeroDownloads + "\n" +
                "--------------------------------------------\n";
    }
}
