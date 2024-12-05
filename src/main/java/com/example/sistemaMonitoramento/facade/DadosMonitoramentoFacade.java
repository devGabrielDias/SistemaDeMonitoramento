package com.example.sistemaMonitoramento.facade;

import com.example.sistemaMonitoramento.application.DadosMonitoramentoApplication;
import com.example.sistemaMonitoramento.entities.DadosMonitoramento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DadosMonitoramentoFacade {
    private final DadosMonitoramentoApplication dadosMonitoramentoApplication;

    @Autowired
    public DadosMonitoramentoFacade(DadosMonitoramentoApplication dadosMonitoramentoApplication) {
        this.dadosMonitoramentoApplication = dadosMonitoramentoApplication;
    }

    public void adicionar(DadosMonitoramento dadosMonitoramento) {
        this.dadosMonitoramentoApplication.adicionar(dadosMonitoramento);
    }

    public void remover(int id) {
        this.dadosMonitoramentoApplication.remover(id);
    }

    public DadosMonitoramento buscarPorId(int id) {
        return this.dadosMonitoramentoApplication.buscarPorId(id);
    }

    public List<DadosMonitoramento> buscarTodos() {
        return this.dadosMonitoramentoApplication.buscarTodos();
    }

    public void atualizarDadosMonitoramento(int id, DadosMonitoramento dadosMonitoramento) {
        this.dadosMonitoramentoApplication.atualizarDadosMonitoramento(id, dadosMonitoramento);
    }
}

