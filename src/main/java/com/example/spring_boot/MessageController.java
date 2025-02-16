package com.example.spring_boot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MessageController {

    @GetMapping("/message")
    public String greetingForm(Model model) {
        model.addAttribute("message", new Message());
        return "message";
    }

    @PostMapping("/message")
    public String greetingSubmit(@ModelAttribute Message message, Model model) {
        model.addAttribute("message", message);
        return "result";
    }
}