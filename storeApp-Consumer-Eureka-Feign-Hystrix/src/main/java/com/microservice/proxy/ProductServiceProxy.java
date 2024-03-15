package com.microservice.proxy;

import com.microservice.domain.Product;
import com.microservice.fallback.ProductServiceFallback;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="product-service", fallback = ProductServiceFallback.class)
public interface ProductServiceProxy {

    @GetMapping(value = "/products/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Product getProductById(@PathVariable("id") Integer id);

    @GetMapping(value = "/products/name/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getProductByName(@PathVariable("name") String name);

    @GetMapping(value = "/products/brand/{brand}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getProductByBrand(@PathVariable("brand") String brand);

    @GetMapping(value = "/products/price/{price}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getProductByPrice(@PathVariable("price") Double price);

    @GetMapping(value = "/products", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getAllProductById();

}
