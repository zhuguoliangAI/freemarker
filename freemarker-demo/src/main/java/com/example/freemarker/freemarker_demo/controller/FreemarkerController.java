package com.example.freemarker.freemarker_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FreemarkerController {
   @GetMapping("/hello")
    public String hello(Model model) {
       model.addAttribute("name", "zgl");
        return "hi";
    }
}
