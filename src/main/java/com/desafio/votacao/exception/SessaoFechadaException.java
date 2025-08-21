package com.desafio.votacao.exception;

public class SessaoNaoAbertaException extends IllegalArgumentException {
    public SessaoNaoAbertaException(String mensagem) {
        super(mensagem);
    }
}
