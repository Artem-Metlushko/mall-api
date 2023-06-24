package com.trainee.controller;

import com.trainee.bean.Category;
import com.trainee.interfaces.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(final CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/categories")
    public Category save(final @RequestBody Category category) {
        return categoryService.save(category);
    }

    @GetMapping("/categories/{categoryId}")
    public Category findById(final @PathVariable Long categoryId) {
        return categoryService.findById(categoryId);
    }

    @PutMapping("/categories/{categoryId}")
    public Category update(
            final @PathVariable Long categoryId,
            final @RequestBody Category updatedCategory
    ) {
        Category existingCategory = categoryService.findById(categoryId);

        if (existingCategory != null) {
            existingCategory.setName(updatedCategory.getName());
            existingCategory.setDescription(updatedCategory.getDescription());
            existingCategory.setProductCount(updatedCategory.getProductCount());
            existingCategory.setImage(updatedCategory.getImage());
            existingCategory.setRating(updatedCategory.getRating());

            return categoryService.save(existingCategory);
        } else {
            return new Category(null, null, null, null, null, null);
        }
    }

    @DeleteMapping("/categories")
    public void deleteCategory(final @RequestBody Category category) {
        categoryService.delete(category);
    }

    @GetMapping("/categories")
    public List<Category> findAll() {
        return categoryService.findAll();
    }
}
