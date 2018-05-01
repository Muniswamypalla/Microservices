package com.spring.microservices;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient("currency-exchange-service")//with out zuul
@FeignClient("zuul-api-gateway-server")
@RibbonClient("currency-exchange-service")//if your request want go through the zuul api gareway
public interface CurrencyExchangeServiceProxy {

	// @GetMapping("/currency-exchange/from/{from}/to/{to}")//with out zuul
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")//if your request want go through the zuul api gareway
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,
			@PathVariable("to") String to);

}
