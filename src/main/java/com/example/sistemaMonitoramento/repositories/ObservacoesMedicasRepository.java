package com.example.sistemaMonitoramento.repositories;

import com.example.sistemaMonitoramento.entities.ObservacoesMedicas;
import com.example.sistemaMonitoramento.entities.Paciente;
import com.example.sistemaMonitoramento.interfaces.IObservacoesMedicasRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ObservacoesMedicasRepository implements IObservacoesMedicasRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void adicionar(ObservacoesMedicas observacoesMedicas) {
        this.entityManager.persist(observacoesMedicas);
    }

    @Transactional
    @Override
    public void remover(int id) {
        Query query = entityManager
                .createQuery("delete from ObservacoesMedicas s WHERE s.id = :id");

        query.setParameter("id", id);

        query.executeUpdate();
    }

    @Override
    public ObservacoesMedicas buscarPorId(int id) {
        return this.entityManager.find(ObservacoesMedicas.class, id);
    }


    @Override
    public List<ObservacoesMedicas> buscarTodos() {
        return entityManager
                .createQuery("select s from ObservacoesMedicas s", ObservacoesMedicas.class)
                .getResultList();
    }

    @Transactional
    @Override
    public void atualizarObservacoesMedicas(int id, ObservacoesMedicas observacoesMedicas) {
        ObservacoesMedicas observacoesMedicasInDb = this.entityManager.find(ObservacoesMedicas.class, id);

        observacoesMedicasInDb.setObservacao(observacoesMedicas.getObservacao());
        observacoesMedicasInDb.setData(observacoesMedicas.getData());
        // se for necessário - observacoesMedicasInDb.setId(observacoesMedicas.getId());

        this.entityManager.merge(observacoesMedicasInDb);
    }
}
