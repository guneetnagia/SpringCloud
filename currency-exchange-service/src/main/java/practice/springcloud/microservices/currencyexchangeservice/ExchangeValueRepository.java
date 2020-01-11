package practice.springcloud.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

import practice.springcloud.microservices.currencyexchangeservice.vo.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{

	ExchangeValue findByFromAndTo(String from, String to);
}
