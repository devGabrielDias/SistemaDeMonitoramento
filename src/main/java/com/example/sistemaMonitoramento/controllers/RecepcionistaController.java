package com.example.sistemaMonitoramento.controllers;

import com.example.sistemaMonitoramento.entities.Paciente;
import com.example.sistemaMonitoramento.entities.Recepcionista;
import com.example.sistemaMonitoramento.facade.PacienteFacade;
import com.example.sistemaMonitoramento.facade.RecepcionistaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recepcionista")
public class RecepcionistaController {

    private final RecepcionistaFacade recepcionistaFacade;

    @Autowired
    public RecepcionistaController(RecepcionistaFacade recepcionistaFacade) {
        this.recepcionistaFacade = recepcionistaFacade;
    }

    @GetMapping("/recepcionistas")
    public ResponseEntity<List<Recepcionista>> buscarTodos() {
        List<Recepcionista> recepcionistas = recepcionistaFacade.buscarTodos();

        return ResponseEntity.ok(recepcionistas);
    }

    @GetMapping("/recepcionista/{id}")
    public ResponseEntity<Recepcionista> buscarPorId(@PathVariable int id) {
        Recepcionista recepcionista = recepcionistaFacade.buscarPorId(id);
        if (recepcionista == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(recepcionista);
    }

    @PutMapping("/recepcionista/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable int id, @RequestBody Recepcionista recepcionista) {
        recepcionistaFacade.atualizarRecepcionista(id, recepcionista);

        return ResponseEntity.ok(null);
    }

    @PostMapping("/recepcionista")
    public ResponseEntity<Void> adicionar(@RequestBody Recepcionista recepcionista) {
        recepcionistaFacade.adicionar(recepcionista);

        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/recepcionista/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id) {
        recepcionistaFacade.remover(id);

        return ResponseEntity.ok(null);
    }
}

