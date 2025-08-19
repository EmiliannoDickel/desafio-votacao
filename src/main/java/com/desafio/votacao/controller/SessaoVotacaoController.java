package com.desafio.votacao.controller;
import com.desafio.votacao.model.SessaoVotacao;
import com.desafio.votacao.service.SessaoVotacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sessoes")
public class SessaoVotacaoController {

    private final SessaoVotacaoService sessaoVotacaoService;

    public SessaoVotacaoController(SessaoVotacaoService sessaoVotacaoService) {
        this.sessaoVotacaoService = sessaoVotacaoService;
    }

    @PostMapping("/abrir/{id}")
    public ResponseEntity<SessaoVotacao> abrirSessao (@PathVariable Long id, @RequestParam (required = false) Integer duracaoPauta) {
        SessaoVotacao sessao = sessaoVotacaoService.abrirSessao(id, duracaoPauta);
        return ResponseEntity.ok(sessao);
    }
}
