package com.example.sistemaMonitoramento.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "observacoesmedica")
public class ObservacoesMedicas {

    public ObservacoesMedicas() {

    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "observacao")
    private String observacao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private Paciente paciente;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medico_id", referencedColumnName = "id")
    private Medico medico;

    public ObservacoesMedicas(int id, Date data, String observacao) {
        this.id = id;
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}