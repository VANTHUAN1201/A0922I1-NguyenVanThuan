package codegym.controller;

import codegym.model.Gmail;
import codegym.service.GmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GmailController {
    @Autowired
    GmailServiceImpl service;
    @GetMapping("index")
    public String show(Model model){
        model.addAttribute("gmail",service.findGmail());
        return ("index");
    }
    @GetMapping("update")
    public String showUpdate(Model model){
        model.addAttribute("gmail", service.findGmail());
        return "update";
    }
    @PostMapping("update")
    public String showUpdate(@ModelAttribute("gmail") Gmail gmail){
        service.update(gmail);
        return "redirect:/index";
    }
}
