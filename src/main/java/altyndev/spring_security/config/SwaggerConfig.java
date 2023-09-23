package altyndev.spring_security.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    private static final String API_KEY = "Bearer Token";

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .components(new Components().addSecuritySchemes(API_KEY, apiKeySecurityScheme())) // define the apiKey SecuritySchema
                .info(new Info().title("JWT Security Spring Boot 3"))
                .security(Collections.singletonList(new SecurityRequirement().addList(API_KEY)));// then apply it. If you don't apply it will not be added to the header in cURL
    }

    @Bean
    public SecurityScheme apiKeySecurityScheme() {
        return new SecurityScheme()
                .name("Bearer auth")
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");
    }
}