package com.example.security_blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecurityController {

    @GetMapping(value = "/login")
    public String loginPage(Model mode, @RequestParam(value = "error", defaultValue = "")String error) {
        mode.addAttribute("error", error);
        return "security/login";
    }

    @GetMapping(value = "/logout")
    public String logoutPage(Model mode) {
        mode.addAttribute("title", "Logout");
        return "security/logout";
    }
}
