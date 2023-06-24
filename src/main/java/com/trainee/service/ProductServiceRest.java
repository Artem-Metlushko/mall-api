package com.trainee.service;

import com.trainee.bean.Product;
import com.trainee.interfaces.ProductService;
import com.trainee.repository.ProductRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductServiceRest implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceRest(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(final Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(final Long productId) {
        Product product = new Product(null, null,  null, null, null);
        return productRepository.findById(productId)
                .orElse(product);
    }

    @Override
    public void delete(final Product product) {
        productRepository.delete(product);
    }
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
