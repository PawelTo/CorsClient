package pl.pawel.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = IndexController.API_PAHT)
public class IndexController {

    static final String API_PAHT = "/index-html";

    @GetMapping()
    public String getIndex(Model model){
        model.addAttribute("name", "test name");
        return "index";
    }
}
