package com.example.sistemaMonitoramento.entities;

import jakarta.persistence.*;


    @Entity
    @Table(name = "pacientes")
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

        //@Column(name = "historico_medico")
        //private String historicoMedico;

        @Column(name = "contato")
        private String contato;

        @Column(name = "email")
        private String email;

        @Column(name = "senha")
        private String senha;


        //@JoinColumn(name = "id_comorbidade")
        //private Comorbidade comorbidade;


        //@JoinColumn(name = "id_clinica")
        //private Clinica clinica;

        public Paciente(int id, String nome, int idade, String contato, String email, String senha) {
            this.id = id;
            this.nome = nome;
            this.idade = idade;
            //this.historicoMedico = historicoMedico;
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

       // public Comorbidade getComorbidade() {
       //     return comorbidade;
        //}

        //public void setComorbidade(Comorbidade comorbidade) {
         //   this.comorbidade = comorbidade;
        //}

        //public Clinica getClinica() {
      //      return clinica;
        //}

        //public void setClinica(Clinica clinica) {
        //    this.clinica = clinica;
       // }
    }

