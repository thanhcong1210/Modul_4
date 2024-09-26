package com.example.blog_update.controller;

import com.example.blog_update.model.Blog;
import com.example.blog_update.model.Category;
import com.example.blog_update.service.IBlogService;
import com.example.blog_update.service.CategoryService;
import com.example.blog_update.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String displayAllBlogs(Model model,
                                  @RequestParam(value = "nameBlog", defaultValue = "") String nameBlog,
                                  @RequestParam(value = "page", defaultValue = "0") int page) {
        Sort sort = Sort.by("name").ascending();
        Page<Blog> blogs = blogService.findAllByName(nameBlog, PageRequest.of(page, 10, sort));
        model.addAttribute("blogs", blogs);
        model.addAttribute("nameBlog", nameBlog);
        model.addAttribute("currentPage", page);
        return "blog/list";
    }


    @GetMapping("/create")
    public String viewCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "blog/create";
    }

    @PostMapping("/create")
    public String newBlog(@ModelAttribute("blog") Blog blog,
                          BindingResult bindingResult,
                          RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()) {
            return "blog/create";
        }
        blogService.save(blog);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/blog";
    }

    @GetMapping("/update/{id}")
    public String viewUpdate(@PathVariable int id, Model model) {
        Optional<Blog> blog = blogService.findByIdOptional(id);
        if(blog.isPresent()) {
            model.addAttribute("blog", blog.get());
            model.addAttribute("categories", categoryService.getAllCategories());
            return "blog/update";
        } else {
            model.addAttribute("message", "Blog bạn xem không tồn tại");
            return "redirect:/blog";
        }
    }

    @PostMapping("/update/{id}")
    public String save(@ModelAttribute Blog blog, RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/blog";
    }

    @GetMapping("/detail/{id}")
    public String viewDetail(@PathVariable("id") int id, Model model) {
        Optional<Blog> blog = blogService.findByIdOptional(id);
        if (blog.isPresent()) {
            model.addAttribute("blog", blog.get());
            return "blog/detail";
        }
        model.addAttribute("message", "Blog bạn xem không tồn tại");
        return "redirect:/blog";
    }

    @GetMapping("/search")
    public @ResponseBody List<Blog> searchBlogs(@RequestParam(value = "nameBlog", defaultValue = "") String nameBlog) {
        return blogService.findAllByName(nameBlog, PageRequest.of(0, 10, Sort.by("name").descending())).getContent();
    }

    @PostMapping("/delete/{id}")
    public String deleteBlog(@PathVariable int id, RedirectAttributes redirect) {
        blogService.deleteById(id);
        redirect.addFlashAttribute("message", "Xóa thành công");
        return "redirect:/blog";
    }

    @GetMapping("/loadMore")
    public @ResponseBody List<Blog> loadMoreBlogs(@RequestParam(value = "page", defaultValue = "0") int page) {
        // Trả về các bài viết mới dựa trên số trang hiện tại và kích thước trang
        return blogService.findAllByName("", PageRequest.of(page, 10, Sort.by("name").descending())).getContent();
    }
}