package com.crowdfunding.free.board.controller;

import com.crowdfunding.free.board.entity.FreeBoardVo;
import com.crowdfunding.free.board.service.FreeBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/crowdfunding/free")
///crowdfunding/free/board/detail/
public class FreeBoardDetailController {

    private static final Logger logger = LoggerFactory.getLogger(FreeBoardDetailController.class);

    @Autowired
    FreeBoardService service;

    @GetMapping("/board/detail")
    public String boardDetail(@RequestParam("num") int num, Model model) throws Exception {
        FreeBoardVo data = new FreeBoardVo();

        try {
            data = service.getDetailData(num);
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        model.addAttribute("data", data);

        return "/free/board/detail";
    }
}
