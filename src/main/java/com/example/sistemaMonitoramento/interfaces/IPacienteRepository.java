package com.example.sistemaMonitoramento.interfaces;


import com.example.sistemaMonitoramento.entities.Paciente;

import java.util.List;

public interface IPacienteRepository {
    void adicionar(Paciente paciente);

    void remover(int id);

    Paciente buscarPorId(int id);

    List<Paciente> buscarTodos();

    void atualizarPaciente(int id, Paciente paciente);
}
