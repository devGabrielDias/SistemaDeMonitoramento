package com.example.sistemaMonitoramento.application;

import com.example.sistemaMonitoramento.entities.Medico;
import com.example.sistemaMonitoramento.entities.Paciente;
import com.example.sistemaMonitoramento.interfaces.IMedicoRepository;
import com.example.sistemaMonitoramento.interfaces.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoApplication  {

    private IMedicoRepository medicoRepository;

    @Autowired
    public MedicoApplication(IMedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public void adicionar(Medico medico) {
        this.medicoRepository.adicionar(medico);
    }

    public void remover(int id) {this.medicoRepository.remover(id);}

    public Medico buscarPorId(int id) {
        return this.medicoRepository.buscarPorId(id);
    }

    public List<Medico> buscarTodos() {
        return this.medicoRepository.buscarTodos();
    }

    public void atualizarMedico(int id, Medico medico) {
        Medico medicoInDb = this.medicoRepository.buscarPorId(id);

        // Se não existir o dado no banco de dados atavés da camada repository, não dou continuidade a atualização
        if (medicoInDb == null)
            return;

        this.medicoRepository.atualizarMedico(id, medico);
    }
}