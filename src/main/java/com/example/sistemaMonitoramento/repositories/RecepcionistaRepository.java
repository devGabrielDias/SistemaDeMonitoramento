package com.example.sistemaMonitoramento.repositories;


import com.example.sistemaMonitoramento.entities.Clinica;
import com.example.sistemaMonitoramento.entities.Recepcionista;
import com.example.sistemaMonitoramento.interfaces.IRecepcionistaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class RecepcionistaRepository implements IRecepcionistaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void adicionar(Recepcionista recepcionista) {
        Clinica clinica = entityManager.find(Clinica.class, recepcionista.getClinica().getId());
        recepcionista.setClinica(clinica);

        entityManager.persist(recepcionista);
//        this.entityManager.persist(recepcionista);
    }

    @Transactional
    @Override
    public void remover(int id) {
        Query query = entityManager
                .createQuery("delete from Recepcionista s WHERE s.id = :id");

        query.setParameter("id", id);

        query.executeUpdate();
    }

    @Override
    public Recepcionista buscarPorId(int id) {
        return this.entityManager.find(Recepcionista.class, id);
    }


    @Override
    public List<Recepcionista> buscarTodos() {
        return entityManager
                .createQuery("select s from Recepcionista s", Recepcionista.class)
                .getResultList();
    }

    @Transactional
    @Override
    public void atualizarRecepcionista(int id, Recepcionista recepcionista) {
        Recepcionista recepcionistaInDb = this.entityManager.find(Recepcionista.class, id);

        //recepcionistaInDb.setId(recepcionista.getId());
        recepcionistaInDb.setNome(recepcionista.getNome());
        recepcionistaInDb.setEmail(recepcionista.getEmail());
        recepcionistaInDb.setSenha(recepcionista.getSenha());

        this.entityManager.merge(recepcionistaInDb);
    }
}
