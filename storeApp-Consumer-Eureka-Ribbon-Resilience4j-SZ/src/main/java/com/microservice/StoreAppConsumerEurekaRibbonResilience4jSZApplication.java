package com.microservice;

import brave.sampler.Sampler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// SZ - means sleuth and Zipkin
@SpringBootApplication
public class StoreAppConsumerEurekaRibbonResilience4jSZApplication {

	public static void main(String[] args) {

		SpringApplication.run(StoreAppConsumerEurekaRibbonResilience4jSZApplication.class, args);
	}

	@Bean
	public Sampler getSampler(){

		//return Sampler.create(0.5f);
		return Sampler.ALWAYS_SAMPLE;
	}

}
