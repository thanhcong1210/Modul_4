package com.example.products.controller;

import com.example.products.model.Cart;
import com.example.products.model.Product;
import com.example.products.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public String showShop(Model model) {
        model.addAttribute("products", productService.findAll());
        return "shop";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "error404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/change/{id}")
    public String changeQuantity(@PathVariable Long id,
                                 @ModelAttribute Cart cart,
                                 @RequestParam("quantity") int quantity) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            cart.updateProduct(productOptional.get(), quantity);
        }
        return "redirect:/shopping-cart";
    }

    @GetMapping("/remove/{id}")
    public String removeFromCart(@PathVariable Long id,
                                 @ModelAttribute Cart cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            cart.removeProduct(productOptional.get());
        } else {
            return "error404";
        }
        return "redirect:/shopping-cart";
    }

    @GetMapping("{id}/detail")
    public String showDetail(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "detail";
    }
}
