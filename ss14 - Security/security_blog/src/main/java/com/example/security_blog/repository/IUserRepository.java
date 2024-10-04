package com.example.security_blog.repository;

import com.example.security_blog.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUserName(String username);
}
