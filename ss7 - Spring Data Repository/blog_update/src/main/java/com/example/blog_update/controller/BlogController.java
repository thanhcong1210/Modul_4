package com.example.blog_update.controller;

import com.example.blog_update.model.Blog;
import com.example.blog_update.service.IBlogService;
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

    @GetMapping
    public String displayAllBlog(@RequestParam(value = "nameB", defaultValue = "") String nameB,
                                 @RequestParam(value = "page", defaultValue = "0") int page,
                                 Model model) {
        Sort sort = Sort.by("name").ascending();
        Page<Blog> blogPage = blogService.findAllByName(nameB, PageRequest.of(page, 5, sort));
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("nameB", nameB);
        model.addAttribute("page", page);
        return "home";
    }

    @GetMapping("/viewHi/{id}")
    public String viewIndex(@PathVariable("id") int id, Model model) {
        Blog blog = blogService.findById(id);
        System.out.println(blog);
        model.addAttribute("blog", blog);
        return "viewHi";
    }

    @GetMapping("/create")
    public String viewCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("category", categoryService.getAllCategories());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String viewEdit(@PathVariable("id") int id, Model model) {
        Optional<Blog> blog = blogService.findByIdOp(id);
        if (blog.isPresent()) {
            model.addAttribute("blog", blog.get());
            model.addAttribute("category", categoryService.getAllCategories());
            return "edit";
        } else {
            model.addAttribute("message", "Không có blog này");
            return "redirect:/blog";
        }
    }

    @PostMapping("/edit/{id}")
    public String edit(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/blog";
    }

    @PostMapping("/delete/{id}")
    public String deleteBlog(@PathVariable int id, RedirectAttributes redirect) {
        blogService.deleteById(id);
        redirect.addFlashAttribute("message", "Xóa thành công");
        return "redirect:/blog";
    }

    @GetMapping("/search")
    public @ResponseBody List<Blog> searchBlogs(@RequestParam(value = "nameBlog", defaultValue = "") String nameBlog) {
        return blogService.findAllByName(nameBlog, PageRequest.of(0, 10, Sort.by("name").descending())).getContent();
    }

    @GetMapping("/loadMore")
    public @ResponseBody List<Blog> loadMoreBlogs(@RequestParam(value = "page", defaultValue = "0") int page) {
        // Trả về các bài viết mới dựa trên số trang hiện tại và kích thước trang
        return blogService.findAllByName("", PageRequest.of(page, 10, Sort.by("name").descending())).getContent();
    }
}