package codegym.controller;

import codegym.model.Product;
import codegym.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductServiceImpl productService;
    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("productList",productService.findAllProduct());
        model.addAttribute("categoryList",productService.findAllCategory());
        return "list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("categoryList",productService.findAllCategory());
        return "create";
    }
    @PostMapping("/create")
    public String doCreate(@ModelAttribute("product") Product product){
        productService.create(product);
        return "redirect:/list";
    }
    @GetMapping("/detail/{id}")
    public String showDetail(Model model,
                             @PathVariable("id") int id) {
        Product product = productService.findByIdProduct(id);
        model.addAttribute("product", product);
        model.addAttribute("categoryList",productService.findAllCategory());
        return "detail";
    }
    @GetMapping("/update")
    public String showUpdate(Model model, @RequestParam("id") int id){
        model.addAttribute("product",productService.findByIdProduct(id));
        model.addAttribute("categoryList",productService.findAllCategory());
        return "update";
    }
    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("product") Product product) {
        productService.update(product);
        return "redirect:/list";
    }
    @PostMapping("/search")
    public String searchByName(Model model, @RequestParam("name") String name){
        model.addAttribute("search_name",name);
        model.addAttribute("productList",productService.findByNameProduct(name));
        model.addAttribute("categoryList",productService.findAllCategory());
        return "list";
    }
    @GetMapping("/remove")
    public String removeProduct(Model model,@RequestParam("id") int id){
        productService.deleteByIdProduct(id);
        return "redirect:/list";
    }
}
