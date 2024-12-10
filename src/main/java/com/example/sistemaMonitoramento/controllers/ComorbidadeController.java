package com.example.sistemaMonitoramento.controllers;

import com.example.sistemaMonitoramento.entities.Comorbidade;
import com.example.sistemaMonitoramento.facade.ComorbidadeFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comorbidade/")
public class ComorbidadeController {

    private final ComorbidadeFacade comorbidadeFacade;

    @Autowired
    public ComorbidadeController(ComorbidadeFacade comorbidadeFacade) {
        this.comorbidadeFacade = comorbidadeFacade;
    }

    @GetMapping("comorbidades/")
    public ResponseEntity<List<Comorbidade>> buscarTodos() {
        List<Comorbidade> comorbidades = comorbidadeFacade.buscarTodos();

        return ResponseEntity.ok(comorbidades);
    }

    @GetMapping("comorbidade/{id}")
    public ResponseEntity<Comorbidade> buscarPorId(@PathVariable int id) {
        Comorbidade comorbidade = comorbidadeFacade.buscarPorId(id);
        if (comorbidade == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(comorbidade);
    }

    @PutMapping("comorbidade/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable int id, @RequestBody Comorbidade comorbidade) {
        comorbidadeFacade.atualizarComorbidade(id, comorbidade);

        return ResponseEntity.ok(null);
    }

    @PostMapping("comorbidade/")
    public ResponseEntity<Void> adicionar(@RequestBody Comorbidade comorbidade) {
        comorbidadeFacade.adicionar(comorbidade);

        return ResponseEntity.ok(null);
    }

    @DeleteMapping("comorbidade/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id) {
        comorbidadeFacade.remover(id);

        return ResponseEntity.ok(null);
    }
}