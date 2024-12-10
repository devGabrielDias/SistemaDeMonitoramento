package com.example.sistemaMonitoramento.controllers;

import com.example.sistemaMonitoramento.entities.ObservacoesMedicas;
import com.example.sistemaMonitoramento.facade.ObservacoesMedicasFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/observacaomedica/")
public class ObservacoesMedicasController{

    private final ObservacoesMedicasFacade observacoesMedicasFacade;

    @Autowired
    public ObservacoesMedicasController(ObservacoesMedicasFacade observacoesMedicasFacade) {
        this.observacoesMedicasFacade = observacoesMedicasFacade;
    }

    @GetMapping("observacoesmedicas/")
    public ResponseEntity<List<ObservacoesMedicas>> buscarTodos() {
        List<ObservacoesMedicas> observacoesMedicas = observacoesMedicasFacade.buscarTodos();

        return ResponseEntity.ok(observacoesMedicas);
    }

    @GetMapping("observacaomedica/{id}")
    public ResponseEntity<ObservacoesMedicas> buscarPorId(@PathVariable int id) {
        ObservacoesMedicas observacoesMedicas = observacoesMedicasFacade.buscarPorId(id);
        if (observacoesMedicas == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(observacoesMedicas);
    }

    @PutMapping("observacaomedica/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable int id, @RequestBody ObservacoesMedicas observacoesMedicas) {
        observacoesMedicasFacade.atualizarObservacoesMedicas(id, observacoesMedicas);

        return ResponseEntity.ok(null);
    }

    @PostMapping("observacaomedica/")
    public ResponseEntity<Void> adicionar(@RequestBody ObservacoesMedicas observacoesMedicas) {
        observacoesMedicasFacade.adicionar(observacoesMedicas);

        return ResponseEntity.ok(null);
    }

    @DeleteMapping("observacaomedica/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id) {
        observacoesMedicasFacade.remover(id);

        return ResponseEntity.ok(null);
    }
}

