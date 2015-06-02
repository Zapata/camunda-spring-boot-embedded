package com.github.zapata.camunda.spring.boot.embedded.service;

import org.springframework.stereotype.Component;

import com.codahale.metrics.annotation.Timed;

@Component
public class CalculateInterestService {

	@Timed
	public void compute() {
		System.out.println("Spring Bean invoked.");
	}

}
