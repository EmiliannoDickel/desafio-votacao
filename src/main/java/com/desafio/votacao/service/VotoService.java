package com.desafio.votacao.service;

import com.desafio.votacao.dto.ResultadoVotacaoDTO;
import com.desafio.votacao.enums.EscolhaVotoEnum;
import com.desafio.votacao.exception.PautaNaoEncontradaException;
import com.desafio.votacao.exception.SessaoFechadaException;
import com.desafio.votacao.exception.VotoJaRegistradoException;
import com.desafio.votacao.model.Pauta;
import com.desafio.votacao.model.SessaoVotacao;
import com.desafio.votacao.model.Voto;
import com.desafio.votacao.repository.PautaRepository;
import com.desafio.votacao.repository.VotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotoService {

    private final VotoRepository votoRepository;
    private final PautaRepository pautaRepository;

    public VotoService(VotoRepository votoRepository, PautaRepository pautaRepository) {
        this.votoRepository = votoRepository;
        this.pautaRepository = pautaRepository;
    }

    public void registrarVoto (Long id, Voto voto){
        Pauta pauta = pautaRepository.findById(id).orElseThrow(() -> new PautaNaoEncontradaException("Pauta não encontrada"));
        SessaoVotacao sessao = pauta.getSessao();

        if (sessao == null) {
            throw new IllegalStateException("Sessão de votação não encontrada para a pauta");
        }
        if (!sessao.estaAberta()){
            throw new SessaoFechadaException("A sessão de votação para a pauta " + id + " está fechada.");
        }
        voto.setPauta(pauta);
        if (votoRepository.existsByCpfAssociadoAndPautaId(voto.getCpfAssociado(), voto.getPauta().getId())){
            throw new VotoJaRegistradoException("Associado já votou nessa pauta");
        }
        votoRepository.save(voto);
    }

    public ResultadoVotacaoDTO contabilizarVotos (Long pautaId){
        Pauta pauta = pautaRepository.findById(pautaId).orElseThrow(() -> new PautaNaoEncontradaException("Pauta não encotrada"));
        List<Voto> votos = votoRepository.findByPautaId(pautaId);

        long totalSim = votos.stream().filter(v -> v.getVoto() == EscolhaVotoEnum.SIM).count();
        long totalNao = votos.stream().filter(v -> v.getVoto() == EscolhaVotoEnum.NAO).count();

        return new ResultadoVotacaoDTO(pautaId, pauta.getTitulo(), totalSim, totalNao);
    }

}
