package com.example.sistemaMonitoramento.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
    @Table(name = "paciente")
    public class Paciente {

        public Paciente() {

        }

        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name = "nome", nullable = false)
        private String nome;

        @Column(name = "idade", nullable = false)
        private int idade;

        @Column(name = "contato")
        private String contato;

        @Column(name = "email")
        private String email;

        @Column(name = "senha")
        private String senha;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "clinica_id", referencedColumnName = "id")
        private Clinica clinica;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "comorbidade_id", referencedColumnName = "id")
        private Comorbidade comorbidade;

        @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
        private List<DadosDiarios> dadosDiarios = new ArrayList<>();

        @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
        private List<ObservacoesMedicas> observacoesMedicas = new ArrayList<>();

        public Paciente(int id, String nome, int idade, String contato, String email, String senha) {
            this.id = id;
            this.nome = nome;
            this.idade = idade;
            this.contato = contato;
            this.email = email;
            this.senha = senha;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getIdade() {
            return idade;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }

        //public String getHistoricoMedico() {
        //    return historicoMedico;
        //}

       // public void setHistoricoMedico(String historicoMedico) {
       //     this.historicoMedico = historicoMedico;
      //  }

        public String getContato() {
            return contato;
        }

        public void setContato(String contato) {
            this.contato = contato;
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

        public Clinica getClinica() {
            return clinica;
        }

        public void setClinica(Clinica clinica) {
            this.clinica = clinica;
        }

        public Comorbidade getComorbidade() {
            return comorbidade;
        }

        public void setComorbidade(Comorbidade comorbidade) {
            this.comorbidade = comorbidade;
        }
    }

