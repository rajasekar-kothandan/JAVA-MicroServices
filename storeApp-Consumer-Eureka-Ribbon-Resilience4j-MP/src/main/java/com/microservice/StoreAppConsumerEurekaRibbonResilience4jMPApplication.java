package com.microservice;

import io.micrometer.core.aop.TimedAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StoreAppConsumerEurekaRibbonResilience4jMPApplication {

	public static void main(String[] args) {

		//MP - mean micrometer and prometheus
		SpringApplication.run(StoreAppConsumerEurekaRibbonResilience4jMPApplication.class, args);
	}

	@Bean
	public TimedAspect timedAspect(){

		return new TimedAspect();
	}

}
