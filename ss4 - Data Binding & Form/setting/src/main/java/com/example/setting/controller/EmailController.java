package com.example.setting.controller;

import com.example.setting.model.Email;
import com.example.setting.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("email")
public class EmailController {

    @Autowired
    private IEmailService emailService;

    @GetMapping("")
    public String emailList(Model model) {
        Email email = new Email();
        model.addAttribute("emailList", email);
        String[] language = new String[]{"Vietnamese", "English", "Germany", "Australia"};
        model.addAttribute("language", language);
        int[] size = new int[]{5, 10, 15, 25, 50, 100};
        model.addAttribute("size", size);
        return "home";
    }

    @PostMapping("")
    public String save(@ModelAttribute Email email, Model model, RedirectAttributes redirectAttributes) {

        String email1 = String.valueOf(emailService.save(email));;
        model.addAttribute("emailList", email1);
        redirectAttributes.addFlashAttribute("message", "thêm mới thành công");
        return "home";
    }
}
