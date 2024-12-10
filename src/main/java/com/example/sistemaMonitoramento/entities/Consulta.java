package com.example.sistemaMonitoramento.entities;

import com.example.sistemaMonitoramento.enums.StatusConsulta;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "consulta")
public class        Consulta {
    public Consulta() {

    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data", nullable = false)
    private Date data;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusConsulta status = StatusConsulta.AGENDADA;

    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL)
    private List<DadosMonitoramento> dadosMonitoramentos = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private Paciente paciente;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medico_id", referencedColumnName = "id")
    private Medico medico;

    public Consulta(int id, Date data, StatusConsulta status) {
        this.id = id;
        this.data = data;
        this.status = status;
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

    public StatusConsulta getStatus() {
        return status;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
