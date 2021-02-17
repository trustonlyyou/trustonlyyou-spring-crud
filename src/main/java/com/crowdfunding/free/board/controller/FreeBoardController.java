package com.crowdfunding.free.board.controller;

import com.crowdfunding.commons.util.Criteria;
import com.crowdfunding.commons.util.PageMaker;
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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/crowdfunding/free")
public class FreeBoardController {

    private static final Logger logger = LoggerFactory.getLogger(FreeBoardController.class);

    @Autowired
    FreeBoardService service;

    @GetMapping("/board/listPage")
    public String listPage(Model model, Criteria criteria) throws Exception {
        List<FreeBoardVo> list = new ArrayList<>();
        PageMaker pageMaker = new PageMaker();
        int countingData = 0;

        try {
            list = service.getBoardList(criteria);
            countingData = service.getCountingData(criteria);

            pageMaker.setCriteria(criteria);
            pageMaker.setTotalCount(countingData);

        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }

        model.addAttribute("list", list);
        model.addAttribute("pageMaker", pageMaker);

        return "/free/board/listPage";
    }

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

