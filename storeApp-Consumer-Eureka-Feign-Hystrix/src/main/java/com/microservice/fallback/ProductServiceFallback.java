package com.microservice.fallback;

import com.microservice.domain.Product;
import com.microservice.proxy.ProductServiceProxy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ProductServiceFallback implements ProductServiceProxy {

    @Override
    public Product getProductById(Integer id) {

        return new Product(id, "Monitor", "Jio", 34343.0);
    }

    @Override
    public List<Product> getProductByName(String name) {

        return Collections.singletonList(new Product(1, name, "Jio", 34343.0));
    }

    @Override
    public List<Product> getProductByBrand(String brand) {

        return Collections.singletonList(new Product(1, "Monitor", brand, 34343.0));
    }

    @Override
    public List<Product> getProductByPrice(Double price) {

        return Collections.singletonList(new Product(1, "Monitor", "Jio", price));
    }

    @Override
    public List<Product> getAllProductById() {

        return new ArrayList<Product>();
    }

}
