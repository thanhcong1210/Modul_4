package com.example.web_blog.service.blog;

import com.example.web_blog.model.Blog;
import com.example.web_blog.service.IGenerateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService extends IGenerateService<Blog> {
    Page<Blog> findByCategory(int category, Pageable pageable);

    List<Blog> findAllBlog();

    List<Blog> findAllBlogByCategory(int category);

    List<Blog> findAllBlogTitle(String search);

    List<Blog> getBlogs(Pageable pageable);

    Page<Blog> findAllSort(PageRequest pageRequest);
}
