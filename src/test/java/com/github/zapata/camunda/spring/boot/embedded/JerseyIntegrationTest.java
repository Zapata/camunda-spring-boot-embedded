package com.github.zapata.camunda.spring.boot.embedded;

import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class JerseyIntegrationTest extends AbstractIntegrationTest {

	@Test
	public void shouldGetHealthStatus() {
		noAuth().get("/sample").then().assertThat().statusCode(200)
				.body("status.code", equalTo("UP")).and()
				.body("status.description", equalTo("Jersey: Up and Running!"));
	}
}