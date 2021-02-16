package com.crowdfunding.free.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/crowdfunding/free/board/")
///crowdfunding/free/board/detail/
public class FreeBoardDetailController {

    @GetMapping("/detail")
    public void boardDetail(@RequestParam("num") int num, Model model) throws Exception {

    }
}
