package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.blog.IBlogService;
import com.example.demo.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "blogs")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public String index(Model model, @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Blog> blogPage = blogService.findAll(pageable);
        model.addAttribute("blogPage", blogPage);
        return "blog/index";
    }

    @GetMapping("/category/{id}")
    public String listByCategory(@PathVariable Long id, Model model,
                                 @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Blog> blogPage = blogService.findAllByCategoryId(id, pageable);
        model.addAttribute("blogPage", blogPage);
        return "blog/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.findAll());
        return "blog/create";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blogs/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        blogService.removeBlog(id);
        return "redirect:/blogs/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findBlogById(id));
        return "blog/detail";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findBlogById(id));
        return "blog/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blogs/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model,
                         @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Blog> blogPage = blogService.findByTitleContaining(keyword, pageable);
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("keyword", keyword);
        return "blog/index";
    }


}
