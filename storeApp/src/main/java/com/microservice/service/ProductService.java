package com.microservice.service;

import com.microservice.domain.Product;
import com.microservice.repository.ProductRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "productService")
@Scope("singleton")
public class ProductService implements IProductService {

    @Autowired
    @Qualifier(value = "productRepository")
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {

        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Product updateProduct(Integer id, Product product) {
        try {
            productRepository.findById(id).get();
            product.setId(id);
            /*product.setName(product.getName());
              product.setBrand(product.getBrand());
              product.setPrice(product.getPrice());*/
            productRepository.save(product);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> getAllProduct() {

        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {

        return productRepository.findById(id).get();
    }

    @Override
    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);

    }

    @Override
    public List<Product> findByName(String name) {

        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findByBrand(String brand) {

        return productRepository.findByBrand(brand);
    }

    @Override
    public List<Product> findByPrice(double price) {

        return productRepository.findByPrice(price);
    }

}
