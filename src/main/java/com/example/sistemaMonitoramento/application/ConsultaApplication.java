package com.example.sistemaMonitoramento.application;

import com.example.sistemaMonitoramento.entities.Consulta;
import com.example.sistemaMonitoramento.interfaces.IConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaApplication {
    private IConsultaRepository consultaRepository;

    @Autowired
    public ConsultaApplication(IConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public void adicionar(Consulta consulta) {
        this.consultaRepository.adicionar(consulta);
    }

    public void remover(int id) {this.consultaRepository.remover(id);}

    public Consulta buscarPorId(int id) {
        return this.consultaRepository.buscarPorId(id);
    }

    public List<Consulta> buscarTodos() {
        return this.consultaRepository.buscarTodos();
    }

    public void atualizarConsulta(int id, Consulta consulta) {
        Consulta consultaInDb = this.consultaRepository.buscarPorId(id);

        // Se não existir o dado no banco de dados atavés da camada repository, não dou continuidade a atualização
        if (consulta == null)
            return;

        this.consultaRepository.atualizarConsulta(id, consulta);
    }
}
