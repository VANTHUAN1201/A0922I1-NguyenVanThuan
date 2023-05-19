package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller

public class DictionaryController {
    @GetMapping()
    public String showDirectory(){
        return "directory";
    }
    @GetMapping("search")
    public String directory(Model model, @RequestParam( "") String search){
        String result = null;
        Map<String, String> map = new LinkedHashMap<>();
        map.put("yellow", "vàng");
        map.put("blue", "xanh dương");
        map.put("Green", "xanh lá");
        map.put("red", "đỏ");
        map.put("black", "đen");
        map.put("white", "trắng");
        map.put("pink", "hồng");
        map.put("hello", "xin chào");
        map.put("teacher", "giáo viên");
        map.put("student", "học sinh");
        result = map.get(search);
        model.addAttribute("search",search);
        if (result!=null){
            model.addAttribute("result", result);
        }else {
            result="không tìm thấy";
            model.addAttribute("result", result);
        }
        return "directory";
    }
}
