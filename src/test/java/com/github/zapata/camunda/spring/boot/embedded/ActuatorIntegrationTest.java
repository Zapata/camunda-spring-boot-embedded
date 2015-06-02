package com.github.zapata.camunda.spring.boot.embedded;

import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import com.github.zapata.camunda.spring.boot.embedded.service.CalculateInterestService;

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

	@Test
	public void shouldHaveDropwizardMetricsRegistered() {
		noAuth().port(managementPort)
				.get("/metrics/" + CalculateInterestService.class.getName()
						+ ".compute.count").then().assertThat().statusCode(200)
				.body(equalTo("1"));
	}

	@Test
	public void shouldHaveJolokiaServlet() {
		noAuth().port(managementPort)
				.get("/jolokia/read/java.lang:type=Memory/HeapMemoryUsage")
				.then().assertThat().statusCode(200);
	}
}