package com.github.zapata.camunda.spring.boot.embedded.service;

import org.springframework.stereotype.Component;

@Component
public class CalculateInterestService {

	public void compute() {
		System.out.println("Spring Bean invoked.");
	}

}
