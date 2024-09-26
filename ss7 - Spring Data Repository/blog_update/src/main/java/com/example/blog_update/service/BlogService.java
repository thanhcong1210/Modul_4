package com.example.blog_update.service;

import com.example.blog_update.model.Blog;
import com.example.blog_update.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Page<Blog> findAllByName(String name, Pageable pageable) {
        return blogRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public void deleteById(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Optional<Blog> findByIdOp(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public List<Blog> findByCategoryId(Long id) {
        return blogRepository.findByCategoryId(id);
    }
}