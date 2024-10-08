package com.example.sistemaMonitoramento.repositories;

import com.example.sistemaMonitoramento.entities.Comorbidade;
import com.example.sistemaMonitoramento.interfaces.IComorbidadeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComorbidadeRepository implements IComorbidadeRepository {

    private EntityManager entityManager;

    @Transactional
    @Override
    public void adicionar(Comorbidade comorbidade) {
        this.entityManager.persist(comorbidade);
    }

    @Transactional
    @Override
    public void remover(int id) {
        Query query = entityManager
                .createQuery("delete from Comorbidade s WHERE s.id = :id");

        query.setParameter("id", id);

        query.executeUpdate();
    }

    @Override
    public Comorbidade buscarPorId(int id) {
        return this.entityManager.find(Comorbidade.class, id);
    }

    @Override
    public List<Comorbidade> buscarTodos() {
        return entityManager
                .createQuery("select s from Comorbidade s", Comorbidade.class)
                .getResultList();
    }

    @Transactional
    @Override
    public void atualizarComorbidade(int id, Comorbidade comorbidade) {
        Comorbidade comorbidadeInDb = this.entityManager.find(Comorbidade.class, id);

        comorbidadeInDb.setNome(comorbidade.getNome());
        comorbidadeInDb.setDescricao(comorbidade.getDescricao());

        this.entityManager.merge(comorbidadeInDb);
    }
}

