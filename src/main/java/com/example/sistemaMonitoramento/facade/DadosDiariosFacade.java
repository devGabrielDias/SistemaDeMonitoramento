package com.example.sistemaMonitoramento.facade;

import com.example.sistemaMonitoramento.application.DadosDiariosApplication;
import com.example.sistemaMonitoramento.entities.DadosDiarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DadosDiariosFacade {
    private final DadosDiariosApplication dadosDiariosApplication;

    @Autowired
    public DadosDiariosFacade(DadosDiariosApplication dadosDiariosApplication) {
        this.dadosDiariosApplication = dadosDiariosApplication;
    }

    public void adicionar(DadosDiarios dadosDiarios) {
        this.dadosDiariosApplication.adicionar(dadosDiarios);
    }

    public void remover(int id) {
        this.dadosDiariosApplication.remover(id);
    }

    public DadosDiarios buscarPorId(int id) {
        return this.dadosDiariosApplication.buscarPorId(id);
    }

    public List<DadosDiarios> buscarTodos() {
        return this.dadosDiariosApplication.buscarTodos();
    }

    public void atualizarDadosDiarios(int id, DadosDiarios dadosDiarios) {
        this.dadosDiariosApplication.atualizarDadosDiarios(id, dadosDiarios);
    }
}

