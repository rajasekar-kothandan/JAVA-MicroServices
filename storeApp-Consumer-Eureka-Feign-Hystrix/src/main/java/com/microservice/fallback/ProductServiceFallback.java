package com.microservice.fallback;

import com.microservice.domain.Product;
import com.microservice.proxy.ProductServiceProxy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductServiceFallback implements ProductServiceProxy {
    @Override
    public Product getProductById(Integer id) {
        return new Product(id, "Monitor", "Jio", 34343.0);
    }

    @Override
    public List<Product> getAllProductById() {
        return new ArrayList<Product>();
    }

}
