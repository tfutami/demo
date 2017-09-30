package com.example.demo.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {
    @RequestMapping("/home")
    public String mapping(Model model){
        return "mainpage";
    }
}
