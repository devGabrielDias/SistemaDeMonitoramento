package com.example.sistemaMonitoramento.application;

import com.example.sistemaMonitoramento.entities.ObservacoesMedicas;
import com.example.sistemaMonitoramento.interfaces.IObservacoesMedicasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ObservacoesMedicasApplication {

    private IObservacoesMedicasRepository observacoesMedicasRepository;

    @Autowired
    public ObservacoesMedicasApplication(IObservacoesMedicasRepository observacoesMedicasRepository) {
        this.observacoesMedicasRepository = observacoesMedicasRepository;
    }

    public void adicionar(ObservacoesMedicas observacoesMedicas) {this.observacoesMedicasRepository.adicionar(observacoesMedicas);}

    public void remover(int id) {this.observacoesMedicasRepository.remover(id);}

    public ObservacoesMedicas buscarPorId(int id) {
        return this.observacoesMedicasRepository.buscarPorId(id);
    }

    public List<ObservacoesMedicas> buscarTodos() {
        return this.observacoesMedicasRepository.buscarTodos();
    }

    public void atualizarObservacoesMedicas(int id, ObservacoesMedicas observacoesMedicas) {
        ObservacoesMedicas observacoesMedicasInDb = this.observacoesMedicasRepository.buscarPorId(id);

        // Se não existir o dado no banco de dados atavés da camada repository, não dou continuidade a atualização
        if (observacoesMedicasInDb == null)
            return;

        this.observacoesMedicasRepository.atualizarObservacoesMedicas(id, observacoesMedicas);
    }
}