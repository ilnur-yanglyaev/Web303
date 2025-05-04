package com.example.config;

import com.example.service.CommonExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Configuration
public class CommonExceptionHandlerConfig {

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE) // Установка высокого приоритета
    public CommonExceptionHandler commonExceptionHandler() {
        return new CommonExceptionHandler();
    }
}