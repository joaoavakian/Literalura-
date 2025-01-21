package com.desafioalura.desafiolivros.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
