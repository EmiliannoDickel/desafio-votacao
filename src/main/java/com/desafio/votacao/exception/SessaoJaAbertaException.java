package com.desafio.votacao.exception;

public class SessaoJaAbertaException extends IllegalStateException {
    public SessaoJaAbertaException(String mensagem) {
        super(mensagem);
    }
}
