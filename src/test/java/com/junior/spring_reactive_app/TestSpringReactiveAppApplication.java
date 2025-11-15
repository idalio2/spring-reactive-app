package com.junior.spring_reactive_app;

import org.springframework.boot.SpringApplication;
import org.testcontainers.utility.TestcontainersConfiguration;

public class TestSpringReactiveAppApplication {

	public static void main(String[] args) {
		SpringApplication.from(ReactiveAppApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
