## What it is?

A demo embedded application for a Camunda (rest + cockpit/tasklist) integrated with Spring Boot (Jersey2 + Undertow).

## How?

# Spring Boot + Jersey 2 + Undertow: 

- Configure gradle correctly (include boot, and exclude tomcat)
- Configure a `ResourceConfig`
- Implement your resource: `SampleResource`
 
# Camunda integration:

- Include camunda dependencies.
- Declare a SPI ProcessEngineProvider (see src/main/resources/META-INF/services)
- Implement it: `RestProcessEngineProvider`
- Configure the process engine: `ProcessEngineSpringConfiguration`
- Implement your BPM / service class.

# Camunda Rest + Cockpit integration:

- Include webapp depedencies (note `classes` classifier): 
	
	compile("org.camunda.bpm:camunda-engine-rest:$camundaVersion:classes")
	compile("org.camunda.bpm.webapp:camunda-webapp:$camundaVersion:classes")

- Repackage the Javascript/Html files in a webjar-like manner: `camunda-webapp-webjar/build.gradle`

- Register all the Camunda servlets: `CamundaWebAppInitializer`


# Tests:

- Use [REST-assured](https://code.google.com/p/rest-assured/) coz it rocks!

# Production ready:

 - Add Spring boot actuator.
 - Configure Dropwizard metrics.
 - Expose JMX as HTTP with jolokia.

## What's next?

- API documentation with swagger.
- Multi project workflow architecture

