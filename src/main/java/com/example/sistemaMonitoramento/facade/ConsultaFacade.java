package com.example.sistemaMonitoramento.facade;

import com.example.sistemaMonitoramento.application.ConsultaApplication;
import com.example.sistemaMonitoramento.entities.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsultaFacade {
    private final ConsultaApplication consultaApplication;

    @Autowired
    public ConsultaFacade(ConsultaApplication consultaApplication) {
        this.consultaApplication = consultaApplication;
    }

    public void adicionar(Consulta consulta) {
        this.consultaApplication.adicionar(consulta);
    }

    public void remover(int id) {
        this.consultaApplication.remover(id);
    }

    public Consulta buscarPorId(int id) {
        return this.consultaApplication.buscarPorId(id);
    }

    public List<Consulta> buscarTodos() {
        return this.consultaApplication.buscarTodos();
    }

    public void atualizarConsulta(int id, Consulta consulta) {
        this.consultaApplication.atualizarConsulta(id, consulta);
    }
}
