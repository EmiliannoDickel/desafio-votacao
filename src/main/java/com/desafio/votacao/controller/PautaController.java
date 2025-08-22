package com.desafio.votacao.controller;

import com.desafio.votacao.model.Pauta;
import com.desafio.votacao.service.PautaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pautas")
@Tag(name = "Pauta", description = "Responsável pelo gerencimaneto da das pautas.")
public class PautaController {

    private final PautaService pautaService;

    public PautaController(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Criar Pauta", description = "rota responsável pela criação da Pauta, com nome e descrição.")
    @ApiResponse(responseCode = "201", description = "Pauta criada com sucesso")
    public ResponseEntity<Pauta> criar (@RequestBody Pauta pauta) {
        Pauta novaPauta = pautaService.salvar(pauta);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaPauta);
    }
}
