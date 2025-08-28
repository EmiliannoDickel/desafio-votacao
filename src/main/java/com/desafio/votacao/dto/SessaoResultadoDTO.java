package com.desafio.votacao.dto;

import com.desafio.votacao.model.SessaoVotacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SessaoResultadoDTO {
    private long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataAbertura;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataFechamento;

    public static SessaoResultadoDTO deSessao (SessaoVotacao sessao) {
        return new SessaoResultadoDTO(sessao.getId(), sessao.getDataAbertura(), sessao.getDataFechamento());
    }
}
