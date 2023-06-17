package codegym.vn.controller;

import codegym.vn.entity.Blog;
import codegym.vn.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class BlogController {
    @Autowired
    BlogService service;
    @GetMapping("/list")
    public String showBlog(Model model){
        model.addAttribute("blog",service.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String showCreateBlog(Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }
    @PostMapping("/create")
    public String doCreate(@ModelAttribute("blog") Blog blog) {

        service.create(blog);
        return "redirect:/list";
    }
    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") int id, Model model) {
        model.addAttribute("blog", service.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("blog") Blog blog) {
      service.update(blog);
        return "redirect:/list";
    }
    @GetMapping("/detail")
    public String showDetail(@RequestParam("id") int id, Model model) {
        Blog blog = service.findById(id);
        model.addAttribute("blog", blog);
        return "detail";
    }
}
