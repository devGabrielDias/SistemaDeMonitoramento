package com.example.sistemaMonitoramento.application;


import com.example.sistemaMonitoramento.entities.Paciente;
import com.example.sistemaMonitoramento.interfaces.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteApplication {

    private IPacienteRepository pacienteRepository;

    @Autowired
    public PacienteApplication(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public void adicionar(Paciente paciente) {
        this.pacienteRepository.adicionar(paciente);
    }

    public void remover(int id) {this.pacienteRepository.remover(id);}

    public Paciente buscarPorId(int id) {
        return this.pacienteRepository.buscarPorId(id);
    }

    public List<Paciente> buscarTodos() {
        return this.pacienteRepository.buscarTodos();
    }

    public void atualizarPaciente(int id, Paciente paciente) {
        Paciente pacienteInDb = this.pacienteRepository.buscarPorId(id);

        // Se não existir o dado no banco de dados atavés da camada repository, não dou continuidade a atualização
        if (pacienteInDb == null)
            return;

        this.pacienteRepository.atualizarPaciente(id, paciente);
    }
}