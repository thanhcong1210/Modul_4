package com.example.products.controller;

import com.example.products.model.Cart;
import com.example.products.model.Product;
import com.example.products.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setUpCart() {
        return new Cart();
    }


    @GetMapping("/list-demo")
    public String cart(Model model, @SessionAttribute("cart") Cart cart) {
        model.addAttribute("cart", cart);
        return "cart/list-demo";
    }


    @GetMapping("/pum")
    public String payment(@RequestParam(value = "product", required = false) int[] id, Model model, @SessionAttribute("cart") Cart cart) {
        if (id == null || id.length == 0) {
            model.addAttribute("error", "Bạn chưa chọn sản phẩm nào.");
            return "cart/list-demo";
        }

        int sum = 0;
        for (int i : id) {
            Product product = productService.findById(i);
            sum += product.getPrice() * cart.selectItems(product).getValue();
        }
        model.addAttribute("cart", cart);
        model.addAttribute("result", sum);
        return "cart/list-demo";
    }


    @GetMapping("updateUp/{id}")
    public String increase(Model model, @SessionAttribute("cart") Cart cart, @PathVariable("id") int id) {
        int quantity = cart.selectItems(productService.findById(id)).getValue() + 1;
        cart.selectItems(productService.findById(id)).setValue(quantity);
        return "redirect:/cart/list-demo";

    }

    @GetMapping("updateDown/{id}")
    public String decrease(Model model, @SessionAttribute("cart") Cart cart, @PathVariable("id") int id) {
        int quantity = cart.selectItems(productService.findById(id)).getValue() - 1;
        if (quantity < 0) {
            cart.selectItems(productService.findById(id)).setValue(0);
            return "redirect:/cart/list-demo";
        }
        cart.selectItems(productService.findById(id)).setValue(quantity);
        return "redirect:/cart/list-demo";
    }

    @GetMapping("/delete")
    public String deleteCart(@RequestParam("id") int key, @SessionAttribute("cart") Cart cart) {
        cart.deleteItems(key);
        return "redirect:/cart/list-demo";


    }
}
