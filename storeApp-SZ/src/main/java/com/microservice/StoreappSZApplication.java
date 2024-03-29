package com.microservice;

import brave.sampler.Sampler;

import com.microservice.domain.Product;
import com.microservice.repository.ProductRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class StoreappSZApplication implements CommandLineRunner {

    private static Logger LOG = LoggerFactory.getLogger(StoreappSZApplication.class);

    @Autowired
    @Qualifier("productRepository")
    ProductRepository productRepository;

    public static void main(String[] args) {

        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(StoreappSZApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }

    @Bean
    public Sampler getSampler() {

        return Sampler.ALWAYS_SAMPLE;
    }

    @Override
    public void run(String... args) throws Exception {

        LOG.info("EXECUTING : command line runner");
        productRepository.save(new Product(null, "TV", "LG", 74500.0));
        productRepository.save(new Product(null, "Monitor", "DELL", 24000.0));
        productRepository.save(new Product(null, "EarBuds2", "Samsung", 45000.0));
        productRepository.save(new Product(null, "Mobile", "OnePlus11R", 34500.0));
    }

}
