package com.microservice;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreAppConsumerEurekaRibbonResilience4jSZApplication {
// SZ - means sleuth and Zipkin
	public static void main(String[] args) {
		SpringApplication.run(StoreAppConsumerEurekaRibbonResilience4jSZApplication.class, args);
	}

	public Sampler getSampler(){

//		return Sampler.create(0.5f);
		return Sampler.ALWAYS_SAMPLE;
	}
}
