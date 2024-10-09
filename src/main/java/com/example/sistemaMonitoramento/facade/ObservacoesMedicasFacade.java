package com.example.sistemaMonitoramento.facade;

import com.example.sistemaMonitoramento.application.ObservacoesMedicasApplication;
import com.example.sistemaMonitoramento.application.PacienteApplication;
import com.example.sistemaMonitoramento.entities.ObservacoesMedicas;
import com.example.sistemaMonitoramento.entities.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ObservacoesMedicasFacade {

private final ObservacoesMedicasApplication observacoesMedicasApplication;

@Autowired
public ObservacoesMedicasFacade(ObservacoesMedicasApplication observacoesMedicasApplication) {
    this.observacoesMedicasApplication = observacoesMedicasApplication;
}

public void adicionar(ObservacoesMedicas observacoesMedicas) {
    this.observacoesMedicasApplication.adicionar(observacoesMedicas);
}

public void remover(int id) {
    this.observacoesMedicasApplication.remover(id);
}

public ObservacoesMedicas buscarPorId(int id) {
    return this.observacoesMedicasApplication.buscarPorId(id);
}

public List<ObservacoesMedicas> buscarTodos() {
    return this.observacoesMedicasApplication.buscarTodos();
}

public void atualizarObservacoesMedicas(int id, ObservacoesMedicas observacoesMedicas) {
    this.observacoesMedicasApplication.atualizarObservacoesMedicas(id, observacoesMedicas);
}
    }