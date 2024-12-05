package com.example.sistemaMonitoramento.interfaces;

import com.example.sistemaMonitoramento.entities.DadosMonitoramento;

import java.util.List;

public interface IDadosMonitoramentoRepository {
    void adicionar(DadosMonitoramento dadosMonitoramento);

    void remover(int id);

    DadosMonitoramento buscarPorId(int id);

    List<DadosMonitoramento> buscarTodos();

    void atualizarDadosMonitoramento(int id, DadosMonitoramento dadosMonitoramento);
}


