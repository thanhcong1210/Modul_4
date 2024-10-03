package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public String index(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "category/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/categories/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        categoryService.removeCategory(id);
        return "redirect:/categories/list";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("category", categoryService.findCategoryById(id));
        return "category/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/categories/list";
    }
}
