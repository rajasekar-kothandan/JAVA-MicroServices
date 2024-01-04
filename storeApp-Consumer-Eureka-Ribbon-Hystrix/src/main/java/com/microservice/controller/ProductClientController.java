package com.microservice.controller;

import com.microservice.domain.Product;
import com.microservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("request")
public class ProductClientController {

    @Autowired
    private ProductService productService;

//    http://localhost:9996/get-products/1
    @GetMapping("/get-products/{id}")
    public Product getProductById(@PathVariable("id") int id) {

        return productService.getProductById(id);
    }

}
