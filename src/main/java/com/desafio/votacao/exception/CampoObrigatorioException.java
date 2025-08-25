package com.desafio.votacao.exception;

public class CampoObrigatorioException extends RuntimeException{
    public CampoObrigatorioException(String mensagem){
        super(mensagem);
    }
}
