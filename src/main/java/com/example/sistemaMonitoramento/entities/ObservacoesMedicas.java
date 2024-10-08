package com.example.sistemaMonitoramento.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "observacoesmedicas")
public class ObservacoesMedicas {

    public ObservacoesMedicas() {

    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@ManyToOne
    //@JoinColumn(name = "id_paciente", nullable = false)
    //private Paciente paciente;

    //@ManyToOne
    //@JoinColumn(name = "id_medico", nullable = false)
    //private Medico medico;

    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "observacao")
    private String observacao;

    public ObservacoesMedicas(int id, Paciente paciente, Medico medico, Date data, String observacao) {
        this.id = id;
        //this.paciente = paciente;
        //this.medico = medico;
        this.data = data;
        this.observacao = observacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}