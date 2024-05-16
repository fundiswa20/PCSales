package com.example.pcsale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/user/home")
    public String goHome()
    {
        return "homepage";
    }

}
