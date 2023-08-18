package com.sunday.sundaycustom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ViewController {

    @GetMapping("/signup")
    public String ShowSginupForm() {
        return "signup";
    }

    @GetMapping("/customize")
    public String ShowCustomize() {
        return "customize";
    }
}
