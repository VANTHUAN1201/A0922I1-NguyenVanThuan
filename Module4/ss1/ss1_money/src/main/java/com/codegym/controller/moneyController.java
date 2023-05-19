package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class moneyController {
    @GetMapping (value="/money")
    public String moneyGet( ){
        return "money";
    }
    @PostMapping(value="/money")
    public String money(@RequestParam("t_usd") int usd,Model model){
        model.addAttribute("usd",usd);
        return "money";
    }
}
