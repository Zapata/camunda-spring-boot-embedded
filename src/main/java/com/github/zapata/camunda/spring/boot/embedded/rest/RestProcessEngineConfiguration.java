package com.github.zapata.camunda.spring.boot.embedded.rest;

import org.camunda.bpm.engine.rest.impl.CamundaRestResources;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.github.zapata.camunda.spring.boot.embedded.resource.SampleResource;

@Configuration
public class RestProcessEngineConfiguration extends ResourceConfig {

	public RestProcessEngineConfiguration() {
		this.registerClasses(CamundaRestResources.getResourceClasses());
		this.registerClasses(CamundaRestResources.getConfigurationClasses());
		this.register(SampleResource.class);
	}

}