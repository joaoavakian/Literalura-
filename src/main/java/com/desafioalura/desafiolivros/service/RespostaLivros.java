package com.desafioalura.desafiolivros.service;

// Importação da classe DadosLivro
import com.desafioalura.desafiolivros.model.DadosLivro;

import java.util.List;

public class RespostaLivros {
    private int count;
    private String next;
    private String previous;
    private List<DadosLivro> results;  // Corrigido de 'list' para 'List'

    public int getCount() {
        return count;
    }
    public void setCount(int count){
        this.count = count;
    }

    public String getNext() {
        return next;
    }
    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {  // Corrigido a assinatura do método
        return previous;
    }
    public void setPrevious(String previous){
        this.previous = previous;
    }

    public List<DadosLivro> getResults() {  // Corrigido de 'list' para 'List'
        return results;
    }

    public void setResults(List<DadosLivro> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "RespostaLivros{" +
                "count=" + count +
                ", next='" + next + '\'' +
                ", previous='" + previous + '\'' +
                ", results=" + results +
                '}';
    }
}
