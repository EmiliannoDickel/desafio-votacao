package com.desafio.votacao.service;

import com.desafio.votacao.model.Pauta;
import com.desafio.votacao.repository.PautaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PautaService {
    private final PautaRepository pautaRepository;

    public PautaService(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    public Pauta salvar (Pauta pauta) {
        return pautaRepository.save(pauta);
    }

    public List<Pauta> listar() {
        return pautaRepository.findAll();
    }

    public Pauta buscarPorId(Long id) {
        return pautaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pauta não encontrada"));
    }

}

