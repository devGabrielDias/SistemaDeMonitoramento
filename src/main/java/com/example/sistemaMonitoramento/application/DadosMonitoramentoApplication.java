package com.example.sistemaMonitoramento.application;

import com.example.sistemaMonitoramento.entities.DadosMonitoramento;
import com.example.sistemaMonitoramento.interfaces.IDadosMonitoramentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DadosMonitoramentoApplication {

    private IDadosMonitoramentoRepository dadosMonitoramentoRepository;

    @Autowired
    public DadosMonitoramentoApplication(IDadosMonitoramentoRepository dadosMonitoramentoRepository) {
        this.dadosMonitoramentoRepository = dadosMonitoramentoRepository;
    }

    public void adicionar(DadosMonitoramento dadosMonitoramento) {
        this.dadosMonitoramentoRepository.adicionar(dadosMonitoramento);
    }

    public void remover(int id) {this.dadosMonitoramentoRepository.remover(id);}

    public DadosMonitoramento buscarPorId(int id) {
        return this.dadosMonitoramentoRepository.buscarPorId(id);
    }

    public List<DadosMonitoramento> buscarTodos() {
        return this.dadosMonitoramentoRepository.buscarTodos();
    }

    public void atualizarDadosMonitoramento(int id, DadosMonitoramento dadosMonitoramento) {
        DadosMonitoramento dadosMonitoramentoInDb = this.dadosMonitoramentoRepository.buscarPorId(id);

        // Se não existir o dado no banco de dados atavés da camada repository, não dou continuidade a atualização
        if (dadosMonitoramentoInDb == null)
            return;

        this.dadosMonitoramentoRepository.atualizarDadosMonitoramento(id, dadosMonitoramento);
    }
}