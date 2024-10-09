package com.example.sistemaMonitoramento.facade;

import com.example.sistemaMonitoramento.application.ClinicaApplication;
import com.example.sistemaMonitoramento.entities.Clinica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClinicaFacade {
    private final ClinicaApplication clinicaApplication;

    @Autowired
    public ClinicaFacade(ClinicaApplication clinicaApplication) {
        this.clinicaApplication = clinicaApplication;
    }

    public void adicionar(Clinica clinica) {
        this.clinicaApplication.adicionar(clinica);
    }

    public void remover(int id) {
        this.clinicaApplication.remover(id);
    }

    public Clinica buscarPorId(int id) {
        return this.clinicaApplication.buscarPorId(id);
    }

    public List<Clinica> buscarTodos() {
        return this.clinicaApplication.buscarTodos();
    }

    public void atualizarClinica(int id, Clinica clinica) {
        this.clinicaApplication.atualizarClinica(id, clinica);
    }
}