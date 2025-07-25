package com.desafio.votacao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "Sessao")
public class SessaoVotacao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFechamento;

    @OneToOne
    @JoinColumn(name = "pauta_id")
    private Pauta pauta;
}
