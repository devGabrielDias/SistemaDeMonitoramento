package com.example.sistemaMonitoramento.application;


import com.example.sistemaMonitoramento.entities.Comorbidade;
import com.example.sistemaMonitoramento.entities.Paciente;
import com.example.sistemaMonitoramento.interfaces.IComorbidadeRepository;
import com.example.sistemaMonitoramento.interfaces.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComorbidadeApplication {

    private IComorbidadeRepository comorbidadeRepository;

    @Autowired
    public ComorbidadeApplication(IComorbidadeRepository comorbidadeRepository) {
        this.comorbidadeRepository = comorbidadeRepository;
    }

    public void adicionar(Comorbidade comorbidade) {
        this.comorbidadeRepository.adicionar(comorbidade);
    }

    public void remover(int id) {this.comorbidadeRepository.remover(id);}

    public Comorbidade buscarPorId(int id) {
        return this.comorbidadeRepository.buscarPorId(id);
    }

    public List<Comorbidade> buscarTodos() {
        return this.comorbidadeRepository.buscarTodos();
    }

    public void atualizarComorbidade(int id, Comorbidade comorbidade) {
        Comorbidade comorbidadeInDb = this.comorbidadeRepository.buscarPorId(id);

        // Se não existir o dado no banco de dados atavés da camada repository, não dou continuidade a atualização
        if (comorbidadeInDb == null)
            return;

        this.comorbidadeRepository.atualizarComorbidade(id, comorbidade);
    }
}