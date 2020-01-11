package practice.springcloud.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import practice.springcloud.microservices.currencyexchangeservice.vo.ExchangeValue;

@RestController
public class ExchangeRateController {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue exchangeCurrency(@PathVariable String from,
			@PathVariable String to){
		return new ExchangeValue(1000L,from,to,BigDecimal.valueOf(75));
	}
}
