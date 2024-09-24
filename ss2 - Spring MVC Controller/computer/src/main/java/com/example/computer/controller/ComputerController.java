package com.example.computer.controller;

import com.example.computer.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("computer")
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @GetMapping
    public String computer() {
        return "/list";
    }

    @PostMapping
    public String computer(@RequestParam(defaultValue ="0", required = false) double first,
                           @RequestParam(defaultValue = "0", required = false) double second,
                           @RequestParam("item") String item, Model model) {
        try {
            double result = computerService.computer(first, second, item);
            model.addAttribute("result", result);
            return "/list";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "/list";
    }

}
