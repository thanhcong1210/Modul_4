package com.example.products.controller;

import com.example.products.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingController {

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart(@SessionAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }

    @PostMapping("/checkout")
    public String checkout(@SessionAttribute("cart") Cart cart) {
        cart.getProducts().clear();
        return "redirect:/success";
    }

    @PostMapping("/check-success")
    public String showCheckSuccess() {
        return "check-success";
    }
}
