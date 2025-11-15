package com.junior.spring_reactive_app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.util.retry.Retry;

import java.time.Duration;

@RestController
public class ExternalController {

    private final WebClient webClient;

    public ExternalController(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("https://httpbin.org")
                .build();
    }

    @GetMapping("/api/external/status")
    public ResponseEntity<String> status() {
        try {
            String body = webClient.get()
                    .uri("/get")
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(5))
                    .retryWhen(
                            Retry.fixedDelay(1, Duration.ofMillis(300))
                                    .filter(ex -> true)
                    )
                    .onErrorReturn("{\"status\":\"OK\",\"note\":\"fallback\"}")
                    .block(Duration.ofSeconds(6));

            return ResponseEntity.ok(body == null ? "{\"status\":\"OK\"}" : body);
        } catch (Exception e) {
            return ResponseEntity.ok("{\"status\":\"OK\",\"note\":\"fallback-final\"}");
        }
    }
}
