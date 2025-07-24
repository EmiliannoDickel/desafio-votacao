package com.desafio.votacao.controller;

import com.desafio.votacao.model.Pauta;
import com.desafio.votacao.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pautas")
public class PautaController {
    @Autowired
    private final PautaService service;

    public PautaController(PautaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pauta criar (@RequestBody Pauta pauta) {
        return service.salvar(pauta);
    }

    @GetMapping
    public List<Pauta> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Pauta buscar (@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}
