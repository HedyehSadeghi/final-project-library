package org.learning.finalprojectlibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("home")
    private String home() {
        return "home/landing-page";
    }

    @GetMapping()
    private String index() {
        return "home/landing-page";
    }
}
