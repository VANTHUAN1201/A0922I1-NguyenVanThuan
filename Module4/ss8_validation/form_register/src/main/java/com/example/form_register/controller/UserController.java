package com.example.form_register.controller;

import com.example.form_register.model.User;
import com.example.form_register.service.IUserService;
import com.example.form_register.validate.UserValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    IUserService service;
    @Autowired
    UserValidate  userValidate;
    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("userList",service.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute(new User());
        return "create";
    }
    @PostMapping("/create")
    public String doCreate(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
        userValidate.validate(user,bindingResult);
        if(bindingResult.hasErrors()){
            return "create";
        }
        service.create(user);
        model.addAttribute("messenger","Successfully");
        return "redirect:list";
    }

}
