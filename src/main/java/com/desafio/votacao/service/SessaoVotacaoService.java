package com.desafio.votacao.service;

import com.desafio.votacao.dto.CriarSessaoDTO;
import com.desafio.votacao.dto.SessaoResultadoDTO;
import com.desafio.votacao.exception.PautaNaoEncontradaException;
import com.desafio.votacao.exception.SessaoFechadaException;
import com.desafio.votacao.exception.SessaoJaAbertaException;
import com.desafio.votacao.model.Pauta;
import com.desafio.votacao.model.SessaoVotacao;
import com.desafio.votacao.repository.PautaRepository;
import com.desafio.votacao.repository.SessaoVotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SessaoVotacaoService {
    private final PautaRepository pautaRepository;

    @Autowired
    public SessaoVotacaoService(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    public SessaoResultadoDTO abrirSessao(Long id, Integer duracaoPauta) {
        Pauta pauta = pautaRepository.findById(id).orElseThrow(()-> new PautaNaoEncontradaException("Pauta não encontrada"));
        SessaoVotacao sessao = pauta.getSessao();
        if (sessao != null) {
            if (sessao.estaAberta()) {
                throw new SessaoJaAbertaException("Sessão já está aberta para está pauta!");
            } else {
                throw new SessaoFechadaException("Sessão já foi fechada para esta pauta!");
            }
        }
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime duracao = agora.plusMinutes(duracaoPauta != null ? duracaoPauta : 1);
        SessaoVotacao novaSessao = SessaoVotacao.builder()
                .pauta(pauta)
                .dataAbertura(agora)
                .dataFechamento(duracao)
                .build();
        pauta.setSessao(novaSessao);
        pautaRepository.save(pauta);
        return SessaoResultadoDTO.deSessao(novaSessao);
    }

}
