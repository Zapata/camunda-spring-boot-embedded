package com.github.zapata.camunda.spring.boot.embedded;

import static org.hamcrest.Matchers.contains;

import org.junit.Test;

public class CamundaRestIntegrationTest extends AbstractIntegrationTest {

	@Test
	public void shouldGetEngines() {
		noAuth().get("/engine").then().assertThat().statusCode(200)
				.body("name", contains("default"));
	}
}