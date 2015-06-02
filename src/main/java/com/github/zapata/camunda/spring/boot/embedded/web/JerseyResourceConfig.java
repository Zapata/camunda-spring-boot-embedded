package com.github.zapata.camunda.spring.boot.embedded.web;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/api")
public class JerseyResourceConfig extends ResourceConfig {

	public JerseyResourceConfig() {
		packages("com.github.zapata.camunda.spring.boot.embedded");
	}
}
