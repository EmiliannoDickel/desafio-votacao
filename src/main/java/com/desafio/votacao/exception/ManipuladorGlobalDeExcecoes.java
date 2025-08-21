package com.desafio.votacao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManipuladorGlobalDeExcecoes {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> tratarIllegalStateException(IllegalStateException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> tratarNullPointerException(NullPointerException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> tratarRuntimeException(RuntimeException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler({
            CampoObrigatorioException.class,
            PautaNaoEncontradaException.class,
            SessaoFechadaException.class,
            SessaoJaAbertaException.class,
            VotoJaRegistradoException.class
    })
    public ResponseEntity<String> tratarExcecoesDeRequisicaoInvalida(RuntimeException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }



}
