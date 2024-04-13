package com.catalog.catalogmicroservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    //Serve a spring per il redirect alla login page
    @GetMapping()
    public String example(Model model) {
        return "login";
    }
}
