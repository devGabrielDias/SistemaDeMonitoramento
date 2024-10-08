package com.example.sistemaMonitoramento.application;

import com.example.sistemaMonitoramento.entities.Paciente;
import com.example.sistemaMonitoramento.entities.Recepcionista;
import com.example.sistemaMonitoramento.interfaces.IPacienteRepository;
import com.example.sistemaMonitoramento.interfaces.IRecepcionistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecepcionistaApplication  {

    private IRecepcionistaRepository recepcionistaRepository;

    @Autowired
    public RecepcionistaApplication(IRecepcionistaRepository recepcionistaRepository) {this.recepcionistaRepository = recepcionistaRepository;}

    public void adicionar(Recepcionista recepcionista) {
        this.recepcionistaRepository.adicionar(recepcionista);
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