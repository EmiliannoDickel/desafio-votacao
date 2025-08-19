package com.desafio.votacao.service;
import com.desafio.votacao.exception.TituloDescricaoNullException;
import com.desafio.votacao.model.Pauta;
import com.desafio.votacao.repository.PautaRepository;
import org.springframework.stereotype.Service;


@Service
public class PautaService {
    private PautaRepository pautaRepository;

    public Pauta salvar (Pauta pauta) {
        if (pauta.getTitulo() == null || pauta.getDescricao() == null) {
            throw new TituloDescricaoNullException("Título ou Descrição não informado!");
        }
        return pautaRepository.save(pauta);
    }
}

