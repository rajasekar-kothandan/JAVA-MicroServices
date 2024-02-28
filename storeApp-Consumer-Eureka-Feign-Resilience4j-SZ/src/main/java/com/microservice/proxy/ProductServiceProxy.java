package com.microservice.proxy;

import com.microservice.domain.Product;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@FeignClient(name="product-service")
public interface ProductServiceProxy {

    @Retry(name = "product-service")
    @CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodGetProductById")
    @GetMapping(value = "/products/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Product getProductById(@PathVariable("id") Integer id);

    @Retry(name = "product-service")
    @CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodGetProductByName")
    @GetMapping(value = "/products/name/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getProductByName(@PathVariable("name") String name);

    @Retry(name = "product-service")
    @CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodGetProductByBrand")
    @GetMapping(value = "/products/brand/{brand}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getProductByBrand(@PathVariable("brand") String brand);

    @Retry(name = "product-service")
    @CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodGetProductByPrice")
    @GetMapping(value = "/products/price/{price}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getProductByPrice(@PathVariable("price") Double price);

    @Retry(name = "product-service")
    @CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodGetAllProductById")
    @GetMapping(value = "/products", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getAllProductById();

    public default Product fallbackMethodGetProductById(@PathVariable("id") Integer id, Throwable cause){

        System.out.println("Exception Raised with the message:=======> "+cause.getMessage());
        return new Product(id, "Monitor", "Jio", 34343.0);
    };

    public default List<Product> fallbackMethodGetProductByName(@PathVariable("name") String name, Throwable cause){

        System.out.println("Exception Raised with the message:=======> "+cause.getMessage());
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product(1, name, "Jio", 34343.0));
        return products;
    };

    public default List<Product> fallbackMethodGetProductByBrand(@PathVariable("brand") String brand, Throwable cause){

        System.out.println("Exception Raised with the message:=======> "+cause.getMessage());
        return Collections.singletonList(new Product(1, "Monitor", brand, 34343.0));
    };

    public default List<Product> fallbackMethodGetProductByPrice(@PathVariable("price") Double price, Throwable cause){

        System.out.println("Exception Raised with the message:=======> "+cause.getMessage());
        return Collections.singletonList(new Product(1, "Monitor", "Jio", price));
    };

    public default List<Product> fallbackMethodGetAllProductById(Throwable cause){

        System.out.println("Exception Raised with the message:=======> "+cause.getMessage());
//        return new ArrayList<Product>();
        return Collections.singletonList(new Product(1, "Monitor", "Jio", 50000.0));
    };

}
