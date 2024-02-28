package com.microservice.service;

import com.microservice.domain.Product;

import java.util.List;

public interface IProductService {

    public Product addProduct(Product product);
    public Product updateProduct(Integer id,Product product);
    public List<Product> getAllProduct();
    public Product getProductById(Integer id);
    public void deleteProductById(Integer id);

    // Custom methods
    public List<Product> findByName(String name);
    public List<Product> findByBrand(String brand);
    public List<Product> findByPrice(double price);

}
