package com.microservice.controller;

import com.microservice.domain.Product;
import com.microservice.proxy.ProductServiceProxy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("request")
public class ProductClientController {
    @Autowired
    ProductServiceProxy productServiceProxy;

    // http://localhost:9994/get-product-id/1
    @GetMapping("get-product-id/{id}")
    public Product getProductById(@PathVariable("id") int id) {

        Product product = productServiceProxy.getProductById(id);
        return product;
    }

    @GetMapping("get-product-name/{name}")
    public List<Product> getProductById(@PathVariable("name") String name) {

        List<Product> product = productServiceProxy.getProductByName(name);
        return product;
    }

    @GetMapping("get-product-brand/{brand}")
    public List<Product> getProductByBrand(@PathVariable("brand") String brand) {

        List<Product> product = productServiceProxy.getProductByBrand(brand);
        return product;
    }

    @GetMapping("get-product-price/{price}")
    public List<Product> getProductByPrice(@PathVariable("price") Double price) {

        List<Product> product = productServiceProxy.getProductByPrice(price);
        return product;
    }

    @GetMapping("get-products")
    public List<Product> getAllProductById() {

        List<Product> products = productServiceProxy.getAllProductById();
        return products;
    }

}
