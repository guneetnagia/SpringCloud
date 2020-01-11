package practice.springcloud.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import practice.springcloud.microservices.currencyexchangeservice.vo.ExchangeValue;

@RestController
public class ExchangeRateController {

	@Autowired
	private Environment environment;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue exchangeCurrency(@PathVariable String from,
			@PathVariable String to){
		ExchangeValue val = new ExchangeValue(1000L,from,to,BigDecimal.valueOf(75));
		val.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return val;
	}
}
