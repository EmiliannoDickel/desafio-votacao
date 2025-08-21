package com.desafio.votacao.exception;

public class PautaNaoEncontradaException extends RuntimeException{
    public PautaNaoEncontradaException(String mensagem){
        super(mensagem);
    }
}
