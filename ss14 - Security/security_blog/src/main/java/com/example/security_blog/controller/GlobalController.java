package com.example.security_blog.controller;

import com.example.security_blog.model.Category;
import com.example.security_blog.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice
public class GlobalController {

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> addCategories() {
        return categoryService.findAll();
    }
}
