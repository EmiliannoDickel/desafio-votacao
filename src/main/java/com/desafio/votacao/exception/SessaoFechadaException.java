package com.desafio.votacao.exception;

public class SessaoFechadaException extends IllegalArgumentException {
    public SessaoFechadaException(String mensagem) {
        super(mensagem);
    }
}
