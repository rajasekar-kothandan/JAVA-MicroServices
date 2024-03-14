package com.microservice.controller;

import com.microservice.domain.Product;
import com.microservice.service.ProductService;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Scope("request")
public class ProductClientController {

    @Autowired
    private ProductService productService;

    //    http://localhost:8992/get-product-id/1
    @Timed(value = "getProductById.time", description = "Time taken to return Product based on ID")
    @GetMapping("/get-product-id/{id}")
    public Product getProductById(@PathVariable("id") int id) {

        return productService.getProductById(id);
    }

    @Timed(value = "getProductByName.time", description = "Time taken to return Product based on Name")
    @GetMapping(value = "/get-product-name/{name}")
    public List<Product> getProductByName(@PathVariable("name") String name) {

        return productService.getProductByName(name);
    }

    @Timed(value = "getProductByBrand.time", description = "Time taken to return Product based on Brand")
    @GetMapping(value = "/get-product-brand/{brand}")
    public List<Product> getProductByBrand(@PathVariable("brand") String brand) {

        return productService.getProductByBrand(brand);
    }

    @Timed(value = "getProductByPrice.time", description = "Time taken to return Product based on Price")
    @GetMapping(value = "/get-product-price/{price}")
    public List<Product> getProductByPrice(@PathVariable("price") Double price) {

        return productService.getProductByPrice(price);
    }

    @Timed(value = "getAllProductById.time", description = "Time taken to return List Products")
    @GetMapping(value = "/get-all-products")
    public List<Product> getAllProductById() {

        return productService.getAllProductById();
    }

}
