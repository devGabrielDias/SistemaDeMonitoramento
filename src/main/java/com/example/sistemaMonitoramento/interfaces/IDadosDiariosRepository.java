package com.example.sistemaMonitoramento.interfaces;

import com.example.sistemaMonitoramento.entities.DadosDiarios;

import java.util.List;

public interface IDadosDiariosRepository {
    void adicionar(DadosDiarios dadosDiarios);

    void remover(int id);

    DadosDiarios buscarPorId(int id);

    List<DadosDiarios> buscarTodos();

    void atualizarDadosDiarios(int id, DadosDiarios dadosDiarios);
}


