package com.example.security_blog.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "app_user", uniqueConstraints = {@UniqueConstraint(name = "APP_USER_UK", columnNames = "user_name")})

public class AppUser {

    @Id
    @GeneratedValue
    @Column(name = "user_id",nullable = false)
    private Long userId;

    @Column(name = "user_name", length = 40, nullable = false)
    private String userName;

    @Column(name = "encrypted_password", length = 100, nullable = false)
    private String encryptedPassword;

    @Column(name = "enabled", length = 1, nullable = false)
    private boolean enabled;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
