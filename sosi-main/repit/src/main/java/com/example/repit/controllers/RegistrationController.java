package com.example.repit.controllers;

import com.example.repit.entities.Authentication;
import com.example.repit.enums.Role;
import com.example.repit.methods.AuthenticationMethods;
import com.example.repit.repositories.AuthenticationRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Enumeration;
import java.util.Map;
import java.util.Optional;

@Controller
public class RegistrationController {
    @Autowired
    private AuthenticationMethods authenticationMethods;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(Authentication authentication, @RequestParam("radioName")Role role){
//        Optional<Authentication> OptUserFromDb = authenticationRepository.findBylogin(authentication.get_login());
//        Authentication userFromDb = OptUserFromDb.get();

//        authentication.setRole("student");

//        Enumeration<String> enumeration = request.getParameterNames();
//        enumeration;
//        System.out.println("asd");
          authentication.setRole(role);
          authenticationMethods.save(authentication);

        return "redirect:/login";
    }

}
