package com.microservice.controller;

import com.microservice.domain.Product;
import com.microservice.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

@RestController
@Scope("request")
public class ProductClientController {

    @Autowired
    private ProductService productService;

    // http://localhost:9993/get-product-id/1
    @GetMapping("/get-product-id/{id}")
    public Product getProductById(@PathVariable("id") int id) {

        return productService.getProductById(id);
    }

    @GetMapping(value = "/get-product-name/{name}")
    public List<Product> getProductByName(@PathVariable("name") String name) {

        return productService.getProductByName(name);
    }

    @GetMapping(value = "/get-product-brand/{brand}")
    public List<Product> getProductByBrand(@PathVariable("brand") String brand) {

        return productService.getProductByBrand(brand);
    }

    @GetMapping(value = "/get-product-price/{price}")
    public List<Product> getProductByPrice(@PathVariable("price") Double price) {

        return productService.getProductByPrice(price);
    }

    @GetMapping(value = "/get-all-products")
    public List<Product> getAllProductById() {

        return productService.getAllProductById();
    }

}
