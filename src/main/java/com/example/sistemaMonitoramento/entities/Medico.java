package com.example.sistemaMonitoramento.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medico")
public class Medico {

    public Medico() {

    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "especialidade", nullable = false)
    private String especialidade;

    @Column(name = "contato")
    private String contato;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "crm")
    private String crm;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clinica_id", referencedColumnName = "id")
    private Clinica clinica;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
    private List<ObservacoesMedicas> observacoesMedicas = new ArrayList<>();

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
    private List<Consulta> consultas = new ArrayList<>();

    public Medico(Integer id, String nome, String especialidade, String contato, String email, String senha, String crm, boolean enabled) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.contato = contato;
        this.email = email;
        this.senha = senha;
        this.crm = crm;
        //this.enabled = enabled;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

}