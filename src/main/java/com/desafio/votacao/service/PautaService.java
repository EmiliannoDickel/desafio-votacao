package com.desafio.votacao.service;
import com.desafio.votacao.exception.CampoObrigatorioException;
import com.desafio.votacao.model.Pauta;
import com.desafio.votacao.repository.PautaRepository;
import org.springframework.stereotype.Service;


@Service
public class PautaService {
    private final PautaRepository pautaRepository;

    public PautaService(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    public Pauta salvar (Pauta pauta) {
        if (pauta.getTitulo() == null || pauta.getTitulo().isEmpty()) {
            throw new CampoObrigatorioException("Título não informado ou em branco!");
        }
        if (pauta.getDescricao() == null || pauta.getDescricao().isEmpty()) {
            throw new CampoObrigatorioException("Descricão não informada ou em branco!");
        }
        return pautaRepository.save(pauta);
    }
}

