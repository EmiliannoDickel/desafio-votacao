package com.desafio.votacao.dto;

import com.desafio.votacao.enums.ResultadoEnum;
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
    private ResultadoEnum resultadoFinal;

    public ResultadoVotacaoDTO(Long pautaId, String tituloPauta, long totalSim, long totalNao) {
        this.pautaId = pautaId;
        this.tituloPauta = tituloPauta;
        this.totalSim = totalSim;
        this.totalNao = totalNao;
        this.totalVotos = totalSim + totalNao;
        this.resultadoFinal = calcularResultadoFinal(totalSim, totalNao);
    }

    public ResultadoEnum calcularResultadoFinal(long totalSim, long totalNao) {
        if (totalSim > totalNao) {
            return ResultadoEnum.APROVADO;
        } else if (totalSim < totalNao) {
            return ResultadoEnum.REJEITADO;
        } else {
            return ResultadoEnum.EMPATE;
        }
    }
}
