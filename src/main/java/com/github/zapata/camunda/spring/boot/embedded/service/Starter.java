package com.github.zapata.camunda.spring.boot.embedded.service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.stereotype.Component;

@Component
public class Starter {

	@Inject
	private RuntimeService runtimeService;

	@PostConstruct
	public void afterPropertiesSet() {
		runtimeService.startProcessInstanceByKey("loanApproval");
	}
}
