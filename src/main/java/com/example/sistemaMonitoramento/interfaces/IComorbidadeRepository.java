package com.example.sistemaMonitoramento.interfaces;

import com.example.sistemaMonitoramento.entities.Clinica;
import com.example.sistemaMonitoramento.entities.Comorbidade;

import java.util.List;

public interface IComorbidadeRepository {

        void adicionar(Comorbidade comorbidade);

        void remover(int id);

        Comorbidade buscarPorId(int id);

        List<Comorbidade> buscarTodos();

        void atualizarComorbidade(int id, Comorbidade comorbidade);
    }


