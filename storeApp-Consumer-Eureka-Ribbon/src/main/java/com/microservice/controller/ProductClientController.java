package com.microservice.controller;

import com.microservice.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Scope("request")
public class ProductClientController {

    @Autowired
    private RestTemplate restTemplate;

//    http://localhost:9997/get-products/1
    @GetMapping("/get-products/{id}")
    public Product getProductById(@PathVariable("id") Integer id) {

        Product product = restTemplate.getForObject("http://product-service/products/" + id, Product.class);
        return product;
    }

}
