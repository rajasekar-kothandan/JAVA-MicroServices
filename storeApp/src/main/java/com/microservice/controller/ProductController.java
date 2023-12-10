package com.microservice.controller;

import com.microservice.domain.Product;
import com.microservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Scope("request")
public class ProductController {

    @Autowired
    @Qualifier("productService")
    private IProductService productService;

    @PostMapping(value = "/products", produces = {MediaType.APPLICATION_JSON_VALUE},
    consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(code = HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product){

        return productService.addProduct(product);
    }

    @PutMapping(value = "/products", produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(code = HttpStatus.OK)
    public Product updateProduct(@RequestBody Product product){

        return productService.updateProduct(product);
    }

    @DeleteMapping(value = "/products/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable("id") Integer id){

        productService.deleteProductById(id);
    }

    @GetMapping(value = "/products/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(code = HttpStatus.OK)
    public Product getProductById(@PathVariable("id") Integer id){

        return productService.getProductById(id);
    }

    @GetMapping(value = "/products", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getAllProductById(){

        return productService.getAllProduct();
    }

    @GetMapping(value = "/products/name/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getProductByName(@PathVariable("name") String name){

        return productService.findByName(name);
    }

    @GetMapping(value = "/products/brand/{brand}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getProductByBrand(@PathVariable("brand") String brand){

        return productService.findByBrand(brand);
    }

    @GetMapping(value = "/products/price/{price}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getProductByPrice(@PathVariable("price") double price){

        return productService.findByPrice(price);
    }
}
