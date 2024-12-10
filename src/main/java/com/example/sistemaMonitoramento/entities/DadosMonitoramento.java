package com.example.sistemaMonitoramento.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "dadosmonitoramento")
public class DadosMonitoramento {

    public DadosMonitoramento() {

    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    //Implementar relacionamento com Paciente

    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "sintomas")
    private String sintomas;

    @Column(name = "medicamentos")
    private String medicamentos;

    @Column(name = "observacoes")
    private String observacoes;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "consulta_id", referencedColumnName = "id")
    private Consulta consulta;


    public DadosMonitoramento(int id, Date data, String sintomas, String medicamentos, String observacoes) {
        this.id = id;
        this.data = data;
        this.sintomas = sintomas;
        this.medicamentos = medicamentos;
        this.observacoes = observacoes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}
