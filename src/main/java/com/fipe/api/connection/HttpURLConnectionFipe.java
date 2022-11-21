package com.fipe.api.connection;

import org.springframework.web.reactive.function.client.WebClient;

public class HttpURLConnectionFipe {

    WebClient client = WebClient.create();

    WebClient.ResponseSpec responseSpec = client.get()
            .uri("https://parallelum.com.br/fipe/api/v1\n" )
            .retrieve();
}
