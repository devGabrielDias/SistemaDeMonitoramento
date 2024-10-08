package com.example.sistemaMonitoramento.application;

import com.example.sistemaMonitoramento.entities.DadosDiarios;
import com.example.sistemaMonitoramento.entities.Paciente;
import com.example.sistemaMonitoramento.interfaces.IDadosDiariosRepository;
import com.example.sistemaMonitoramento.interfaces.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DadosDiariosApplication  {

    private IDadosDiariosRepository dadosDiariosRepository;

    @Autowired
    public DadosDiariosApplication(IDadosDiariosRepository dadosDiariosRepository) {
        this.dadosDiariosRepository = dadosDiariosRepository;
    }

    public void adicionar(DadosDiarios dadosDiarios) {
        this.dadosDiariosRepository.adicionar(dadosDiarios);
    }

    public void remover(int id) {this.dadosDiariosRepository.remover(id);}

    public DadosDiarios buscarPorId(int id) {
        return this.dadosDiariosRepository.buscarPorId(id);
    }

    public List<DadosDiarios> buscarTodos() {
        return this.dadosDiariosRepository.buscarTodos();
    }

    public void atualizarDadosDiarios(int id, DadosDiarios dadosDiarios) {
        DadosDiarios DadosDiariosInDb = this.dadosDiariosRepository.buscarPorId(id);

        // Se não existir o dado no banco de dados atavés da camada repository, não dou continuidade a atualização
        if (DadosDiariosInDb == null)
            return;

        this.dadosDiariosRepository.atualizarDadosDiarios(id, dadosDiarios);
    }
}