package com.example.blog_update.service;

import com.example.blog_update.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category findById(Long id);

    List<Category> getAllCategories();
}
