package codegym.controller;

    import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import codegym.service.IServiceCaculator;

    import java.util.Objects;

@Controller
public class CaculatorController {
    @Autowired IServiceCaculator serviceCaculator;
    @GetMapping("")
    public String caculator(){
        return "index";
    }

    @PostMapping("caculator")
    public String caculator(@RequestParam("num1") double num1, @RequestParam("num2") double num2,
                            @RequestParam("calculation") String calculation, Model model) {
        if ((num2==0.0) &&(Objects.equals(calculation, "/"))){
            model.addAttribute("num1",num1);
            model.addAttribute("num2",num2);
            model.addAttribute("result", "Không thể thực hiện phép chia!");
        }else {
            model.addAttribute("num1",num1);
            model.addAttribute("num2",num2);
            model.addAttribute("result", serviceCaculator.caculator(num1, num2, calculation));
        }
        return "index";

    }

}
