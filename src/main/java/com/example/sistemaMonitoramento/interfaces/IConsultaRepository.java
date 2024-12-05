package com.example.sistemaMonitoramento.interfaces;

import com.example.sistemaMonitoramento.entities.Consulta;

import java.util.List;

public interface IConsultaRepository {
    void adicionar(Consulta consulta);

    void remover(int id);

    Consulta buscarPorId(int id);

    List<Consulta> buscarTodos();

    void atualizarConsulta(int id, Consulta consulta);
}
