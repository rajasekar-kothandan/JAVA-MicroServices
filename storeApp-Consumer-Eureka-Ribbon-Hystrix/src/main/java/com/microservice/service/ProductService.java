package com.microservice.service;

import com.microservice.domain.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    // Registry aware RestTemplate
    @Autowired
    public RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }


    // @HystrixCommand(fallbackMethod = "") will only works in a class marked with @Service/@Component.
    @HystrixCommand(fallbackMethod = "fallbackMethodForGetProductById")
    public Product getProductById(int id) {

        Product product = restTemplate.getForObject("http://product-service/products/" + id, Product.class);
        return product;
    }

    @HystrixCommand(fallbackMethod = "fallbackMethodForGetProductByName")
    public List<Product> getProductByName(@PathVariable("name") String name) {

        // To get Product details by name
        List<Product> product = restTemplate.getForObject("http://product-service/products/name/" + name, ArrayList.class);
        return product;
    }

    @HystrixCommand(fallbackMethod = "fallbackMethodForGetProductByBrand")
    public List<Product> getProductByBrand(@PathVariable("brand") String brand) {

        // To get Product details by brand
        List<Product> product = restTemplate.getForObject("http://product-service/products/brand/" + brand, ArrayList.class);
        return product;
    }

    @HystrixCommand(fallbackMethod = "fallbackMethodForGetProductByPrice")
    public List<Product> getProductByPrice(@PathVariable("price") Double price) {

        // To get Product details by price
        List<Product> product = restTemplate.getForObject("http://product-service/products/price/" + price, ArrayList.class);
        return product;
    }

    @HystrixCommand(fallbackMethod = "fallbackMethodForGetAllProducts")
    public List<Product> getAllProductById() {

        List<Product> product = restTemplate.getForObject("http://product-service/products", ArrayList.class);
        return product;
    }

/***********     Fall_Back_Methods      ***************/
    public Product fallbackMethodForGetProductById(int id) {

        return new Product(id, "Monitor", "Jio", 34343.0);
    }

    public List<Product> fallbackMethodForGetProductByName(String name) {

        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product(1, name, "Jio", 34343.0));
        return products;
    }

    public List<Product> fallbackMethodForGetProductByBrand(String brand) {

        return Collections.singletonList(new Product(1, "Monitor", brand, 34343.0));
    }

    public List<Product> fallbackMethodForGetProductByPrice(Double price) {

        return Collections.singletonList(new Product(1, "Monitor", "Jio", price));
    }

    public List<Product> fallbackMethodForGetAllProducts(){
        return Collections.singletonList(new Product(1, "Monitor", "Jio", 50000.0));
    }

}
