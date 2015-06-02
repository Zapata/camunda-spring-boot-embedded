package com.github.zapata.camunda.spring.boot.embedded.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import com.codahale.metrics.annotation.Timed;

@Component
@Path("/sample")
public class SampleResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Timed
	public Health health() {
		return Health.status(new Status("UP", "Jersey: Up and Running!"))
				.build();
	}
}
