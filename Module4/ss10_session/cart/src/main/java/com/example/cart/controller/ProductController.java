package com.example.cart.controller;

import com.example.cart.model.Cart;
import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    IProductService service;
    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }
    @GetMapping("/shop")
    public String showShop(Model model) {
        model.addAttribute("products",service.findAll());
        return "/shop";
    }
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable int id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = service.findById(id);
        if (action.equals("add")) {
            cart.addProduct(productOptional.get());
            return "redirect:/cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }
    @GetMapping("/del/{id}")
    public String deleteCart(@PathVariable int id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = service.findById(id);
        if (action.equals("delete")){
            cart.removeProduct(productOptional.get());
            return "redirect:/cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }
}
