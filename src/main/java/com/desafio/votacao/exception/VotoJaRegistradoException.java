package com.desafio.votacao.exception;

public class VotoJaRegistradoException extends RuntimeException {
    public VotoJaRegistradoException(String mensagem){
        super(mensagem);
    }
}
