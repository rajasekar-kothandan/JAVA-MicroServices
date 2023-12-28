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
Note:
	Ribbon and Feign are consumers of application.
	we can use (anyone or both) of consumers for application.
	
service-to-service call:

	1)Ribbon (RestTemplate):
		@LoadBalanced
	2)OpenFeign:
		@FeignClients
