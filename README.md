# SpringCloud
Config server, Eureka, Ribbon, Feign, Zipkin, Zuul, Hystrix

------------------------
------------------------
------------------------
application-name : limits-service
port: 8079
http://localhost:8079/limits

------------------------
------------------------
------------------------
application-name : limits-service
port: 8079
http://localhost:8079/limits
------------------------
------------------------
------------------------
application name : spring-cloud-config-server
port=8888
http://localhost:8888/limits-service/default
------------------------
------------------------
------------------------
application name : currency-exchange-service
port=8000,8001
http://localhost:8000/currency-exchange/from/USD/to/INR
command to run on different port : mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8001
http://localhost:8000/h2-console
------------------------
------------------------
------------------------
application name : currency-conversion-service
port=8100,8101
http://localhost:8100/currency-convertor/from/USD/to/INR/quantity/1