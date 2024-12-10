package com.example.sistemaMonitoramento.facade;

import com.example.sistemaMonitoramento.application.PacienteApplication;
import com.example.sistemaMonitoramento.entities.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PacienteFacade {

        private final PacienteApplication pacienteApplication;

        @Autowired
        public PacienteFacade(PacienteApplication pacienteApplication) {
            this.pacienteApplication = pacienteApplication;
        }

        public void adicionar(Paciente paciente) {
            this.pacienteApplication.adicionar(paciente);
        }

        public void remover(int id) {
            this.pacienteApplication.remover(id);
        }

        public Paciente buscarPorId(int id) {
            return this.pacienteApplication.buscarPorId(id);
        }

        public List<Paciente> buscarTodos() {
            return this.pacienteApplication.buscarTodos();
        }

        public void atualizarPaciente(int id, Paciente paciente) {
            this.pacienteApplication.atualizarPaciente(id, paciente);
        }
    }

