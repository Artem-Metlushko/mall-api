package com.trainee.service;

import com.trainee.bean.Category;
import com.trainee.interfaces.CategoryService;
import com.trainee.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceRest implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceRest(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Category save(final Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(final Long categoryId) {
        Category category = new Category(null, null, null, null, null, null);
        return categoryRepository.findById(categoryId).orElse(category);
    }

    @Override
    public void delete(final Category category) {
        categoryRepository.delete(category);
    }


    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
