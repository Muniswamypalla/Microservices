package com.spring.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsController {

	@Autowired
	private LimitsConfiguration limitsConfig;

	@GetMapping("/limits")
	@HystrixCommand(fallbackMethod = "fault-tolerance")
	public LimitsConfiguration retriveConfigFromCloud() {
		return new LimitsConfiguration(limitsConfig.getMin(), limitsConfig.getMax());
	}

	@GetMapping("/fault-tolerance-example")
	@HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
	public LimitsConfiguration retrieveConfiguration() {
		throw new RuntimeException("Not available");
	}

	public LimitsConfiguration fallbackRetrieveConfiguration() {
		return new LimitsConfiguration(999, 9);
	}
}
