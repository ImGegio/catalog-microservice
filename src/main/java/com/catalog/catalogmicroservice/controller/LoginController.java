package com.catalog.catalogmicroservice.controller;

import com.catalog.catalogmicroservice.model.LoginRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @GetMapping()
    public String example(Model model) {
        return "login";
    }
}
