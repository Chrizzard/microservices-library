package com.createment.microserviceslibrary.book;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {
    @Bean
    public WebClient webclientconfig() {
        return WebClient.create("localhost:8081");
    }
}
