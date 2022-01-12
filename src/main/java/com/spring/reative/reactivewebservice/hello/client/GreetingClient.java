package com.spring.reative.reactivewebservice.hello.client;

import com.spring.reative.reactivewebservice.hello.pojo.Greeting;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class GreetingClient {

    private final WebClient client;

    public GreetingClient(WebClient.Builder builder, @Value("${server.protocol}") String protocol, @Value("${server.hosts}") String hosts, @Value("${server.port}") int serverPort) {
        String baseUrl = String.format("%s://%s:%d", protocol, hosts, serverPort);
        this.client = builder.baseUrl(baseUrl).build();
    }

    public Mono<String> getMessage() {
        return this.client.get().uri("/hello").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Greeting.class)
                .map(Greeting::getMessage);
    }
}
