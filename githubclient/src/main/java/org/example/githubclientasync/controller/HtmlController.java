package org.example.githubclientasync.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {
    @GetMapping("githubAll")
    public String githuball(){
        return "repos2";
    }
}
