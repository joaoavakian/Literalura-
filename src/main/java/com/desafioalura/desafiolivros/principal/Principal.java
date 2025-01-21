package com.desafioalura.desafiolivros.principal;

import com.desafioalura.desafiolivros.model.Livro;
import com.desafioalura.desafiolivros.model.Autor;
import com.desafioalura.desafiolivros.repository.AutorRepository;
import com.desafioalura.desafiolivros.repository.LivroRepository;
import com.desafioalura.desafiolivros.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@Component
public class Principal {

    private final LivroRepository repositorio;
    private final AutorRepository repositorioAutor;
    private final LivroService livroService;
    private final Scanner leitura;

    @Autowired
    public Principal(LivroRepository repositorio, AutorRepository repositorioAutor, LivroService livroService) {
        this.repositorio = repositorio;
        this.repositorioAutor = repositorioAutor;
        this.livroService = livroService;
        this.leitura = new Scanner(System.in);
    }

    public void exibeMenu() {
        System.out.println("Menu:");
        System.out.println("1 - Buscar livro pelo título");
        System.out.println("2 - Listar livros registrados");
        System.out.println("3 - Listar autores registrados");
        System.out.println("4 - Listar autores vivos");
        System.out.println("5 - Listar livros por idioma");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");

        int opcao = leitura.nextInt();
        leitura.nextLine(); // Limpa o buffer

        switch (opcao) {
            case 1:
                buscarLivrosPeloTítulo();
                break;
            case 2:
                listarLivrosRegistrados();
                break;
            case 3:
                listarAutoresRegistrados();
                break;
            case 4:
                listarAutoresVivos();
                break;
            case 5:
                listarLivrosPorIdioma();
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida!");
                exibeMenu();
                break;
        }
    }

    private void buscarLivrosPeloTítulo() {
        System.out.println("Digite o título do livro:");
        String titulo = leitura.nextLine();

        List<Livro> livrosEncontrados = livroService.buscarLivrosPorTitulo(titulo);

        if (livrosEncontrados.isEmpty()) {
            System.out.println("Nenhum livro encontrado.");
        } else {
            System.out.println("Livros encontrados:");
            for (Livro livro : livrosEncontrados) {
                System.out.println(livro.getTitulo() + " - " + livro.getAutor().getNome());
            }
        }
    }

    private void listarLivrosRegistrados() {
        List<Livro> livros = repositorio.findAll();

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro registrado.");
        } else {
            System.out.println("Livros registrados:");
            for (Livro livro : livros) {
                System.out.println(livro.getTitulo() + " - " + livro.getAutor().getNome());
            }
        }
    }

    public void listarAutoresRegistrados() {
        List<Autor> autores = repositorioAutor.findAll();

        if (autores.isEmpty()) {
            System.out.println("Nenhum autor registrado.");
        } else {
            System.out.println("Autores registrados:");
            for (Autor autor : autores) {
                System.out.println(autor.getNome());
            }
        }
    }

    public void listarAutoresVivos() {
        List<Autor> autoresVivos = repositorioAutor.findByAnoFalecimentoIsNull();

        if (autoresVivos.isEmpty()) {
            System.out.println("Nenhum autor vivo.");
        } else {
            System.out.println("Autores vivos:");
            for (Autor autor : autoresVivos) {
                System.out.println(autor.getNome());
            }
        }
    }

    public void listarLivrosPorIdioma() {
        System.out.println("Digite o idioma:");
        String idioma = leitura.nextLine();

        List<Livro> livrosPorIdioma = repositorio.findByIdioma(idioma);

        if (livrosPorIdioma.isEmpty()) {
            System.out.println("Nenhum livro encontrado nesse idioma.");
        } else {
            System.out.println("Livros encontrados:");
            for (Livro livro : livrosPorIdioma) {
                System.out.println(livro.getTitulo() + " - " + livro.getIdioma());
            }
        }
    }
}
