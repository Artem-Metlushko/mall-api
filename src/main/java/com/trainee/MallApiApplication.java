package com.trainee;

import com.trainee.bean.Category;
import com.trainee.bean.Product;
import com.trainee.interfaces.ProductService;
import com.trainee.repository.CategoryRepository;
import com.trainee.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MallApiApplication {

    private Long categoryId;
    private String name;
    private String description;
    private Integer productCount;
    private String image;
    private Double rating;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MallApiApplication.class, args);
        /*ProductService productService = context.getBean(ProductService.class);
        CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        Category category = new Category(111L, "qwewqe", "category1", 12, "image1", 5.5);

        Category save = categoryRepository.save(category);
        Category category1 = categoryRepository.findById(save.getCategoryId()).orElse(category);
//        categoryRepository.delete(category1);


      *//*  Product product = new Product(1L, "product1", 100.0, "description1", true, category1);

        productRepository.save(product);*/
    }

}
