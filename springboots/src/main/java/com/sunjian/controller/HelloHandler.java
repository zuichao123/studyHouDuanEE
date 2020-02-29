package com.sunjian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloHandler {

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("flag", true);
        return "index";
    }
}
