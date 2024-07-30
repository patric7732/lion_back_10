package org.example.githubclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class htmlController {
    @GetMapping("/gitrepos")
    public String repos(){
        return "repos";
    }
}
