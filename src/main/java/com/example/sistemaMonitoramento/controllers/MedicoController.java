package com.example.sistemaMonitoramento.controllers;

import com.example.sistemaMonitoramento.entities.Medico;
import com.example.sistemaMonitoramento.facade.MedicoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController{

    private final MedicoFacade medicoFacade;

    @Autowired
    public MedicoController(MedicoFacade medicoFacade) {
        this.medicoFacade = medicoFacade;
    }

    @GetMapping("/buscar-medicos")
    public ResponseEntity<List<Medico>> buscarTodos() {
        List<Medico> medicos = medicoFacade.buscarTodos();

        return ResponseEntity.ok(medicos);
    }

    @GetMapping("/buscar-medico/{id}")
    public ResponseEntity<Medico> buscarPorId(@PathVariable int id) {
        Medico medico = medicoFacade.buscarPorId(id);
        if (medico == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(medico);
    }

    @PutMapping("/up-medico/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable int id, @RequestBody Medico medico) {
        medicoFacade.atualizarMedico(id, medico);

        return ResponseEntity.ok(null);
    }

    @PostMapping("/add-medico")
    public ResponseEntity<Void> adicionar(@RequestBody Medico medico) {
        medicoFacade.adicionar(medico);

        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/del-medico/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id) {
        medicoFacade.remover(id);

        return ResponseEntity.ok(null);
    }
}

