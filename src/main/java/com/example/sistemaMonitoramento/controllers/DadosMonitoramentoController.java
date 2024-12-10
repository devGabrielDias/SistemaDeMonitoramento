package com.example.sistemaMonitoramento.controllers;

import com.example.sistemaMonitoramento.entities.DadosMonitoramento;
import com.example.sistemaMonitoramento.facade.DadosMonitoramentoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dadosmonitoramento/")
public class DadosMonitoramentoController {

    private final DadosMonitoramentoFacade dadosMonitoramentoFacade;

    @Autowired
    public DadosMonitoramentoController(DadosMonitoramentoFacade dadosMonitoramentoFacade) {
        this.dadosMonitoramentoFacade = dadosMonitoramentoFacade;
    }

    @GetMapping("dadosmonitoramentos/")
    public ResponseEntity<List<DadosMonitoramento>> buscarTodos() {
        List<DadosMonitoramento> dadosMonitoramento = dadosMonitoramentoFacade.buscarTodos();

        return ResponseEntity.ok(dadosMonitoramento);
    }

    @GetMapping("dadosmonitoramento/{id}")
    public ResponseEntity<DadosMonitoramento> buscarPorId(@PathVariable int id) {
        DadosMonitoramento dadosMonitoramento = dadosMonitoramentoFacade.buscarPorId(id);
        if (dadosMonitoramento == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(dadosMonitoramento);
    }

    @PutMapping("dadosmonitoramento/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable int id, @RequestBody DadosMonitoramento dadosMonitoramento) {
        dadosMonitoramentoFacade.atualizarDadosMonitoramento(id, dadosMonitoramento);

        return ResponseEntity.ok(null);
    }

    @PostMapping("dadosmonitoramento/")
    public ResponseEntity<Void> adicionar(@RequestBody DadosMonitoramento dadosMonitoramento) {
        dadosMonitoramentoFacade.adicionar(dadosMonitoramento);

        return ResponseEntity.ok(null);
    }

    @DeleteMapping("dadosmonitoramento/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id) {
        dadosMonitoramentoFacade.remover(id);

        return ResponseEntity.ok(null);
    }
}

