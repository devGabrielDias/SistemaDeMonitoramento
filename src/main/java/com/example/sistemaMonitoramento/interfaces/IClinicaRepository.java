package com.example.sistemaMonitoramento.interfaces;

import com.example.sistemaMonitoramento.entities.Clinica;

import java.util.ArrayList;
import java.util.List;

public interface IClinicaRepository {
    void adicionar(Clinica clinica);

    void remover(int id);

    Clinica buscarPorId(int id);

    List<Clinica> buscarTodos();

    void atualizarClinica(int id, Clinica clinica);
}
