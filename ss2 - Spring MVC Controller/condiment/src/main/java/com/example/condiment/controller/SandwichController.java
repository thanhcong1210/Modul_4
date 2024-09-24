package com.example.condiment.controller;

import com.example.condiment.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    @Autowired
    private ISandwichService sandwichService;


    @GetMapping("hello")
    public String showForm(Model model) {
        String[] condiments = sandwichService.getAll();
        model.addAttribute("condiments", condiments);
        return "form";
    }

    @RequestMapping("save")
    public String save(@RequestParam("condiment") String[] condiments, Model model) {
        model.addAttribute("selected", condiments);
        return "list";
    }
}
