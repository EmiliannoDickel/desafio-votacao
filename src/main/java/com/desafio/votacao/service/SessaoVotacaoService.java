package com.desafio.votacao.service;

import com.desafio.votacao.model.Pauta;
import com.desafio.votacao.model.SessaoVotacao;
import com.desafio.votacao.repository.PautaRepository;
import com.desafio.votacao.repository.SessaoVotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SessaoVotacaoService {
    private SessaoVotacaoRepository sessaoVotacaoRepository;
    private PautaRepository pautaRepository;

    @Autowired
    public SessaoVotacaoService(SessaoVotacaoRepository sessaoVotacaoRepository, PautaRepository pautaRepository) {
        this.sessaoVotacaoRepository = sessaoVotacaoRepository;
        this.pautaRepository = pautaRepository;
    }

    public SessaoVotacao abrirSessao(Long id, Integer duracaoPauta) {
        Pauta pauta = pautaRepository.findById(id).orElseThrow(()-> new RuntimeException("Pauta não encontrada"));

        if (pauta.getSessao() != null) {
            throw new IllegalStateException("Sessão já está aberta para está pauta!");
        }
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime duracao = agora.plusMinutes(duracaoPauta != null ? duracaoPauta : 1);
        SessaoVotacao sessao = SessaoVotacao.builder().pauta(pauta).dataAbertura(agora).dataFechamento(duracao).build();
        pauta.setSessao(sessao);
        pautaRepository.save(pauta);
        return sessao;
    }
}
