package com.example.web_blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGenerateService<T> {

    Page<T> findAll(Pageable pageable);

    void save(T t);

    Optional<T> findById(int id);

    void remove(int id);

    Page<T> findByTitle( Pageable pageable);
}