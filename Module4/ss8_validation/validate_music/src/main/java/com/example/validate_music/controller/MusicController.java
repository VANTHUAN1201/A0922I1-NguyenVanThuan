package com.example.validate_music.controller;

import com.example.validate_music.model.Music;
import com.example.validate_music.service.IMusicService;
import com.example.validate_music.validate.MusicValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class MusicController {
    @Autowired
    IMusicService service;
    @Autowired
    MusicValidate musicValidate;

    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("musicList",service.findAll());
        return "list";
    }
    @GetMapping("/upload")
    public String showCreate(Model model){
        model.addAttribute("music", new Music());
        return "upload";
    }
    @PostMapping("/upload")
    public String doCreate(@Valid @ModelAttribute("music") Music music, BindingResult bindingResult) {
        musicValidate.validate(music, bindingResult);
        if(bindingResult.hasErrors()){
            return "upload";
        }
        service.create(music);
        return "redirect:list";
    }
}
