package com.github.zapata.camunda.spring.boot.embedded;

import static com.jayway.restassured.RestAssured.with;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(value = { "server.port=9000", "management.port=9001" })
public abstract class AbstractIntegrationTest {

	@Value("${management.port}")
	protected int managementPort;

	@Value("${server.port}")
	protected int serverPort;

	@Before
	public void initConnection() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = serverPort;

		RestAssured.requestContentType(ContentType.JSON);
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	}

	protected RequestSpecification auth(String userName) {
		return with().auth().preemptive().basic(userName, userName);
	}

	protected RequestSpecification noAuth() {
		return with().auth().none();
	}
}
