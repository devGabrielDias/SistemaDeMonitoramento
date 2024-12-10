package com.example.sistemaMonitoramento.application;


import com.example.sistemaMonitoramento.entities.Recepcionista;
import com.example.sistemaMonitoramento.interfaces.IRecepcionistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecepcionistaApplication {

    private IRecepcionistaRepository recepcionistaRepository;

    @Autowired
    public RecepcionistaApplication(IRecepcionistaRepository recepcionistaRepository) {
        this.recepcionistaRepository = recepcionistaRepository;
    }

    public void adicionar(Recepcionista recepcionista) {
        try {
            this.recepcionistaRepository.adicionar(recepcionista);
        } catch (Exception e) {
            // Logando a exceção para entender o erro
            e.printStackTrace();
            throw new RuntimeException("Erro ao adicionar recepcionista", e);
        }
    }

    public void remover(int id) {this.recepcionistaRepository.remover(id);}

    public Recepcionista buscarPorId(int id) {
        return this.recepcionistaRepository.buscarPorId(id);
    }

    public List<Recepcionista> buscarTodos() {
        return this.recepcionistaRepository.buscarTodos();
    }

    public void atualizarRecepcionista(int id, Recepcionista recepcionista) {
        Recepcionista recepcionistaInDb = this.recepcionistaRepository.buscarPorId(id);

        // Se não existir o dado no banco de dados atavés da camada repository, não dou continuidade a atualização
        if (recepcionistaInDb == null)
            return;

        this.recepcionistaRepository.atualizarRecepcionista(id, recepcionista);
    }
}