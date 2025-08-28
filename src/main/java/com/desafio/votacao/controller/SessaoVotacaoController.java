package com.desafio.votacao.controller;
import com.desafio.votacao.annotation.ApiErrorResponses;
import com.desafio.votacao.dto.PautaResultadoDTO;
import com.desafio.votacao.dto.SessaoResultadoDTO;
import com.desafio.votacao.model.SessaoVotacao;
import com.desafio.votacao.service.SessaoVotacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sessoes")
public class SessaoVotacaoController {

    private final SessaoVotacaoService sessaoVotacaoService;

    public SessaoVotacaoController(SessaoVotacaoService sessaoVotacaoService) {
        this.sessaoVotacaoService = sessaoVotacaoService;
    }

    @PostMapping(
            path = "/abrir/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Abrir uma nova Sessão",
            responses = {
                    @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = SessaoResultadoDTO.class)))
            }
    )
    @ApiErrorResponses
    public ResponseEntity<SessaoResultadoDTO> abrirSessao (@PathVariable Long id, @RequestParam (required = false) Integer duracaoPauta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sessaoVotacaoService.abrirSessao(id, duracaoPauta));
    }
}
