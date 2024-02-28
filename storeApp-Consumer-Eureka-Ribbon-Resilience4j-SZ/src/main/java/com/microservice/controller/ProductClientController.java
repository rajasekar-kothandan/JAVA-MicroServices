package com.microservice.controller;

import com.microservice.domain.Product;
import com.microservice.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(ProductClientController.class);

    //    http://localhost:8999/get-products/1
    @GetMapping("/get-product-id/{id}")
    public Product getProductById(@PathVariable("id") int id) {

        logger.debug("In getProductById with ID: "+id);
        Product product =  productService.getProductById(id);
        logger.debug("In getProductById with return value Product: "+product);
        return product;
    }

    @GetMapping(value = "/get-product-name/{name}")
    public List<Product> getProductByName(@PathVariable("name") String name) {

        logger.debug("In getProductByName with ID: "+name);
        List<Product> product =  productService.getProductByName(name);
        logger.debug("In getProductByName with return value Product: "+product);
        return product;
    }

    @GetMapping(value = "/get-product-brand/{brand}")
    public List<Product> getProductByBrand(@PathVariable("brand") String brand) {

        logger.debug("In getProductByBrand with ID: "+brand);
        List<Product> product =  productService.getProductByBrand(brand);
        logger.debug("In getProductByBrand with return value Product: "+product);
        return product;
    }

    @GetMapping(value = "/get-product-price/{price}")
    public List<Product> getProductByPrice(@PathVariable("price") Double price) {

        logger.debug("In getProductByPrice with ID: "+price);
        List<Product> product =  productService.getProductByPrice(price);
        logger.debug("In getProductByPrice with return value Product: "+product);
        return product;
    }

    @GetMapping(value = "/get-all-products")
    public List<Product> getAllProductById() {

        logger.debug("In getAllProductById ");
        List<Product> product =   productService.getAllProductById();
        logger.debug("In getAllProductById with return value Product: "+product);
        return product;
    }

}
