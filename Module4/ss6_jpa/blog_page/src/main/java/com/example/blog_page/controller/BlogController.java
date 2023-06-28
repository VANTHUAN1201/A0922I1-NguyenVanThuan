package com.example.blog_page.controller;

import com.example.blog_page.model.Blog;
import com.example.blog_page.model.Category;
import com.example.blog_page.service.IBlogService;
import com.example.blog_page.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;
    @GetMapping("/trangchu")
    public String trangchu(Model model){
        List<Blog> blogList=blogService.findAll();
        model.addAttribute("blogList",blogList);
        return "blog/trangchu";
    }
    @GetMapping("")
    public String danhmuc(Model model){
        List<Category> categoryList=categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        return "template/sidebar";
    }
    @GetMapping("/create")
    public String viewCreate(Model model) {
        List<Category> categories = categoryService.findAll();
        Blog blog = new Blog();
        blog.setCategory(new Category());
        model.addAttribute("blog", blog);
        model.addAttribute("categories", categories);
        return "/blog/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("blog") Blog blog,
                         Model model) {
        blogService.create(blog);
        return "redirect:/blog/trangchu";
    }
    @GetMapping("/update")
    public String viewUpdate(Model model, @RequestParam("id") int id){
        List<Category> categories = categoryService.findAll();
        Blog blog=blogService.findById(id);
        model.addAttribute("blog",blog);
        model.addAttribute("categories", categories);
        return "blog/update";
    }
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("blog") Blog blog,
                         Model model) {
        blogService.update(blog);
        return "redirect:/blog/trangchu";
    }
    @GetMapping("/view")
    public String viewStudentByParam(@RequestParam("id") int id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "/blog/view";
    }
    @GetMapping(value = "/list")
    public String listPaging(Model model, @RequestParam("page") Optional<Integer> page,
                             @RequestParam("size") Optional<Integer> size,
                             @RequestParam("sort") Optional<String> sort) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(2);
//        String sortField = sort.orElse("date");
//        Sort sortBy = Sort.by("date").descending().and(Sort.by("date").ascending());
        Page<Blog> blogList = blogService.findAllPage(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("blogList", blogList);
        int totalPages = blogList.getTotalPages();
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "blog/list";
    }
}
