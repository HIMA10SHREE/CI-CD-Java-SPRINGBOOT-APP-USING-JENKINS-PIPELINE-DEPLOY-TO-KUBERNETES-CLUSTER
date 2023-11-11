package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import com.example.demo.model.User;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {

        return "index";
    }

    @PostMapping("/register")
    public String userLogin(@ModelAttribute User user, Model model) {
        model.addAttribute("firstname", user.getFname());
        model.addAttribute("lastname", user.getLname());

        return "welcome";
    }

}
