package me.bozhilov.EndMonitor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI expenseAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("EndMonitor API")
                        .description(
                                "EndMonitor API implemented with Spring Boot RESTful service and documented using springdoc-openapi and OpenAPI 3.0")
                        .version("v1.0.0"));

    }
}
