package com.fipe.api.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

//@Component
@SpringBootApplication
public class FipeWebClientConfiguration {

    private WebClient webClient;

    @Bean
    public WebClient WebClient(WebClient.Builder builder) {
        return builder
                .baseUrl("https://parallelum.com.br/fipe/api/v1/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(FipeWebClientConfiguration .class, args);
    }

}
