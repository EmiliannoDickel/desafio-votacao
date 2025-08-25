package com.desafio.votacao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class PautaNaoEncontradaException extends RuntimeException{
    public PautaNaoEncontradaException(String mensagem){
        super(mensagem);
    }
    public ProblemDetail getProblemDetail () {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, this.getMessage());
    }
}
