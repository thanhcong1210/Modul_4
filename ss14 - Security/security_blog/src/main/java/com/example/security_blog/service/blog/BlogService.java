package com.example.security_blog.service.blog;

import com.example.security_blog.model.Blog;
import com.example.security_blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findBlogById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void removeBlog(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByTitleContaining(String title, Pageable pageable) {
        return blogRepository.findAllByTitleContaining(title, pageable);
    }

    @Override
    public Page<Blog> findAllByCategoryId(Long categoryId, Pageable pageable) {
        return blogRepository.findAllByCategoryId(categoryId, pageable);
    }
}
