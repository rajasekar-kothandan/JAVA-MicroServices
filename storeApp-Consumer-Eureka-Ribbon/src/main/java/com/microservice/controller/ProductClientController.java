package com.microservice.controller;

import com.microservice.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@Scope("request")
public class ProductClientController {

    /*
     * Registry aware RestTemplate (HTTP Client).
     * ProductClientController connects to ProductController(storeApp) through Eureka server Service_ID "product-service"
     * */

    @Autowired
    private RestTemplate restTemplate;

    //    http://localhost:9997/get-products/1
    @GetMapping("/get-product-id/{id}")
    public Product getProductById(@PathVariable("id") Integer id) {

        // To get Product details by ID
        Product product = restTemplate.getForObject("http://product-service/products/" + id, Product.class);
        return product;
    }

    @GetMapping(value = "/get-product-name/{name}")
    public List<Product> getProductByName(@PathVariable("name") String name) {

        // To get Product details by name
        List<Product> product = restTemplate.getForObject("http://product-service/products/name/" + name, ArrayList.class);
        return product;
    }

    @GetMapping(value = "/get-product-brand/{brand}")
    public List<Product> getProductByBrand(@PathVariable("brand") String brand) {

        // To get Product details by brand
        List<Product> product = restTemplate.getForObject("http://product-service/products/brand/" + brand, ArrayList.class);
        return product;
    }

    @GetMapping(value = "/get-product-price/{price}")
    public List<Product> getProductByPrice(@PathVariable("price") String price) {

        // To get Product details by price
        List<Product> product = restTemplate.getForObject("http://product-service/products/price/" + price, ArrayList.class);
        return product;
    }

    @GetMapping(value = "/get-all-products")
    public List<Product> getAllProductById() {

        // To get List of Product details
        List<Product> product = restTemplate.getForObject("http://product-service/products", ArrayList.class);
        return product;
    }

    @PostMapping(value = "/add-product")
    public Product addProduct(@RequestBody Product product) {

        // To Add Product details
        Product products = restTemplate.postForObject("http://product-service/products", product, Product.class);
        return products;
    }

    @PutMapping(value = "/update-products/{id}")
    public Product updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {

        // To Modify Product details by ID
        restTemplate.put("http://product-service/products/" + id, product);

        // To Verify updated Product details by ID
        Product products = restTemplate.getForObject("http://product-service/products/" + id, Product.class);
        return products;
    }

    @DeleteMapping(value = "/delete-product-id/{id}")
    public void deleteProductById(@PathVariable("id") Integer id) {

        // To Delete Product details by ID
        restTemplate.delete("http://product-service/products/" + id);
    }
}
