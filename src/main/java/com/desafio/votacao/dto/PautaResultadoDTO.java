package com.desafio.votacao.dto;

import com.desafio.votacao.model.Pauta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PautaResultadoDTO {
    private Long id;
    private String titulo;
    private String descricao;

    public static PautaResultadoDTO dePauta(Pauta pauta) {
        return new PautaResultadoDTO(pauta.getId(), pauta.getTitulo(), pauta.getDescricao());
    }
}
