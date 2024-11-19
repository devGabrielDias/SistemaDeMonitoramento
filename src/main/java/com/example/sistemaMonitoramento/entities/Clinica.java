package com.example.sistemaMonitoramento.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.ALWAYS)
@Entity
@Table(name = "clinica")
public class Clinica {



    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "telefone")
    private String telefone;

    @OneToMany(mappedBy = "clinica", cascade = CascadeType.ALL)
    private List<Paciente> pacientes = new ArrayList<>();

    @OneToMany(mappedBy = "clinica", cascade = CascadeType.ALL)
    private List<Medico> medicos = new ArrayList<>();

    @OneToMany(mappedBy = "clinica", cascade = CascadeType.ALL)
    private List<Recepcionista> recepcionistas = new ArrayList<>();

    public Clinica (){

    }

    public Clinica(int id, String nome, String endereco, String telefone) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
