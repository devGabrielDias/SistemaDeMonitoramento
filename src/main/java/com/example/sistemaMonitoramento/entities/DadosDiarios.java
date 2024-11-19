package com.example.sistemaMonitoramento.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "dadosdiario")
public class DadosDiarios {

    public DadosDiarios() {

    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    //Implementar relacionamento com Paciente

    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "horario_medicacao")
    private String horarioMedicacao;

    @Column(name = "descricao_dia")
    private String descricaoDia;

    @Column(name = "desconforto")
    private String desconforto;

    @Column(name = "outras_medicacoes")
    private String outrasMedicacoes;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private Paciente paciente;


    public DadosDiarios(int id, Date data, String horarioMedicacao, String descricaoDia, String desconforto, String outrasMedicacoes) {
        this.id = id;
        this.data = data;
        this.horarioMedicacao = horarioMedicacao;
        this.descricaoDia = descricaoDia;
        this.desconforto = desconforto;
        this.outrasMedicacoes = outrasMedicacoes;
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

    public String getHorarioMedicacao() {
        return horarioMedicacao;
    }

    public void setHorarioMedicacao(String horarioMedicacao) {
        this.horarioMedicacao = horarioMedicacao;
    }

    public String getDescricaoDia() {
        return descricaoDia;
    }

    public void setDescricaoDia(String descricaoDia) {
        this.descricaoDia = descricaoDia;
    }

    public String getOutrasMedicacoes() {
        return outrasMedicacoes;
    }

    public void setOutrasMedicacoes(String outrasMedicacoes) {
        this.outrasMedicacoes = outrasMedicacoes;
    }

    public String getDesconforto() {
        return desconforto;
    }

    public void setDesconforto(String desconforto) {
        this.desconforto = desconforto;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
