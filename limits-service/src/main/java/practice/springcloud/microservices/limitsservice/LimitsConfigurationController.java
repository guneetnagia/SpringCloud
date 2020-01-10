package practice.springcloud.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import practice.springcloud.microservices.limitsservice.vo.LimitConfiguration;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfiguration() {
		return new LimitConfiguration(configuration.getMinimum(),configuration.getMaximum());
	}
}
