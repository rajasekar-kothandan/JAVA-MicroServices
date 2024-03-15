# Talent-Next-MicroServices

Applications Name with port number:

	1.storeApp-Config-Server							-	server.port=8888
	2.storeApp-Eureka-Server							-	server.port=8761
	3.storeApp											-	server.port=0
	4.storeapp-SZ										-	server.port=0
	5.storeApp-Consumer-Eureka-Feign					-	server.port=9996
	6.toreApp-Consumer-Eureka-Feign-Hystrix				-	server.port=9994
	7.storeApp-Consumer-Eureka-Feign-Resilience4j		-	server.port=9992
	8.storeApp-Consumer-Eureka-Feign-Resilience4j-SZ	-	server.port=8998
	9.storeApp-Consumer-Eureka-Ribbon					-	server.port=9997
	10.storeApp-Consumer-Eureka-Ribbon-Hystrix			-	server.port=9995
	11.storeApp-Consumer-Eureka-Ribbon-Resilience4j		-	server.port=9993
	12.storeApp-Consumer-Eureka-Ribbon-Resilience4j-MP	-	server.port=8992
	13.storeApp-Consumer-Eureka-Ribbon-Resilience4j-SZ	-	server.port=8999
	14.storeApp-Proxy-API								-	server.port=8080
	15.storeApp-Proxy-API-Eureka						-	server.port=8080

Notes:
	SZ - Sleuth and Zipkin
	MP - Micrometer and Prometheus


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
		(or)
 	5.storeApp-Consumer-Eureka-Ribbon-Hystrix (9995 - Depends_on_8761)
  		(or)
 	5.storeApp-Consumer-Eureka-Feign-Hystrix (9994 - Depends_on_8761)
Note:
	Ribbon and Feign are consumers of application. we can use (anyone or both) of consumers for application.
 	Ribbon-Hystrix and Feign-Hystrix are consumers of application with FallBackMethods.

Q.How to see Hystrix-Dashboard for storeApp-Consumer-Eureka-Feign-Hystrix?

	1. launch on Browser: http://localhost:9994/hystrix
	2. Enter in DashBoard: http://localhost:9994/actuator/hystrix.stream
	3. click on Monitor Stream button
	
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


Docker Commands:

Q.How to Start RabbitMQ in Docker?

	# latest RabbitMQ 3.13
	1.open cmd
	2.docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.13-management
	3.http://localhost:15672/#/


Q.How to Start zipkins in Docker?

	1.open cmd
	2.docker run -p 9411:9411 openzipkin/zipkin
	3.http://inlocalhost:9411/zipkin/


Q.How to start prometheus to understand/read micrometer in Docker?

	1.open cmd
	2.docker run -p 9090:9090 -v C:\prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus
	3.http://inlocalhost:9090
Notes:
	File(prometheus.yml) location should be C:\prometheus.yml