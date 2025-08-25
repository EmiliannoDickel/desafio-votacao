package com.desafio.votacao.service;
import com.desafio.votacao.dto.CriarPautaDTO;
import com.desafio.votacao.dto.PautaResultadoDTO;
import com.desafio.votacao.exception.CampoObrigatorioException;
import com.desafio.votacao.exception.PautaNaoEncontradaException;
import com.desafio.votacao.model.Pauta;
import com.desafio.votacao.repository.PautaRepository;
import org.springframework.stereotype.Service;


@Service
public class PautaService {
    private final PautaRepository pautaRepository;

    public PautaService(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    public PautaResultadoDTO salvar (CriarPautaDTO criarPautaDTO) {
        Pauta pauta = pautaRepository.save(criarPautaDTO.paraPauta());
        return PautaResultadoDTO.dePauta(pauta);
    }

    public PautaResultadoDTO getPauta (Long pautaId) {
        Pauta pauta = pautaRepository.findById(pautaId).orElseThrow(() -> new PautaNaoEncontradaException("Pauta não encontrada"));
        return PautaResultadoDTO.dePauta(pauta);
    }
}

