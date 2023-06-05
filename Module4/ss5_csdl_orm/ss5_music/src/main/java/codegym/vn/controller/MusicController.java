package codegym.vn.controller;

import codegym.vn.entity.Music;
import codegym.vn.service.MusicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class MusicController {
    @Autowired
    MusicServiceImpl service;
    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("musicList",service.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("music", new Music());
        return "upload";
    }
    @PostMapping("/create")
    public String doCreate(@ModelAttribute("music") Music music) {
       service.create(music);
        return "redirect:list";
    }

}
