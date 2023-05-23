package com.example.repit.controllers;

import com.example.repit.entities.Lesson;
import com.example.repit.entities.Student;
import com.example.repit.methods.StudentMethods;
import com.example.repit.security.AuthDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudProfileController {
    StudentMethods studentMethods;

    @GetMapping("/studProfile")
    public String StudProfile(
                              Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails authDetails = (AuthDetails) auth.getPrincipal();
        com.example.repit.entities.Authentication stud = authDetails.getAuthentication();
        Student student = stud.getStudent();
        model.addAttribute("fName", student.getfName());
        model.addAttribute("yearsOld", student.getYearsOld());
        model.addAttribute("mobile", student.getMobile());
        model.addAttribute("city", student.getCity());


        List<Lesson> lessonList = new ArrayList<>();
        lessonList = student.getLessons();
        model.addAttribute("lessonList", lessonList);





        return "studProfile";
    }

//    @PostMapping("/studProfile")
//    public String info(
//            @RequestParam(name = "fName", defaultValue = "Артем") String name,
//            Model model){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        AuthDetails authDetails = (AuthDetails) auth.getPrincipal();
//        com.example.repit.entities.Authentication stud = authDetails.getAuthentication();
//        Student student = stud.getStudent();
//        model.addAttribute("fName", student.getfName());
//        return "redirect:/studProfile";
//    }
//}
}
