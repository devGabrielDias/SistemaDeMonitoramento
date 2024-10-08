package com.example.sistemaMonitoramento.facade;

import com.example.sistemaMonitoramento.application.RecepcionistaApplication;
import com.example.sistemaMonitoramento.entities.Recepcionista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecepcionistaFacade {

    private final RecepcionistaApplication recepcionistaApplication;

@Autowired
public RecepcionistaFacade(RecepcionistaApplication recepcionistaApplication) {
    this.recepcionistaApplication = recepcionistaApplication;
}

public void adicionar(Recepcionista recepcionista) {
    this.recepcionistaApplication.adicionar(recepcionista);
}

public void remover(int id) {
    this.recepcionistaApplication.remover(id);
}

public Recepcionista buscarPorId(int id) {
    return this.recepcionistaApplication.buscarPorId(id);
}

public List<Recepcionista> buscarTodos() {
    return this.recepcionistaApplication.buscarTodos();
}

public void atualizarRecepcionista(int id, Recepcionista recepcionista) {
    this.recepcionistaApplication.atualizarRecepcionista(id, recepcionista);
}
    }