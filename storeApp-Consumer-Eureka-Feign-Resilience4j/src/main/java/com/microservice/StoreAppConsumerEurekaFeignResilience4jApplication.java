package com.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class StoreAppConsumerEurekaFeignResilience4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreAppConsumerEurekaFeignResilience4jApplication.class, args);
	}

}
