package br.com.diogooliveira.vacancy_management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI openAPI() {

        return new OpenAPI()
            .info(new Info().title("Job Management").description("API responsible for job management.")
                .version("1"))
            .schemaRequirement("jwt_auth", creaSecurityScheme());
    }

    private SecurityScheme creaSecurityScheme() {
        return new SecurityScheme().name("jwt_auth").type(SecurityScheme.Type.HTTP).scheme("bearer")
            .bearerFormat("JWT");
    }
}
