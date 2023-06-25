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
    public static void main(final String[] args) {
        SpringApplication.run(MallApiApplication.class, args);

    }

}
