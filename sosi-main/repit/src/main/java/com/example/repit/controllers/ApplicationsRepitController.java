package com.example.repit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationsRepitController {
    @GetMapping("/ApplicationsRepit")
    public String ApplicationsRepit(Model model){
        model.addAttribute("title", "Главная страница");
        return "ApplicationsRepit";
    }
}
