# Talent-Next-MicroServices

Q.How to start RabbitMQ?

	service->Background Intelligent Transfer service
	service->RabbitMQ

	CMD->Run as Admin
	C:\Windows\system32>rabbitmq-plugins enable rabbitmq_management
	
	RabbitMQ Default port:	http://localhost:15672
	
Q.How to start Eureka?

	Eureka Default port:	http://localhost:8761

	@EnableDiscoveryClient / @EnableEurekaClient	->	we can use anyone both are similar.

Q.How to start application?

	1.storeApp-Config-Server (8888 - No_Dependent)
	2.storeApp-Eureka-Server (8761 - No_Dependent)
	3.storeApp (0 - Depends_on_8888_and_8761)
	4.storeApp-Consumer-Eureka-Ribbon (9997 - Depends_on_8761)
		(or)
	4.storeApp-Consumer-Eureka-Feign (9996	- Depends_on_8761)
 	5.storeApp-Consumer-Eureka-Ribbon-Hystrix (9995 - Depends_on_8761)
  		(or)
 	5.storeApp-Consumer-Eureka-Feign-Hystrix (9994 - Depends_on_8761)
Note:
	Ribbon and Feign are consumers of application. we can use (anyone or both) of consumers for application.
 	Ribbon-Hystrix and Feign-Hystrix are consumers of application with FallBackMethods.
	
service-to-service call:

	1)Ribbon (RestTemplate):
		@LoadBalanced
	2)OpenFeign:
		@FeignClients
		
Q.What are the Methods of Circuit-Breaker Implementation?

	1)Hystrix: (Supported version)
		Spring Boot version < 2.4.X
		Note:
			Spring Boot: 2.3.10.RELEASE
			Spring Cloud: Hoxton.SR11
	2)Resilience4j:(Supported version)
		Spring Boot version >= 2.4.X

Q.How to Implement spring cloud Hystrix?

	1)Ribbon (RestTemplate):
		@HystrixCommand(fallbackMethod = "")
	2)OpenFeign:
		@FeignClients(name="",fallback=)
Note:
	@HystrixCommand(fallbackMethod = "") / @FeignClients(fallback) will only works in a class marked with @Service/@Component.
