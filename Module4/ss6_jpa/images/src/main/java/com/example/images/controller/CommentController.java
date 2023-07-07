package com.example.images.controller;

import com.example.images.entity.Comment;
import com.example.images.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentRepository;

    @GetMapping("/comment")
    public String showList(Model model, @PageableDefault(value = 2)Pageable pageable) {
        model.addAttribute("comment", new Comment());
        model.addAttribute("comments", commentRepository.findAll(pageable));
        return "show";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("comment") Comment comment, @RequestParam("id") int id) {
        commentRepository.create(comment);
        return "redirect:/comment";
    }

    @GetMapping("/update/{id}")
    public String doUpdate(@PathVariable("id") int id) {
        Comment comment = commentRepository.findById(id);
        commentRepository.update(comment);
        return "redirect:/comment";
    }
}
