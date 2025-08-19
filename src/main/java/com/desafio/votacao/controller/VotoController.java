package com.desafio.votacao.controller;
import com.desafio.votacao.dto.ResultadoVotacao;
import com.desafio.votacao.model.Voto;
import com.desafio.votacao.repository.PautaRepository;
import com.desafio.votacao.service.VotoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/votos")
public class VotoController {

    private final VotoService votoService;
    private final PautaRepository pautaRepository;

    public VotoController(VotoService votoService, PautaRepository pautaRepository) {
        this.votoService = votoService;
        this.pautaRepository = pautaRepository;
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> votar(@PathVariable Long id, @RequestBody Voto voto) {
        voto.setPauta(pautaRepository.getReferenceById(id));
        votoService.registrarVoto(voto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultadoVotacao> getResultado(@PathVariable Long id) {
        ResultadoVotacao resultado = votoService.contabilizarVotos(id);
        return ResponseEntity.ok(resultado);
    }
}
