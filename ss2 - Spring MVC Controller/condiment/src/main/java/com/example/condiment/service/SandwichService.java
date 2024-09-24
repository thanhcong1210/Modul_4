package com.example.condiment.service;

import com.example.condiment.repository.ISandwichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SandwichService implements ISandwichService{

    @Autowired
    private ISandwichRepository sandwichRepository;

    @Override
    public String[] getAll() {
        return sandwichRepository.getAll();
    }
}
