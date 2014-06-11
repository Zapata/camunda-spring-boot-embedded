package com.github.zapata.camunda.spring.boot.embedded.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class CalculateInterestService implements JavaDelegate {

	public void execute(DelegateExecution delegate) throws Exception {

		System.out.println("Spring Bean invoked.");

	}

}
