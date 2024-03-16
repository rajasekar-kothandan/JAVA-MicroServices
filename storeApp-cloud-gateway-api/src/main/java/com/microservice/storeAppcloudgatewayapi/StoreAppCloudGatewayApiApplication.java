package com.microservice.storeAppcloudgatewayapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class StoreAppCloudGatewayApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(StoreAppCloudGatewayApiApplication.class, args);
	}

}
