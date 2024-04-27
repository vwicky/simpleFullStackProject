package com.exampleSimpleFullStack.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // or specify origins you want to allow
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*"); // or specify headers you want to allow
    }
}

