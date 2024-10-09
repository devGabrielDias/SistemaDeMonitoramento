package com.example.sistemaMonitoramento.facade;

import com.example.sistemaMonitoramento.application.MedicoApplication;
import com.example.sistemaMonitoramento.application.PacienteApplication;
import com.example.sistemaMonitoramento.entities.Medico;
import com.example.sistemaMonitoramento.entities.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MedicoFacade {
    private final MedicoApplication medicoApplication;

    @Autowired
    public MedicoFacade(MedicoApplication medicoApplication) {
        this.medicoApplication = medicoApplication;
    }

    public void adicionar(Medico medico) {
        this.medicoApplication.adicionar(medico);
    }

    public void remover(int id) {
        this.medicoApplication.remover(id);
    }

    public Medico buscarPorId(int id) {
        return this.medicoApplication.buscarPorId(id);
    }

    public List<Medico> buscarTodos() {
        return this.medicoApplication.buscarTodos();
    }

    public void atualizarMedico(int id, Medico medico) {
        this.medicoApplication.atualizarMedico(id, medico);
    }
}

