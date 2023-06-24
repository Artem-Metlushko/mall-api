package com.trainee.interfaces;

import com.trainee.bean.Product;

import java.util.List;


public interface ProductService {

    Product save(Product product);
    Product findById(Long productId);
    void delete(Product product);
    List<Product> findAll();
}
