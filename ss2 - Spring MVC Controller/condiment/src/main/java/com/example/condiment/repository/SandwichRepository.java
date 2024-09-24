package com.example.condiment.repository;

import org.springframework.stereotype.Repository;

@Repository
public class SandwichRepository implements ISandwichRepository{
    @Override
    public String[] getAll() {
        return new String[]{"Lettuce", "Tomato", "Mustard", "Sprouts"};
    }
}
