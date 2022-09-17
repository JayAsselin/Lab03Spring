package com.example.lab03spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String accueil(){
        try {
            return "index";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
