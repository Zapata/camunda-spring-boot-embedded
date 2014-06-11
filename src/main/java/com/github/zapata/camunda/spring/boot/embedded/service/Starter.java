package com.github.zapata.camunda.spring.boot.embedded.service;

import javax.annotation.PostConstruct;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Starter {

	@Autowired
	private RuntimeService runtimeService;

	@PostConstruct
	public void afterPropertiesSet() {
		runtimeService.startProcessInstanceByKey("loanApproval");
	}
}
