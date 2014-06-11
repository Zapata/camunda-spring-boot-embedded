package com.github.zapata.camunda.spring.boot.embedded;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = Application.class)
public class Application {
	public static void main(String... args) {
		SpringApplication.run(Application.class, args);
	}
}