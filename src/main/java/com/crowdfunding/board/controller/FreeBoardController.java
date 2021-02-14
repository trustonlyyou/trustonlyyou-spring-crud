package com.crowdfunding.board.controller;

import com.crowdfunding.board.entity.FreeBoardVo;
import com.crowdfunding.board.service.FreeBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/crowdfunding/free")
public class FreeBoardController {

    private static final Logger logger = LoggerFactory.getLogger(FreeBoardController.class);

    @Autowired
    FreeBoardService service;

    @GetMapping("/board")
    public String board(HttpServletRequest request, Model model) {
        List<FreeBoardVo> boardVoList = new ArrayList<>();

        logger.info("Request URI :: '{}'", request.getRequestURI());

        try {
            boardVoList = service.getBoardList();
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }

        model.addAttribute("boardVoList", boardVoList);

        return "/free/board/list";
    }
}
