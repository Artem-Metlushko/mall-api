package com.trainee.controller;

import com.trainee.bean.Product;
import com.trainee.interfaces.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public Product save(final @RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/products/{productId}")
    public Product findById(final @PathVariable Long productId) {
        return productService.findById(productId);
    }

    @PutMapping("/products/{productId}")
    public Product update(
            final @PathVariable Long productId,
            final @RequestBody Product updatedProduct
    ) {
        Product existingProduct = productService.findById(productId);

        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setCategory(updatedProduct.getCategory());

            return productService.save(existingProduct);
        } else {
            return new Product(null, null, null, null,  null);
        }
    }

    @DeleteMapping("/products")
    public void delete(final @RequestBody Product product) {
        productService.delete(product);
    }

    @GetMapping("/products")
    public List<Product> findAll() {
        return productService.findAll();
    }


}
