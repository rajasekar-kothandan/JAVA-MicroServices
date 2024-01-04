package com.microservice.service;

import com.microservice.domain.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    /*
    * Registry aware RestTemplate
    * */
    @Autowired
    public RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }

    /*
     * @HystrixCommand(fallbackMethod = "") will only works in a class marked with @Service/@Component.
     * */
    @HystrixCommand(fallbackMethod = "fallbackMethodForGetProductById")
    public Product getProductById(int id) {

        Product product = restTemplate.getForObject("http://product-service/products/" + id, Product.class);
        return product;
    }

    public Product fallbackMethodForGetProductById(int id) {

        return new Product(id, "Monitor", "Jio", 34343.0);
    }
}
