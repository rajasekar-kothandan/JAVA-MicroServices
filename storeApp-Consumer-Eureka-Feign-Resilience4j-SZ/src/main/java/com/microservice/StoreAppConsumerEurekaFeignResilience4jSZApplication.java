package com.microservice;

import brave.sampler.Sampler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class StoreAppConsumerEurekaFeignResilience4jSZApplication {

    // SZ - means sleuth and Zipkin
    public static void main(String[] args) {

        SpringApplication.run(StoreAppConsumerEurekaFeignResilience4jSZApplication.class, args);
    }

    @Bean
    public Sampler getSampler() {

        //return Sampler.create(0.5f);
        return Sampler.ALWAYS_SAMPLE;
    }

}
