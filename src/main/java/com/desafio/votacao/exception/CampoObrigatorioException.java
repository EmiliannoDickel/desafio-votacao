package com.desafio.votacao.exception;

public class CampoObrigatorioException extends NullPointerException{
    public CampoObrigatorioException(String mensagem){
        super(mensagem);
    }
}
