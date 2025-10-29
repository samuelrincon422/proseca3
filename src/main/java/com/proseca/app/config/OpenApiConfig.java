package com.proseca.app.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig
{
    @Bean
    public OpenAPI prosecaOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("ProSeCa API")
                        .description("API para gestión ganadera - ProSeCa")
                        .version("1.0.0"));
    }

}
