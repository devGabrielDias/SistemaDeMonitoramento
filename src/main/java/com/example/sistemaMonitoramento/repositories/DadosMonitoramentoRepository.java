package com.example.sistemaMonitoramento.repositories;

import com.example.sistemaMonitoramento.entities.Consulta;
import com.example.sistemaMonitoramento.entities.DadosMonitoramento;
import com.example.sistemaMonitoramento.enums.StatusConsulta;
import com.example.sistemaMonitoramento.interfaces.IDadosMonitoramentoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DadosMonitoramentoRepository implements IDadosMonitoramentoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void adicionar(DadosMonitoramento dadosMonitoramento) {
        Consulta consulta = entityManager.find(Consulta.class, dadosMonitoramento.getConsulta().getId());
        if (consulta == null) {
            throw new IllegalArgumentException("Consulta não encontrada.");
        }
        if (consulta.getStatus() != StatusConsulta.AGENDADA) {
            throw new IllegalStateException("Os dados de monitoramento só podem ser registrados para consultas agendadas.");
        }
        dadosMonitoramento.setConsulta(consulta);

        entityManager.persist(dadosMonitoramento);
//        this.entityManager.persist(dadosDiarios);
    }

    @Transactional
    @Override
    public void remover(int id) {
        Query query = entityManager
                .createQuery("delete from DadosMonitoramento s WHERE s.id = :id");

        query.setParameter("id", id);

        query.executeUpdate();
    }

    @Override
    public DadosMonitoramento buscarPorId(int id) {
        return this.entityManager.find(DadosMonitoramento.class, id);
    }


    @Override
    public List<DadosMonitoramento> buscarTodos() {
        return entityManager
                .createQuery("select s from DadosMonitoramento s", DadosMonitoramento.class)
                .getResultList();
    }

    //Confirmar com Jefté se precisa atualizar o "Id" se sim, dadosDiariosInDb.setId(dadosDiarios.getId());, se não, entender de qual forma o Id será gerado automáticamente
    @Transactional
    @Override
    public void atualizarDadosMonitoramento(int id, DadosMonitoramento dadosMonitoramento) {
        DadosMonitoramento dadosMonitoramentoInDb = this.entityManager.find(DadosMonitoramento.class, id);
        dadosMonitoramentoInDb.setMedicamentos(dadosMonitoramento.getMedicamentos());
        dadosMonitoramentoInDb.setSintomas(dadosMonitoramento.getSintomas());
        dadosMonitoramentoInDb.setObservacoes(dadosMonitoramento.getObservacoes());
        dadosMonitoramentoInDb.setData(dadosMonitoramento.getData());

        this.entityManager.merge(dadosMonitoramentoInDb);
    }
}