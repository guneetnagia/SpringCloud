package practice.springcloud.microservices.currencyconversionservice;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import practice.springcloud.microservices.currencyconversionservice.VO.CurrencyConvertorBean;

@RestController
public class ConversionController {

	//http://localhost:8000/currency-exchange/from/USD/to/INR
	@GetMapping("/currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConvertorBean convertCurrency(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity){
		return new CurrencyConvertorBean(1L, from, to, BigDecimal.ONE, quantity, quantity, 0);
	}

}
