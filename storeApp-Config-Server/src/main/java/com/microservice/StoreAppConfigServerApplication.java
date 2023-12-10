package com.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class StoreAppConfigServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(StoreAppConfigServerApplication.class, args);
	}

}
