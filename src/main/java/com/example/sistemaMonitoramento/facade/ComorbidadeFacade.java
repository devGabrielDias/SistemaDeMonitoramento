package com.example.sistemaMonitoramento.facade;

import com.example.sistemaMonitoramento.application.ComorbidadeApplication;
import com.example.sistemaMonitoramento.entities.Comorbidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ComorbidadeFacade {

    private final ComorbidadeApplication comorbidadeApplication;

    @Autowired
    public ComorbidadeFacade(ComorbidadeApplication comorbidadeApplication) {
        this.comorbidadeApplication = comorbidadeApplication;
    }

    public void adicionar(Comorbidade comorbidade) {
        this.comorbidadeApplication.adicionar(comorbidade);
    }

    public void remover(int id) {
        this.comorbidadeApplication.remover(id);
    }

    public Comorbidade buscarPorId(int id) {
        return this.comorbidadeApplication.buscarPorId(id);
    }

    public List<Comorbidade> buscarTodos() {
        return this.comorbidadeApplication.buscarTodos();
    }

    public void atualizarComorbidade(int id, Comorbidade comorbidade) {
        this.comorbidadeApplication.atualizarComorbidade(id, comorbidade);
    }
}