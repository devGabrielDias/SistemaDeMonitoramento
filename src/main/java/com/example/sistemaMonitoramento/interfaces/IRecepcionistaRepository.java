package com.example.sistemaMonitoramento.interfaces;


import com.example.sistemaMonitoramento.entities.Recepcionista;

import java.util.List;

public interface IRecepcionistaRepository {
    void adicionar(Recepcionista recepcionista);

    void remover(int id);

    Recepcionista buscarPorId(int id);

    List<Recepcionista> buscarTodos();

    void atualizarRecepcionista(int id, Recepcionista recepcionista);
}
