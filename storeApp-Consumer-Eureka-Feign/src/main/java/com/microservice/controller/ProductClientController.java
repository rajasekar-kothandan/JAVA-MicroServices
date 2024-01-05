package com.microservice.controller;

import com.microservice.domain.Product;
import com.microservice.proxy.ProductServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Scope("request")
public class ProductClientController {

    /*
    * ProductClientController connects ProductServiceProxy
    * */

    @Autowired
    ProductServiceProxy productServiceProxy;

    // http://localhost:9996/get-products/1
    @GetMapping("get-product-id/{id}")
    public Product getProductById(@PathVariable("id") int id) {

        Product product = productServiceProxy.getProductByIds(id);
        return product;
    }

    @GetMapping("get-product-name/{name}")
    public List<Product> getProductByName(@PathVariable("name") String name) {

        List<Product> product = productServiceProxy.getProductByNames(name);
        return product;
    }

    @GetMapping("get-product-brand/{brand}")
    public List<Product> getProductByBrand(@PathVariable("brand") String brand) {

        List<Product> product = productServiceProxy.getProductByBrands(brand);
        return product;
    }

    @GetMapping("get-product-price/{price}")
    public List<Product> getProductByPrice(@PathVariable("price") Double price) {

        List<Product> product = productServiceProxy.getProductByPrices(price);
        return product;
    }

    @GetMapping("get-products")
    public List<Product> getAllProductById() {

        List<Product> products = productServiceProxy.getAllProductByIds();
        return products;
    }

    @PostMapping("add-product")
    public Product addProduct(@RequestBody Product product) {

        Product products = productServiceProxy.addProducts(product);
        return products;
    }

    @PutMapping("update-products/{id}")
    public Product updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        Product products = productServiceProxy.updateProducts(id, product);
        return products;
    }

    @DeleteMapping(value = "delete-product-id/{id}")
    public void deleteProductById(@PathVariable("id") Integer id) {
        productServiceProxy.deleteProductByIds(id);
    }

}
