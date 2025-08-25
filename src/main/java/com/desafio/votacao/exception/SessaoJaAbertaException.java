package com.desafio.votacao.exception;

public class SessaoJaAbertaException extends RuntimeException {
    public SessaoJaAbertaException(String mensagem) {
        super(mensagem);
    }
}
