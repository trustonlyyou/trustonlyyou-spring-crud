package com.crowdfunding.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping(value = "/")
    public String homePage() {
        return "index";
    }

//    @GetMapping(value = "/home")
//    public String homePage() {
//        return "index";
//    }
}
