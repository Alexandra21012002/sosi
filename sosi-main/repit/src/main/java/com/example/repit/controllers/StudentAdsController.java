package com.example.repit.controllers;

import com.example.repit.entities.Advertisement;
import com.example.repit.methods.AdvertisementMethods;
import com.example.repit.security.AuthDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentAdsController {

    @Autowired
    AdvertisementMethods advertisementMethods;

    @GetMapping("/StudentAds")
    public String StudentAds(Model model){

      List<Advertisement> advertisementList = advertisementMethods.getAll();

        model.addAttribute("advertisementList",advertisementList);

        return "StudentAds";
    }
}
