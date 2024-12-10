package com.example.sistemaMonitoramento.repositories;

import com.example.sistemaMonitoramento.entities.Clinica;
import com.example.sistemaMonitoramento.interfaces.IClinicaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClinicaRepository implements IClinicaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public ClinicaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void adicionar(Clinica clinica) {
        this.entityManager.persist(clinica);
    }

    @Transactional
    @Override
    public void remover(int id) {
        Query query = entityManager
                .createQuery("delete from Clinica s WHERE s.id = :id");

        query.setParameter("id", id);

        query.executeUpdate();
    }

    @Override
    public Clinica buscarPorId(int id) {
        return this.entityManager.find(Clinica.class, id);
    }

    @Override
    public List<Clinica> buscarTodos() {
        return entityManager
                .createQuery("select s from Clinica s", Clinica.class)
                .getResultList();
    }

    @Transactional
    @Override
    public void atualizarClinica(int id, Clinica clinica) {
        Clinica clinicaInDb =  this.entityManager.find(Clinica.class, id);

        clinicaInDb.setNome(clinica.getNome());
        clinicaInDb.setEndereco(clinica.getEndereco());
        clinicaInDb.setTelefone(clinica.getTelefone());

        this.entityManager.merge(clinicaInDb);
    }
}
