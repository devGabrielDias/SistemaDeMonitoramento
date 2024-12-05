package com.example.sistemaMonitoramento.controllers;

import com.example.sistemaMonitoramento.entities.DadosDiarios;
import com.example.sistemaMonitoramento.facade.DadosDiariosFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dadosdiarios")
public class DadosDiariosController {

    private final DadosDiariosFacade dadosDiariosFacade;

    @Autowired
    public DadosDiariosController(DadosDiariosFacade dadosDiariosFacade) {
        this.dadosDiariosFacade = dadosDiariosFacade;
    }

    @GetMapping("/dadosdiarios")
    public ResponseEntity<List<DadosDiarios>> buscarTodos() {
        List<DadosDiarios> dadosDiarios = dadosDiariosFacade.buscarTodos();

        return ResponseEntity.ok(dadosDiarios);
    }

    @GetMapping("/dadosdiarios/{id}")
    public ResponseEntity<DadosDiarios> buscarPorId(@PathVariable int id) {
        DadosDiarios dadosDiarios = dadosDiariosFacade.buscarPorId(id);
        if (dadosDiarios == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(dadosDiarios);
    }

    @PutMapping("/dadosdiarios/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable int id, @RequestBody DadosDiarios dadosDiarios) {
        dadosDiariosFacade.atualizarDadosDiarios(id, dadosDiarios);

        return ResponseEntity.ok(null);
    }

    @PostMapping("/dadosdiarios")
    public ResponseEntity<Void> adicionar(@RequestBody DadosDiarios dadosDiarios) {
        dadosDiariosFacade.adicionar(dadosDiarios);

        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/dadosdiarios/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id) {
        dadosDiariosFacade.remover(id);

        return ResponseEntity.ok(null);
    }
}

