package com.desafio.votacao.dto;

import com.desafio.votacao.model.Pauta;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties()
public class CriarPautaDTO {
    @NotBlank(message = "Campo título não pode ser Vazio")
    private String titulo;
    @NotBlank(message = "Campo descrição não pode ser Vazio")
    private String descricao;

    public Pauta paraPauta() {
        Pauta pauta = new Pauta();
        pauta.setTitulo(this.titulo);
        pauta.setDescricao(this.descricao);
        return pauta;
    }
}
