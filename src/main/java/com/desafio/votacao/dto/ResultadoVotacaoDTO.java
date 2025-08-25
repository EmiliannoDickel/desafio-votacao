package com.desafio.votacao.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultadoVotacaoDTO {
    private Long pautaId;
    private String tituloPauta;
    private Long totalVotos;
    private Long totalSim;
    private Long totalNao;
    private String resultadoFinal;

    public ResultadoVotacaoDTO(Long pautaId, String tituloPauta, long totalSim, long totalNao) {
        this.pautaId = pautaId;
        this.tituloPauta = tituloPauta;
        this.totalSim = totalSim;
        this.totalNao = totalNao;
        this.totalVotos = totalSim + totalNao;
        this.resultadoFinal = calcularResultadoFinal(totalSim, totalNao);
    }

    public String calcularResultadoFinal(long totalSim, long totalNao) {
        if (totalSim > totalNao) {
            return "Aprovada!";
        } else if (totalSim < totalNao) {
            return "Rejeitada!";
        } else {
            return "Empate!";
        }
    }
}
