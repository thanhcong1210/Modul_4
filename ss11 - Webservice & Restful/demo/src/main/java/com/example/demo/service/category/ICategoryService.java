package com.example.demo.service.category;

import com.example.demo.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    Category findCategoryById(Long id);

    void removeCategory(Long id);
}
