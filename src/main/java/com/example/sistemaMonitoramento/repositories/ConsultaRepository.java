package com.example.sistemaMonitoramento.repositories;

import com.example.sistemaMonitoramento.entities.Clinica;
import com.example.sistemaMonitoramento.entities.Consulta;
import com.example.sistemaMonitoramento.entities.Medico;
import com.example.sistemaMonitoramento.entities.Paciente;
import com.example.sistemaMonitoramento.interfaces.IConsultaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ConsultaRepository implements IConsultaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void adicionar(Consulta consulta) {
        Paciente paciente = entityManager.find(Paciente.class, consulta.getPaciente().getId());
        consulta.setPaciente(paciente);
        Medico medico = entityManager.find(Medico.class, consulta.getMedico().getId());
        consulta.setMedico(medico);

        entityManager.persist(consulta);
    }

    @Transactional
    @Override
    public void remover(int id) {
        Query query = entityManager
                .createQuery("delete from Consulta s WHERE s.id = :id");

        query.setParameter("id", id);

        query.executeUpdate();
    }

    @Override
    public Consulta buscarPorId(int id) {
        return this.entityManager.find(Consulta.class, id);
    }


    @Override
    public List<Consulta> buscarTodos() {
        return entityManager
                .createQuery("select s from Consulta s", Consulta.class)
                .getResultList();
    }

    @Transactional
    @Override
    public void atualizarConsulta(int id, Consulta consulta) {
        Consulta consultaInDb = this.entityManager.find(Consulta.class, id);
        consultaInDb.setData(consulta.getData());
        consultaInDb.setStatus(consulta.getStatus());

        this.entityManager.merge(consultaInDb);
    }
}
