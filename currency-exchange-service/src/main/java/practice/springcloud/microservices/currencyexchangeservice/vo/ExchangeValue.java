package practice.springcloud.microservices.currencyexchangeservice.vo;

import java.math.BigDecimal;

public class ExchangeValue {
	private long id;
	private BigDecimal conversionMultiple;
	private String from;
	private String to;
	private int port;
	
	public ExchangeValue(long id, String from, String to, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.conversionMultiple = conversionMultiple;
		this.from = from;
		this.to = to;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public ExchangeValue() {
		super();
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	
}
