package com.example.ss1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {

    @GetMapping("/currency")
    public String currency(){
        return "currency";
    }

    @PostMapping("/result")
    public String result(@RequestParam("usd") int usd, @RequestParam("amount") int amount, Model model){
        double vnd = usd * amount;
        model.addAttribute("amount", amount);
        model.addAttribute("usd", usd);
        model.addAttribute("vnd", vnd);

        return "result";
    }
}