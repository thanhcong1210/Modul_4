package com.example.products.service;

import com.example.products.model.Product;

import java.util.List;

public interface IProductService {
    boolean create(Product product);

    boolean deleteById(int id);

    List<Product> findAll();

    Product findById(int id);
}
