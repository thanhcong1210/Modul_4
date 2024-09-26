package com.example.from_dang_ky.controller;

import com.example.from_dang_ky.dto.UserDTO;
import com.example.from_dang_ky.model.User;
import com.example.from_dang_ky.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String displayUser(Model model) {
        model.addAttribute("users", userService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("userDTO", new User());
        return "index";
    }

    @PostMapping("/index")
    public String createUser(@Validated @ModelAttribute("userDTO") UserDTO userDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        new UserDTO().validate(userDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "index";
        }

        User user = new User();
        BeanUtils.copyProperties(userDTO, user);

        userService.save(user);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/user";
    }
}
