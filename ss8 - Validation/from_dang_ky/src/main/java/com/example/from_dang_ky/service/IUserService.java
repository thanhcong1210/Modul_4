package com.example.from_dang_ky.service;

import com.example.from_dang_ky.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void save(User user);
}
