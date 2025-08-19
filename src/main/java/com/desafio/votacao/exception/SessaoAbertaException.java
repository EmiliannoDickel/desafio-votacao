package com.desafio.votacao.exception;

public class SessaoAbertaException extends IllegalStateException {
    public SessaoAbertaException(String mensagem) {
        super(mensagem);
    }
}
