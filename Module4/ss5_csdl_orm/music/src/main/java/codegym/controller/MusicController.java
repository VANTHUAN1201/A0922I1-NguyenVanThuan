package codegym.controller;

import codegym.entity.Music;
import codegym.service.IMusicService;
import codegym.service.MusicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MusicController {
    @Autowired
    IMusicService service;
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
