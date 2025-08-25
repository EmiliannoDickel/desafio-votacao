package com.desafio.votacao.exception;

public class SessaoFechadaException extends RuntimeException {
    public SessaoFechadaException(String mensagem) {
        super(mensagem);
    }
}
