package com.desafio.votacao.model;

import com.desafio.votacao.enums.EscolhaVoto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Voto")
public class Voto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpfAssociado;
    @Enumerated(EnumType.STRING)
    private EscolhaVoto voto;
    @ManyToOne
    @JoinColumn(name = "pauta_id")
    private Pauta pauta;

}
