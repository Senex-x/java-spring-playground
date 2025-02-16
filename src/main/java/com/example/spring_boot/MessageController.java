package com.example.spring_boot;

import com.example.spring_boot.bean.TruthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MessageController {

    @Autowired
    TruthProvider provider;

    @GetMapping("/message")
    public String greetingForm(Model model) {
        model.addAttribute("message", new Message());
        provider.provide();
        return "message";
    }

    @PostMapping("/message")
    public String greetingSubmit(@ModelAttribute Message message, Model model) {
        model.addAttribute("message", message);
        return "result";
    }
}