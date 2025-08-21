package com.desafio.votacao.exception;

public class VotoJaRegistradoException extends IllegalStateException{
    public VotoJaRegistradoException(String mensagem){
        super(mensagem);
    }
}
