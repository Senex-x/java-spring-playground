package com.example.spring_boot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "Иван");
        return "hello";
    }
}
