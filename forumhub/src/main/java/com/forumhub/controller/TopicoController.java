package com.forumhub.controller;

import com.forumhub.model.Topico;
import com.forumhub.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @GetMapping
    public List<Topico> listarTodos() {
        return topicoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> buscarPorId(@PathVariable Long id) {
        Optional<Topico> topico = topicoService.buscarPorId(id);
        return topico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Topico> salvar(@RequestBody Topico topico) {
        Topico topicoSalvo = topicoService.salvar(topico);
        return ResponseEntity.status(HttpStatus.CREATED).body(topicoSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        topicoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
