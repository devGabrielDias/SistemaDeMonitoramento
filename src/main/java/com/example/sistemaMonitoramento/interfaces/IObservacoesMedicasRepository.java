package com.example.sistemaMonitoramento.interfaces;

import com.example.sistemaMonitoramento.entities.ObservacoesMedicas;
import com.example.sistemaMonitoramento.entities.Paciente;

import java.util.List;

public interface IObservacoesMedicasRepository {
    void adicionar(ObservacoesMedicas observacoesMedicas);

    void remover(int id);

    ObservacoesMedicas buscarPorId(int id);

    List<ObservacoesMedicas> buscarTodos();

    void atualizarObservacoesMedicas(int id, ObservacoesMedicas observacoesMedicas);
}
