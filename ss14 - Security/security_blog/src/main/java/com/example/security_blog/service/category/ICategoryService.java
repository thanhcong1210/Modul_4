package com.example.security_blog.service.category;

import com.example.security_blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    Category findCategoryById(Long id);

    void removeCategory(Long id);
}
