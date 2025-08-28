package com.desafio.votacao.dto;

import com.desafio.votacao.model.SessaoVotacao;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CriarSessaoDTO {

    @NotNull(message = "Data de abertura não pode ser nula")
    @Future(message = "Data de abertura deve ser uma data futura")
    private LocalDateTime dataAbertura;
    @NotNull(message = "Data de fechamento não pode ser nula")
    @Future(message = "Data de fechamento deve ser uma data futura")
    private LocalDateTime dataFechamento;

    public SessaoVotacao paraSessaoVotacao () {
        SessaoVotacao sessaoVotacao = new SessaoVotacao();
        sessaoVotacao.setDataAbertura(dataAbertura);
        sessaoVotacao.setDataFechamento(dataFechamento);
        return sessaoVotacao;
    }
}
