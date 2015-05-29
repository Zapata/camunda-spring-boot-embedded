package com.github.zapata.camunda.spring.boot.embedded;

import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class ActuatorIntegrationTest extends AbstractIntegrationTest {
	@Test
	public void shouldGetHealthStatus() {
		noAuth().port(managementPort).get("/health").then().assertThat()
				.statusCode(200).body("status", equalTo("UP"));
	}

	@Test
	public void shouldGetThreadDump() {
		noAuth().port(managementPort).get("/dump").then().assertThat()
				.statusCode(200);
	}

	@Test
	public void shouldNotBeAbleToShutdown() {
		noAuth().port(managementPort).get("/shutdown").then().assertThat()
				.statusCode(405);
	}
}