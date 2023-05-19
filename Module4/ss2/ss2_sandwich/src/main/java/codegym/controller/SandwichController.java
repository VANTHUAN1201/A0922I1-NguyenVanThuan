package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("")
    public String sandwich(){
        return "index";
    }
    @PostMapping("save")
    public String save(Model model,@RequestParam("condiment") String[] condiment){
        model.addAttribute("result",condiment);
        return "index";
    }
//    @PostMapping("save")
//    public String submitForm(Model model, @RequestParam(name = "lettuce", defaultValue =" ") String lettuce,
//                             @RequestParam(name = "tomato", defaultValue =" ") String tomato,
//                             @RequestParam(name = "mustard", defaultValue =" ") String mustard,
//                             @RequestParam(name = "sprouts", defaultValue =" ") String sprouts){
//        model.addAttribute("result", tomato+" "+lettuce+" "+mustard+" "+sprouts);
//        if(tomato.equals("") && lettuce.equals("") && mustard.equals("") && sprouts.equals("")){
//            model.addAttribute("result","Không có gia vị nào cả");
//        }
//        return "index";
//    }
}
