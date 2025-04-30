package com.vitalytyrenko.ecoflights.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // усі шляхи
                        .allowedOrigins("*") // дозволити з будь-якого джерела
                        .allowedMethods("*") // дозволити всі методи (GET, POST, PUT...)
                        .allowedHeaders("*"); // дозволити всі заголовки
            }
        };
    }
}
