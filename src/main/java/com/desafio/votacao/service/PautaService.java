package com.desafio.votacao.service;

import com.desafio.votacao.model.Pauta;
import com.desafio.votacao.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PautaService {
    @Autowired
    private PautaRepository pautaRepository;

    public Pauta salvar (Pauta pauta) {
        return pautaRepository.save(pauta);
    }

}

