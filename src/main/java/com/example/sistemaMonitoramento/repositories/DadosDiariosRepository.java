package com.example.sistemaMonitoramento.repositories;

import com.example.sistemaMonitoramento.entities.Clinica;
import com.example.sistemaMonitoramento.entities.Comorbidade;
import com.example.sistemaMonitoramento.entities.DadosDiarios;
import com.example.sistemaMonitoramento.entities.Paciente;
import com.example.sistemaMonitoramento.interfaces.IDadosDiariosRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DadosDiariosRepository implements IDadosDiariosRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void adicionar(DadosDiarios dadosDiarios) {
        Paciente paciente = entityManager.find(Paciente.class, dadosDiarios.getPaciente().getId());
        dadosDiarios.setPaciente(paciente);

        entityManager.persist(dadosDiarios);
//        this.entityManager.persist(dadosDiarios);
    }

    @Transactional
    @Override
    public void remover(int id) {
        Query query = entityManager
                .createQuery("delete from DadosDiarios s WHERE s.id = :id");

        query.setParameter("id", id);

        query.executeUpdate();
    }

    @Override
    public DadosDiarios buscarPorId(int id) {
        return this.entityManager.find(DadosDiarios.class, id);
    }


    @Override
    public List<DadosDiarios> buscarTodos() {
        return entityManager
                .createQuery("select s from DadosDiarios s", DadosDiarios.class)
                .getResultList();
    }

    //Confirmar com Jefté se precisa atualizar o "Id" se sim, dadosDiariosInDb.setId(dadosDiarios.getId());, se não, entender de qual forma o Id será gerado automáticamente
    @Transactional
    @Override
    public void atualizarDadosDiarios(int id, DadosDiarios dadosDiarios) {
        DadosDiarios dadosDiariosInDb = this.entityManager.find(DadosDiarios.class, id);

        dadosDiariosInDb.setOutrasMedicacoes(dadosDiarios.getOutrasMedicacoes());
        dadosDiariosInDb.setDescricaoDia(dadosDiarios.getDescricaoDia());
        dadosDiariosInDb.setHorarioMedicacao(dadosDiarios.getHorarioMedicacao());
        dadosDiariosInDb.setDesconforto(dadosDiarios.getDesconforto());
        dadosDiariosInDb.setData(dadosDiarios.getData());

        this.entityManager.merge(dadosDiariosInDb);
    }
}