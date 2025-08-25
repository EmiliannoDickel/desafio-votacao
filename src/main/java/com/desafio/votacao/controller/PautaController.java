package com.desafio.votacao.controller;

import com.desafio.votacao.annotation.ApiErrorResponses;
import com.desafio.votacao.dto.CriarPautaDTO;
import com.desafio.votacao.dto.PautaResultadoDTO;
import com.desafio.votacao.model.Pauta;
import com.desafio.votacao.service.PautaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/v1/pautas")
@Tag(name = "Pauta", description = "Responsável pelo gerencimaneto da das pautas.")
public class PautaController {

    private final PautaService pautaService;

    public PautaController(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @PostMapping(
            path = "",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Adicionar uma nova Pauta",
            responses = {
                    @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = PautaResultadoDTO.class)))
            }
    )
    @ApiErrorResponses
    public ResponseEntity<PautaResultadoDTO> criar(@Valid @RequestBody CriarPautaDTO criarPautaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pautaService.salvar(criarPautaDTO));
    }

    @GetMapping(
            path = "/{pautaID}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Buscar Pauta específica pelo seu ID",
            responses = {
                    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = PautaResultadoDTO.class)))
            }
    )
    @ApiErrorResponses
    public ResponseEntity<PautaResultadoDTO> getPauta (@PathVariable Long pautaID){
        return ResponseEntity.ok(pautaService.getPauta(pautaID));
    }
}
