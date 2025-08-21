package com.desafio.votacao.exception;

public class VotoRegistradoException extends IllegalStateException{
    public VotoRegistradoException(String mensagem){
        super(mensagem);
    }
}
