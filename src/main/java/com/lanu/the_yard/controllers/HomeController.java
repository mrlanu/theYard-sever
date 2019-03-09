package com.lanu.the_yard.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String getHomePage(){
        return "Welcome to theYard by Lanu";
    }
}
