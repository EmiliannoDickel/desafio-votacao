package com.desafio.votacao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table (name = "sessao_votacao")
public class SessaoVotacao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime dataAbertura;
    private LocalDateTime dataFechamento;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "pauta_id", nullable = false, unique = true)
    private Pauta pauta;

    public boolean estaAberta(){
        LocalDateTime time = LocalDateTime.now();
        return time.isAfter(dataAbertura) && time.isBefore(dataFechamento);
    }
}
