# Talent-Next-MicroServices

Q.How to start RabbitMQ?
	service->Background Intelligent Transfer service
	service->RabbitMQ

	CMD->Run as Admin
	C:\Windows\system32>rabbitmq-plugins enable rabbitmq_management
	
	RabbitMQ Default port:	http://localhost:15672

Q.How to start application?
	StoreAppEurekaServerApplication	
 	 ->StoreAppConsumerEurekaRibbonApplication
   	  ->StoreAppConfigServerApplication
      	   ->StoreappApplication

Q.Eureka notes:
	Eureka Default port:	http://localhost:8761

	@EnableDiscoveryClient / @EnableEurekaClient	->	we can use anyone both are similar.
