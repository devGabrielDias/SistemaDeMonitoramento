package com.example.sistemaMonitoramento.controllers;

import com.example.sistemaMonitoramento.entities.Clinica;
import com.example.sistemaMonitoramento.entities.Consulta;
import com.example.sistemaMonitoramento.facade.ConsultaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta/")
public class ConsultaController {
    private final ConsultaFacade consultaFacade;

    @Autowired
    public ConsultaController(ConsultaFacade consultaFacade) {
        this.consultaFacade = consultaFacade;
    }

    @GetMapping("consultas/")
    public ResponseEntity<List<Consulta>> buscarTodos() {
        List<Consulta> consultas = consultaFacade.buscarTodos();

        return ResponseEntity.ok(consultas);
    }

    @GetMapping("consulta/{id}")
    public ResponseEntity<Consulta> buscarPorId(@PathVariable int id) {
        Consulta consulta = consultaFacade.buscarPorId(id);
        if (consulta == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(consulta);
    }

    @PutMapping("consulta/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable int id, @RequestBody Consulta consulta) {
        consultaFacade.atualizarConsulta(id, consulta);

        return ResponseEntity.ok(null);
    }

    @PostMapping("consulta/")
    public ResponseEntity<Void> adicionar(@RequestBody Consulta consulta) {
        consultaFacade.adicionar(consulta);

        return ResponseEntity.ok(null);
    }

    @DeleteMapping("consulta/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id) {
        consultaFacade.remover(id);

        return ResponseEntity.ok(null);
    }
}
