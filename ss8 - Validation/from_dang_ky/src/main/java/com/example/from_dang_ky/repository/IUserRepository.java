package com.example.from_dang_ky.repository;

import com.example.from_dang_ky.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
