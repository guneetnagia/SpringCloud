package practice.springcloud.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import practice.springcloud.microservices.currencyconversionservice.VO.CurrencyConvertorBean;

@RestController
@EnableFeignClients("practice.springcloud.microservices.currencyconversionservice")
public class ConversionController {
	
	@Autowired
	private CurrencyExchangeServiceProxy feignproxy;

	@GetMapping("/currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConvertorBean convertCurrency(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity){
		
		// Feign solves this problem
		Map<String, String> uriVariable = new HashMap<>();
		uriVariable.put("from",from);
		uriVariable.put("to",to);
		
		ResponseEntity<CurrencyConvertorBean> responseEntity = 
				new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
						CurrencyConvertorBean.class, uriVariable);
		
		CurrencyConvertorBean response = responseEntity.getBody();
		return new CurrencyConvertorBean(response.getId(), from, to, response.getConversionMultiple(), quantity, 
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}
	
	
	@GetMapping("/currency-convertor-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConvertorBean convertCurrencyFeign(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity){
		
		CurrencyConvertorBean response = feignproxy.exchangeCurrency(from, to);
		
		return new CurrencyConvertorBean(response.getId(), from, to, response.getConversionMultiple(), quantity, 
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}

}
