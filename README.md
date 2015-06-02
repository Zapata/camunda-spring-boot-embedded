## What it is?

A demo embedded application for a Camunda (rest + cockpit/tasklist) integrated with Spring Boot (Jersey2 + Undertow).

## How?

# Spring Boot + Jersey 2 + Undertow: 

- Configure gradle correctly (include boot, and exclude tomcat)
- Configure a `ResourceConfig`
- Implement your resource: `SampleResource`

Bonus:
 - Add actuator.
 
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

# Incomming:

- Add metrics and jolokia
- Multi project workflow architecture
