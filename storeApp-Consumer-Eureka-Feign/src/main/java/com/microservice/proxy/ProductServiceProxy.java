package com.microservice.proxy;

import com.microservice.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("product-service")
public interface ProductServiceProxy {

    /*
     * ProductServiceProxy connects to ProductController(storeApp) through Eureka server Service_ID "product-service"
     * */

    @GetMapping(value = "/products/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Product getProductByIds(@PathVariable("id") Integer id);

    @GetMapping(value = "/products/name/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getProductByNames(@PathVariable("name") String name);

    @GetMapping(value = "/products/brand/{brand}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getProductByBrands(@PathVariable("brand") String brand);

    @GetMapping(value = "/products/price/{price}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getProductByPrices(@PathVariable("price") String price);

    @GetMapping(value = "/products", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getAllProductByIds();

    @PostMapping(value = "/products", produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    Product addProducts(Product product);

    @PutMapping(value = "/products/{id}", produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Product updateProducts(@PathVariable("id") Integer id, @RequestBody Product product);

    @DeleteMapping(value = "/products/{id}")
    public void deleteProductByIds(@PathVariable("id") Integer id);

}
