package com.sistemadecontratos.sistema.Configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringSwaggerConfig {

    @Bean
    public OpenAPI openApi(){
        return new OpenAPI().info(
                new Info().title("Sistema de Contratos")
                        .version("v1")
                        .description("Sistema que contém todo ecosistema de organização de contratos.")
                        .contact(new Contact().email("gabrielreistech@gmail.com").name("Gabriel Reis").url("https://github.com/gabrielreistech"))
        );
    }
}
