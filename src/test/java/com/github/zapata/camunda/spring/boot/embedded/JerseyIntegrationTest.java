package com.github.zapata.camunda.spring.boot.embedded;

import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class JerseyIntegrationTest extends AbstractIntegrationTest {

	@Test
	public void shouldGetHealthStatus() {
		noAuth().get("/api/sample").then().assertThat().statusCode(200)
				.body("status", equalTo("UP")).and()
				.body("description", equalTo("Jersey: Up and Running!"));
	}
}