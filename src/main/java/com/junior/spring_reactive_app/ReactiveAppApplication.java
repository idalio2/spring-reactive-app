package com.junior.spring_reactive_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories(basePackages = "com.junior.spring_reactive_app.repository")
public class ReactiveAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReactiveAppApplication.class, args);
    }
}
