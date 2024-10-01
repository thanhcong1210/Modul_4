package com.example.products.service;

import com.example.products.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Long id);

    Product findProductById(Long id);
}
