package org.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {
    @GetMapping("/form")
    public String showForm(){
        return "form";
    }

    @PostMapping("/submitForm")
    public String submitForm(){
        return "result";
    }
}
