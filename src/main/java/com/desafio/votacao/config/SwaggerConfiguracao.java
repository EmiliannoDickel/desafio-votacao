package com.desafio.votacao.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguracao {

    @Bean
    public OpenAPI getOpenAPI() {
        Contact contato = new Contact();
        contato.name("Emilianno Dickel");
        contato.email("emidudickel@gmail.com");
        contato.url("https://github.com/EmiliannoDickel/desafio-votacao");

        Info info = new Info();
        info.title("desafio votação");
        info.version("1.0");
        info.description("Desafio para votação de associados em uma Pauta");
        info.contact(contato);

        return new OpenAPI().info(info);
    }
}

