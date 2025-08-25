package com.desafio.votacao.controller;
import com.desafio.votacao.dto.ResultadoVotacaoDTO;
import com.desafio.votacao.model.Voto;
import com.desafio.votacao.service.VotoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/votos")
public class VotoController {

    private final VotoService votoService;

    public VotoController(VotoService votoService) {
        this.votoService = votoService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> votar(@PathVariable Long id, @RequestBody Voto voto) {
        votoService.registrarVoto(id,voto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultadoVotacaoDTO> getResultado(@PathVariable Long id) {
        ResultadoVotacaoDTO resultado = votoService.contabilizarVotos(id);
        return ResponseEntity.ok(resultado);
    }
}
