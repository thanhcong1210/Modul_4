package com.example.security_blog.service.blog;

import com.example.security_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {

    void save(Blog blog);

    Blog findBlogById(Long id);

    void removeBlog(Long id);

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);

    Page<Blog> findAllByCategoryId(Long categoryId, Pageable pageable);
}
