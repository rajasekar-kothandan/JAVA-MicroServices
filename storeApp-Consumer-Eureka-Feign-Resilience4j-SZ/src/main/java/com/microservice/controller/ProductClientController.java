package com.microservice.controller;

import com.microservice.domain.Product;
import com.microservice.proxy.ProductServiceProxy;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(ProductClientController.class);

    // http://localhost:8998/get-product-id/1
    @GetMapping("get-product-id/{id}")
    public Product getProductById(@PathVariable("id") int id) {

        logger.debug("In getProductById with ID: " + id);
        Product product = productServiceProxy.getProductById(id);
        logger.debug("In getProductById with return value Product: " + product);
        return product;
    }

    @GetMapping("get-product-name/{name}")
    public List<Product> getProductById(@PathVariable("name") String name) {

        logger.debug("In getProductByName with ID: " + name);
        List<Product> product = productServiceProxy.getProductByName(name);
        logger.debug("In getProductByName with return value Product: " + product);
        return product;
    }

    @GetMapping("get-product-brand/{brand}")
    public List<Product> getProductByBrand(@PathVariable("brand") String brand) {

        logger.debug("In getProductByBrand with ID: " + brand);
        List<Product> product = productServiceProxy.getProductByBrand(brand);
        logger.debug("In getProductByBrand with return value Product: " + product);
        return product;
    }

    @GetMapping("get-product-price/{price}")
    public List<Product> getProductByPrice(@PathVariable("price") Double price) {

        logger.debug("In getProductByPrice with ID: " + price);
        List<Product> product = productServiceProxy.getProductByPrice(price);
        logger.debug("In getProductByPrice with return value Product: " + product);
        return product;
    }

    @GetMapping("get-products")
    public List<Product> getAllProductById() {

        logger.debug("In getAllProductById ");
        List<Product> products = productServiceProxy.getAllProductById();
        logger.debug("In getAllProductById with return value Product: " + products);
        return products;
    }

}
