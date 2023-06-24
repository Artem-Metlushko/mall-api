package com.trainee.interfaces;

import com.trainee.bean.Category;

import java.util.List;

public interface CategoryService {

    Category save(Category category);
    Category findById(Long categoryId);
    void delete(Category category);
    List<Category> findAll();

}
