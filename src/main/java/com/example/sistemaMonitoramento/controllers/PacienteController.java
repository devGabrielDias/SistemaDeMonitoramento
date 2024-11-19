package com.example.sistemaMonitoramento.controllers;

import com.example.sistemaMonitoramento.entities.Clinica;
import com.example.sistemaMonitoramento.entities.Paciente;
import com.example.sistemaMonitoramento.facade.ClinicaFacade;
import com.example.sistemaMonitoramento.facade.PacienteFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteFacade pacienteFacade;

        @Autowired
        public PacienteController(PacienteFacade pacienteFacade) {
            this.pacienteFacade = pacienteFacade;
        }

        @GetMapping("/buscar-pacientes")
        public ResponseEntity<List<Paciente>> buscarTodos() {
            List<Paciente> pacientes = pacienteFacade.buscarTodos();

            return ResponseEntity.ok(pacientes);
        }

        @GetMapping("/buscar-paciente/{id}")
        public ResponseEntity<Paciente> buscarPorId(@PathVariable int id) {
            Paciente paciente = pacienteFacade.buscarPorId(id);
            if (paciente == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            return ResponseEntity.ok(paciente);
        }

        @PutMapping("/up-paciente/{id}")
        public ResponseEntity<Void> atualizar(@PathVariable int id, @RequestBody Paciente paciente) {
            pacienteFacade.atualizarPaciente(id, paciente);

            return ResponseEntity.ok(null);
        }

        @PostMapping("/add-paciente")
        public ResponseEntity<Void> adicionar(@RequestBody Paciente paciente) {
            pacienteFacade.adicionar(paciente);

            return ResponseEntity.ok(null);
        }

        @DeleteMapping("/del-paciente/{id}")
        public ResponseEntity<Void> remover(@PathVariable int id) {
            pacienteFacade.remover(id);

            return ResponseEntity.ok(null);
        }
    }

