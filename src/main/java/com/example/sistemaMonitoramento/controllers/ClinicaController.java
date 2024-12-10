package com.example.sistemaMonitoramento.controllers;

import com.example.sistemaMonitoramento.entities.Clinica;
import com.example.sistemaMonitoramento.facade.ClinicaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clinica/")
public class ClinicaController {

    private final ClinicaFacade clinicaFacade;

    @Autowired
    public ClinicaController(ClinicaFacade clinicaFacade) {
        this.clinicaFacade = clinicaFacade;
    }

    @GetMapping("clinicas/")
    public ResponseEntity<List<Clinica>> buscarTodos() {
        List<Clinica> clinicas = clinicaFacade.buscarTodos();

        return ResponseEntity.ok(clinicas);
    }

    @GetMapping("clinica/{id}")
    public ResponseEntity<Clinica> buscarPorId(@PathVariable int id) {
        Clinica clinica = clinicaFacade.buscarPorId(id);
        if (clinica == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(clinica);
    }

    @PutMapping("clinica/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable int id, @RequestBody Clinica clinica) {
        clinicaFacade.atualizarClinica(id, clinica);

        return ResponseEntity.ok(null);
    }

    @PostMapping("clinica/")
    public ResponseEntity<Void> adicionar(@RequestBody Clinica clinica) {
        clinicaFacade.adicionar(clinica);

        return ResponseEntity.ok(null);
    }

    @DeleteMapping("clinica/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id) {
        clinicaFacade.remover(id);

        return ResponseEntity.ok(null);
    }
}
