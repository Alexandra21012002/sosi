package com.example.repit.controllers;

import com.example.repit.entities.Tutor;
import com.example.repit.security.AuthDetails;
import com.example.repit.methods.TutorMethods;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class RepitProfileController {
    TutorMethods tutorMethods;
    @GetMapping("/repitProfile")
    public String RepitProfile(Model model){
        model.addAttribute("title", "Главная страница");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails authDetails = (AuthDetails) auth.getPrincipal();
        com.example.repit.entities.Authentication tut = authDetails.getAuthentication();
       Tutor tutor= tut.getTutor();
       model.addAttribute("fName", tutor.getFName());
       model.addAttribute("experience",tutor.getExperience());
        model.addAttribute("mobile", tutor.getMobile());
        model.addAttribute("city",tutor.getCity());
        model.addAttribute("workplace", tutor.getWorkPlace());
        return "repitProfile";
    }
}
