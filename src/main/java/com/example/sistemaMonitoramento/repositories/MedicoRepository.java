package com.example.sistemaMonitoramento.repositories;

import com.example.sistemaMonitoramento.entities.Clinica;
import com.example.sistemaMonitoramento.entities.Medico;
import com.example.sistemaMonitoramento.entities.Paciente;
import com.example.sistemaMonitoramento.interfaces.IMedicoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class MedicoRepository implements IMedicoRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void adicionar(Medico medico) {
        Clinica clinica = entityManager.find(Clinica.class, medico.getClinica().getId());
        medico.setClinica(clinica);

        entityManager.persist(medico);
//        this.entityManager.persist(medico);
    }

    @Transactional
    @Override
    public void remover(int id) {
        Query query = entityManager
                .createQuery("delete from Medico s WHERE s.id = :id");

        query.setParameter("id", id);

        query.executeUpdate();
    }

    @Override
    public Medico buscarPorId(int id) {
        return this.entityManager.find(Medico.class, id);
    }


    @Override
    public List<Medico> buscarTodos() {
        return entityManager
                .createQuery("select s from Medico s", Medico.class)
                .getResultList();
    }


    //caso precisar de Id aqui medicoInDb.setId(medico.getId());
    @Transactional
    @Override
    public void atualizarMedico(int id, Medico medico) {
        Medico medicoInDb = this.entityManager.find(Medico.class, id);

        medicoInDb.setNome(medico.getNome());
        medicoInDb.setEspecialidade(medico.getEspecialidade());
        medicoInDb.setCrm(medico.getCrm());
        medicoInDb.setContato(medico.getContato());
        medicoInDb.setSenha(medico.getSenha());
        medicoInDb.setEmail(medico.getEmail());


        this.entityManager.merge(medicoInDb);
    }
}
