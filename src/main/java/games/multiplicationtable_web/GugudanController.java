package games.multiplicationtable_web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gugu")
public class GugudanController {

    @GetMapping
    public String showMenu(Gugudan gugudan) {
        return "gugu/gugudan";
    }

    @PostMapping("/gugudan")
    public String showGugudan(Gugudan gugudan, Model model) {
        int dan = gugudan.getDan();
        model.addAttribute("dan", dan);
        return "gugu/gugudan";
    }

    @GetMapping("/all")
    public String showAllGugu(Model model) {
        model.addAttribute("allGugu", true);
        return "gugu/all-gugudan";
    }
}
