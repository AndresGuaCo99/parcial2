package com.example.equipo_futbol.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("API Parcial 2")
                        .version("1.0")
                        .description("Documentación de la API para ejercicio de parcial 2")
                        .contact(new Contact()
                                .name("Andres Guayacan")
                                .email("aguayacan@ucundinamarca.edu.co")));
    }
}