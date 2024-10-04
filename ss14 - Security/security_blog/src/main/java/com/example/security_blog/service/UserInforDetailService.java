package com.example.security_blog.service;

import com.example.security_blog.dto.UserInforUserDetails;
import com.example.security_blog.model.AppUser;
import com.example.security_blog.model.UserRole;
import com.example.security_blog.repository.IUserRepository;
import com.example.security_blog.repository.IUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInforDetailService implements UserDetailsService {

    @Autowired
    private IUserRepository appUserRepository;

    @Autowired
    private IUserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUserName(username);
        // lấy tất cả role của App User

        List<UserRole> userRoles = userRoleRepository.findAllByAppUser(appUser);
        UserInforUserDetails inforUserDetails = new UserInforUserDetails(appUser, userRoles);
        return inforUserDetails;
    }
}
