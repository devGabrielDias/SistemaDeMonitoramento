package com.example.sistemaMonitoramento.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "recepcionistas")
public class Recepcionista {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome", nullable = false)
    private String nome;

    //@ManyToOne
    //@JoinColumn(name = "id_clinica", nullable = false)
    //private Clinica clinica;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    public Recepcionista(int id, String nome, Clinica clinica, String email, String senha) {
        this.id = id;
        this.nome = nome;
        //this.clinica = clinica;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}