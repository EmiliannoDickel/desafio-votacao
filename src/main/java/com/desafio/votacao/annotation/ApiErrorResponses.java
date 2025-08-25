package com.desafio.votacao.annotation;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ProblemDetail;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ApiResponses(
        value = {
                @ApiResponse(
                        responseCode = "400",
                        description = "Erro de validação",
                        content = @Content(schema = @Schema(implementation = ProblemDetail.class))
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Recurso não encontrado",
                        content = @Content(schema = @Schema(implementation = ProblemDetail.class))
                ),
                @ApiResponse(
                        responseCode = "500",
                        description = "Erro interno do servidor",
                        content = @Content(schema = @Schema(implementation = ProblemDetail.class))
                )
        }
)
public @interface ApiErrorResponses {
}