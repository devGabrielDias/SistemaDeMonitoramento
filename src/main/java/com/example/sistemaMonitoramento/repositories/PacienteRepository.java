package com.example.sistemaMonitoramento.repositories;

import com.example.sistemaMonitoramento.entities.Clinica;
import com.example.sistemaMonitoramento.entities.Comorbidade;
import com.example.sistemaMonitoramento.entities.Paciente;
import com.example.sistemaMonitoramento.entities.User;
import com.example.sistemaMonitoramento.interfaces.IPacienteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PacienteRepository implements IPacienteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void adicionar(Paciente paciente) {
        Clinica clinica = entityManager.find(Clinica.class, paciente.getClinica().getId());
        paciente.setClinica(clinica);

        //Comorbidade comorbidade = entityManager.find(Comorbidade.class, paciente.getComorbidade().getId());
        //paciente.setComorbidade(comorbidade);

        entityManager.persist(paciente);
//        this.entityManager.persist(paciente);
    }

    @Transactional
    @Override
    public void remover(int id) {
        Query query = entityManager
                .createQuery("delete from Paciente s WHERE s.id = :id");

        query.setParameter("id", id);

        query.executeUpdate();
    }

    @Override
    public Paciente buscarPorId(int id) {
        return this.entityManager.find(Paciente.class, id);
    }


    @Override
    public List<Paciente> buscarTodos() {
        return entityManager
                .createQuery("select s from Paciente s", Paciente.class)
                .getResultList();
    }

    @Transactional
    @Override
    public void atualizarPaciente(int id, Paciente paciente) {
        Paciente pacienteInDb = this.entityManager.find(Paciente.class, id);

        pacienteInDb.setNome(paciente.getNome());
        pacienteInDb.setIdade(paciente.getIdade());
        //pacienteInDb.setHistoricoMedico(paciente.getHistoricoMedico());
        pacienteInDb.setContato(paciente.getContato());
        pacienteInDb.setEmail(paciente.getEmail());
        pacienteInDb.setSenha(paciente.getSenha());

        this.entityManager.merge(pacienteInDb);
    }
}



