package com.microservice.controller;

import com.microservice.domain.Product;
import com.microservice.proxy.ProductServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Scope("request")
public class ProductClientController {
    @Autowired
    ProductServiceProxy productServiceProxy;

    @GetMapping("get-products/{id}")
    public Product getProductById(@PathVariable("id") int id) {
        Product product = productServiceProxy.getProductById(id);
        return product;
    }

    @GetMapping("get-products")
    public List<Product> getAllProductById() {
        List<Product> products = productServiceProxy.getAllProductById();
        return products;
    }
}
