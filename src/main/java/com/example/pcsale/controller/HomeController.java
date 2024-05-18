package com.example.pcsale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("userid")
public class HomeController {

    @GetMapping("/user/home")
    public String goHome()
    {
        return "homepage";
    }

}
