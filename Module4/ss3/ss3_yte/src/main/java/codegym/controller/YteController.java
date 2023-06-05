package codegym.controller;

import codegym.model.Yte;
import codegym.service.YteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class YteController {
    @Autowired
    YteServiceImpl service;
    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("musicList",service.findAll());
        return "list";
    }
    @GetMapping("/upload")
    public String showUpload(Model model){
        model.addAttribute("music",new Yte());
        return "upload";
    }
    @PostMapping("upload")
    public String showUpdate(@ModelAttribute("music") Yte music){
        service.save(music);
        return "redirect:/list";
    }
}
