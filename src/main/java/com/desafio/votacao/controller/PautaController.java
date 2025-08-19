package com.desafio.votacao.controller;

import com.desafio.votacao.model.Pauta;
import com.desafio.votacao.service.PautaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pautas")
public class PautaController {

    private final PautaService pautaService;

    public PautaController(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Pauta> criar (@RequestBody Pauta pauta) {
        Pauta novaPauta = pautaService.salvar(pauta);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaPauta);
    }
}
