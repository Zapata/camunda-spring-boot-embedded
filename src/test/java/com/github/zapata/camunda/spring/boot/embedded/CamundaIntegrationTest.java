package com.github.zapata.camunda.spring.boot.embedded;

import static org.hamcrest.Matchers.contains;

import org.junit.Test;

import com.jayway.restassured.http.ContentType;

public class CamundaIntegrationTest extends AbstractIntegrationTest {

	@Test
	public void shouldGetEnginesUsingRestApi() {
		noAuth().get("/api/engine/engine").then().assertThat().statusCode(200)
				.body("name", contains("default"));
	}

	@Test
	public void shouldGetIndexHtmlPage() {
		noAuth().get("/").then().assertThat().statusCode(200)
				.contentType(ContentType.HTML);
	}
}