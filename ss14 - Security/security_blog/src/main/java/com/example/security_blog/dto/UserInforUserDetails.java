package com.example.security_blog.dto;

import com.example.security_blog.model.AppUser;
import com.example.security_blog.model.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserInforUserDetails implements UserDetails {

    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

    public UserInforUserDetails(AppUser appUser, List<UserRole> userRoles) {
        username = appUser.getUserName();
        password = appUser.getEncryptedPassword();
        authorities = new ArrayList<>();
        if (userRoles != null) {
            for (UserRole userRole : userRoles) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userRole.getAppRole().getRoleName());
                authorities.add(grantedAuthority);
            }
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
