package com.example.sistemaMonitoramento.application;

import com.example.sistemaMonitoramento.entities.Clinica;
import com.example.sistemaMonitoramento.interfaces.IClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicaApplication {

    private IClinicaRepository clinicaRepository;

    @Autowired
    public ClinicaApplication(IClinicaRepository clinicaRepository) {
        this.clinicaRepository = clinicaRepository;
    }

    public void adicionar(Clinica clinica) {
        this.clinicaRepository.adicionar(clinica);
    }

    public void remover(int id) {this.clinicaRepository.remover(id);}

    public Clinica buscarPorId(int id) {
        return this.clinicaRepository.buscarPorId(id);
    }

    public List<Clinica> buscarTodos() {
        return this.clinicaRepository.buscarTodos();
    }

    public void atualizarClinica(int id, Clinica clinica) {
        Clinica clinicaInDb = this.clinicaRepository.buscarPorId(id);

        // Se não existir o dado no banco de dados atavés da camada repository, não dou continuidade a atualização
        if (clinicaInDb == null)
            return;

        this.clinicaRepository.atualizarClinica(id, clinica);
    }
}
