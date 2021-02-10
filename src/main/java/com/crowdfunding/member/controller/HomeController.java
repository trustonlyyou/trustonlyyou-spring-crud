package com.crowdfunding.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

//    @GetMapping(value = "/")
    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String homePage() {
        return "index";
    }

}
