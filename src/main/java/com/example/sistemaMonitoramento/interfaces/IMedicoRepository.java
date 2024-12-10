package com.example.sistemaMonitoramento.interfaces;

import com.example.sistemaMonitoramento.entities.Medico;
import com.example.sistemaMonitoramento.entities.Paciente;

import java.util.List;

public interface IMedicoRepository {
    void adicionar(Medico medico);

    void remover(int id);

    Medico buscarPorId(int id);

    List<Medico> buscarTodos();

    void atualizarMedico(int id, Medico medico);
}
