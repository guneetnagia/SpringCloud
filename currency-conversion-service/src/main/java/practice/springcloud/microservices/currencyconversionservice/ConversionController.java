package practice.springcloud.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import practice.springcloud.microservices.currencyconversionservice.VO.CurrencyConvertorBean;

@RestController
public class ConversionController {

	@GetMapping("/currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConvertorBean convertCurrency(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity){
		
		Map<String, String> uriVariable = new HashMap<>();
		uriVariable.put("from",from);
		uriVariable.put("to",to);
		
		ResponseEntity<CurrencyConvertorBean> responseEntity = 
				new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
						CurrencyConvertorBean.class, uriVariable);
		
		CurrencyConvertorBean response = responseEntity.getBody();
		System.out.println(response);
		return new CurrencyConvertorBean(response.getId(), from, to, response.getConversionMultiple(), quantity, 
				quantity.multiply(response.getConversionMultiple()), 0);
	}

}
