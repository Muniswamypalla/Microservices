package com.spring.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {
	
	@Autowired
	private LimitsConfiguration limitsConfig;

	@GetMapping("/limits")
	public LimitsConfiguration retriveConfigFromCloud() {
		return new LimitsConfiguration(limitsConfig.getMin(), limitsConfig.getMax());
	}
}
