package com.desafio.votacao.service;

import com.desafio.votacao.dto.ResultadoVotacao;
import com.desafio.votacao.enums.EscolhaVoto;
import com.desafio.votacao.exception.VotoRegistradoException;
import com.desafio.votacao.model.Pauta;
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

    public void registrarVoto (Voto voto){
        if (votoRepository.existsByCpfAssociadoAndPautaId(voto.getCpfAssociado(), voto.getPauta().getId())){
            throw new VotoRegistradoException("Associado já votou nessa pauta");
        }
        votoRepository.save(voto);
    }

    public ResultadoVotacao contabilizarVotos (Long pautaId){
        Pauta pauta = pautaRepository.findById(pautaId).orElseThrow(() -> new IllegalStateException("Pauta não encotrada"));
        List<Voto> votos = votoRepository.findByPautaId(pautaId);

        long totalSim = votos.stream().filter(v -> v.getVoto() == EscolhaVoto.SIM).count();
        long totalNao = votos.stream().filter(v -> v.getVoto() == EscolhaVoto.NAO).count();

        return new ResultadoVotacao (pautaId, pauta.getTitulo(), totalSim, totalNao);
    }



}
